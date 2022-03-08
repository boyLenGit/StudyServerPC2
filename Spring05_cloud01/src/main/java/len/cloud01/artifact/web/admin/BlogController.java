package len.cloud01.artifact.web.admin;

import len.cloud01.artifact.po.Blog;
import len.cloud01.artifact.po.User;
import len.cloud01.artifact.service.BlogService;
import len.cloud01.artifact.service.TagService;
import len.cloud01.artifact.service.TypeService;
import len.cloud01.artifact.vo.BlogQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 博客管理页
    @GetMapping("/admin_article")
    public String blogs(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        // ~解释@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC)
        //      ·让pageable按照updateTime更新时间倒序排序，每页2条
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/admin_article";
    }

    // 博客管理页-条件查询
    @PostMapping("/admin_article/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, BlogQuery blog, Model model){
        // ~解释@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC)
        //      ·让pageable按照updateTime更新时间倒序排序，每页2条
        Page<Blog> result = blogService.listBlog(pageable, blog);
        model.addAttribute("page", result);
        return "admin/admin_article :: blogList";  // 返回页面admin_article下的blogList片段
    }

    // 发布博客-编辑页面跳转
    // 更新博客-编辑页面跳转
    @GetMapping("/admin_article/admin_publish")
    public String input(Model model) {
        model.addAttribute("types", typeService.listType());  // 初始化标签
        model.addAttribute("tags", tagService.listTag());  // 初始化标签
        model.addAttribute("blog", new Blog());  // 初始化一个blog
        return "admin/admin_publish";
    }

    // 发布博客-Blog提交
    @PostMapping("/admin_article")
    public String add_modify(Blog blog, RedirectAttributes redirectAttributes, HttpSession httpSession){
        // ↑ 取httpSession是因为这里面有user
        // ↓ 下面三个set是因为虽然blog带了tag与type，但是仅带的是id或者name，因此需要set一下，给Blog完整的Tag、Type对象，从而可以完整存储到数据库中
        blog.setUser((User) httpSession.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        Blog save_result;

        // ↓ 检查传入的Blog是否已存在，不存在则执行新建Blog步骤，存在则执行更新Blog步骤。
        if (blog.getId()==null){  // 如果是新建一个Blog，则↓
            save_result = blogService.saveBlog(blog);
        }else {  // 如果是修改一个Blog，则↓
            save_result = blogService.updateBlog(blog.getId(), blog);
        }
        // ↓ 检查保存/更新Blog是否成功。
        if (save_result == null){
            redirectAttributes.addFlashAttribute("message", "操作失败");
        }else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }
        logger.info("Len logger || 发布博客");
        return "redirect:/admin/admin_article";
    }

    // 博客编辑-转入到博客编辑页面
    @GetMapping("/admin_article/{id}/admin_publish")
    public String editArticleJump(@PathVariable Long id, Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());

        Blog blog = blogService.getBlog(id);
        blog.initTagIds();
        model.addAttribute("blog", blog);
        return "admin/admin_publish";
    }

    @GetMapping("/admin_article/{id}/delete")
    public String deleteArticle(@PathVariable Long id, RedirectAttributes redirectAttributes){
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/admin_article";
    }
}
