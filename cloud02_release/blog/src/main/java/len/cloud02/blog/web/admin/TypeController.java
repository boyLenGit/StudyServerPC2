package len.cloud02.blog.web.admin;

import len.cloud02.blog.service.TypeService;
import len.cloud02.blog.pojo.Type;
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
public class TypeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TypeService typeService;

    @GetMapping("/admin_types")
    public String types(@PageableDefault(size = 9, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){
        /**
         * 解释：@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC)
         * 功能：用于设置pageable的默认值。size代表每页有多少条，sort是根据哪一列排序，direction是设置排序方式（正序还是倒序）
         *
         * 解释：Pageable
         * 功能：Spring的类，Jpa就能够通过pageable参数来得到一个带分页信息的Sql语句
         */
        model.addAttribute("page",typeService.listType(pageable));  // 把SQL查询出来的数据放入到model中，model传回网页中显示
        return "admin/admin_types";
    }

    @PostMapping("/admin_types")  // ↓ type和BindingResult一定是挨着的，否则会不起作用！
    public String type_post(@Valid Type type, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        // 检查是type是否已存在
        Type type_check = typeService.getTypeByName(type.getName());
        if(type_check != null){
            logger.info("Len logger <Controller-admin_types-type_check>|| 该分类已存在，添加失败！bindingResult.hasErrors()={}", bindingResult.hasErrors());
            bindingResult.rejectValue("name", "nameError", "该分类已存在，添加失败！");
            return "admin/admin_types_input";
        }
        // 保存type
        Type type_saved = typeService.saveType(type);
        logger.info("Len logger <Controller-admin_types-type>|| type={}", type);
        if(type_saved==null){
            redirectAttributes.addFlashAttribute("message", "操作失败");
        }else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/admin/admin_types";
    }

    @GetMapping("/admin_types_input")
    public String types_input(Model model){
        model.addAttribute("type", new Type());
        return "admin/admin_types_input";
    }

    // 修改type按钮的跳转
    @GetMapping("/admin_types/{id}/admin_types_input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type", typeService.getType(id));
        return "admin/admin_types_input";
    }

    // 修改type
    @PostMapping("/admin_types/{id}")
    public String editPost(@Valid Type type, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        // 验证要更新的type的name是否已存在
        Type type1 = typeService.getTypeByName(type.getName());
        if (type1 != null) {
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()) {
            return "admin/admin_types_input";
        }
        // 更新types
        Type t = typeService.updateType(id,type);
        if (t == null ) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/admin_types";
    }

    @GetMapping("/admin_types/{id}/delete")
    public String deleteType(@PathVariable Long id, RedirectAttributes redirectAttributes){
        typeService.deleteType(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/admin_types";
    }

}
