package len.cloud02.paper_service.web.admin;

import com.sun.org.apache.xpath.internal.operations.Mod;
import len.cloud02.common.Util.LenPath;
import len.cloud02.common.Util.LenTime;
import len.cloud02.common.entity.paper.Paper;
import len.cloud02.paper_service.serviec.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class PaperAdminController {
    @Autowired
    private PaperService paperService;

    @GetMapping("/paper_list")
    public String paperListAdmin(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                 Model model){
        Page<Paper> paperPage = paperService.getPaperList(pageable);
        model.addAttribute("page", paperPage);
        return "/admin/paper_list";
    }

    @GetMapping("/add_paper")
    public String addPaper(Model model){
        model.addAttribute("paper", new Paper());
        return "/admin/paper_add";
    }

    @PostMapping("/add_paper_post")
    public String addPaper_Post(Paper paper, MultipartFile files[]) throws IOException {
        // 保存图片
        String image_path = "https://picsum.photos/300/400";
        MultipartFile image1 = files[0];
        MultipartFile file1 = files[1];
        if (image1 != null){
            image_path = "/upload/paper_picture/" + paper.getName().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + image1.getOriginalFilename();
            String image_path_store = LenPath.getData() + image_path;
            File file_store = new File(image_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            image1.transferTo(file_store);
        }
        paper.setFirst_picture(image_path);
        // 保存文件
        String file_path = "https://picsum.photos/300/400";
        if (file1 != null){
            file_path = "/upload/paper_file/" + paper.getName().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + file1.getOriginalFilename();
            String file_path_store = LenPath.getData() + file_path;
            File file_store = new File(file_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            file1.transferTo(file_store);
        }
        paper.setFirst_picture(file_path);
        // 设置Paper其他属性
        paper.setView_time(0);
        paperService.addPaper(paper);
        return "redirect:/admin/paper_list";
    }


}
