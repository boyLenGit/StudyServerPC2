package len.cloud02.blog.web.admin;

import len.cloud02.blog.service.TagService;
import len.cloud02.blog.pojo.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TagController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TagService tagService;

    @GetMapping("/admin_tags")
    public String types(@PageableDefault(size = 9, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){
        /**
         * 解释：@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC)
         * 功能：用于设置pageable的默认值。size代表每页有多少条，sort是根据哪一列排序，direction是设置排序方式（正序还是倒序）
         *
         * 解释：Pageable
         * 功能：Spring的类，Jpa就能够通过pageable参数来得到一个带分页信息的Sql语句
         */
        model.addAttribute("page",tagService.listTag(pageable));  // 把SQL查询出来的数据放入到model中，model传回网页中显示
        return "admin/admin_tags";
    }

    @PostMapping("/admin_tags")  // ↓ tag和BindingResult一定是挨着的，否则会不起作用！
    public String tag_post(@Valid Tag tag, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        // 检查是tag是否已存在
        Tag tag_check = tagService.getTagByName(tag.getName());
        if(tag_check != null){
            logger.info("Len logger <Controller-admin_tags-tag_check>|| 该分类已存在，添加失败！bindingResult.hasErrors()={}", bindingResult.hasErrors());
            bindingResult.rejectValue("name", "nameError", "该分类已存在，添加失败！");
            return "admin/admin_tags_input";
        }
        // 保存tag
        Tag tag_saved = tagService.saveTag(tag);
        logger.info("Len logger <Controller-admin_tags-tag>|| tag={}", tag);
        if(tag_saved==null){
            redirectAttributes.addFlashAttribute("message", "操作失败");
        }else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/admin/admin_tags";
    }

    @GetMapping("/admin_tags_input")
    public String tags_input(Model model){
        model.addAttribute("tag", new Tag());
        return "admin/admin_tags_input";
    }

    // 修改tag按钮的跳转
    @GetMapping("/admin_tags/{id}/admin_tags_input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("tag", tagService.getTag(id));
        return "admin/admin_tags_input";
    }

    // 修改tag
    @PostMapping("/admin_tags/{id}")
    public String editPost(@Valid Tag tag, BindingResult result,@PathVariable Long id, RedirectAttributes attributes) {
        // 验证要更新的tag的name是否已存在
        Tag tag1 = tagService.getTagByName(tag.getName());
        if (tag1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/admin_tags_input";
        }
        // 更新tags
        Tag t = tagService.updateTag(id,tag);
        if (t == null ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/admin_tags";
    }

    @GetMapping("/admin_tags/{id}/delete")
    public String deleteTag(@PathVariable Long id, RedirectAttributes redirectAttributes){
        tagService.deleteTag(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/admin_tags";
    }

}
