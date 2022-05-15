package len.cloud02.paper_service.web.admin;

import len.cloud02.paper_service.pojo.Paper;
import len.cloud02.paper_service.serviec.PaperService;
import len.cloud02.paper_service.util.LenFile;
import len.cloud02.paper_service.util.LenLog;
import len.cloud02.paper_service.util.LenPath;
import len.cloud02.paper_service.util.LenTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class PaperAdminController {
    @Autowired
    private PaperService paperService;

    @GetMapping("/papers")
    public String paperListAdmin(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                 Model model){
        Page<Paper> paperPage = paperService.getPaperList(pageable);
        model.addAttribute("page", paperPage);
        return "admin/paper_list";
    }

    @GetMapping("/add_paper")
    public String addPaper(Model model){
        model.addAttribute("paper", new Paper());
        return "admin/paper_add";
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
        paper.setFile_path(file_path);
        // 设置Paper其他属性
        paper.setView_time(0);
        paperService.addPaper(paper);
        return "redirect:/admin/papers";
    }

    @GetMapping("/paper_delete/{id}")
    public String deletePaper (@PathVariable Long id) throws IOException{
        String file_path = LenPath.getData() + paperService.getPaperById(id).getFile_path();
        LenFile.deleteFile(file_path);
        String image_path = LenPath.getData() + paperService.getPaperById(id).getFirst_picture();
        LenFile.deleteFile(image_path);
        LenLog.info2(this.getClass(), "deleteBook", String.valueOf(id) + " " + file_path + " | " + image_path);
        paperService.deleteBook(id);
        return "redirect:/admin/papers";
    }

    // Paper的关键词查询
    @PostMapping("/paper_query/one_keyword")
    public String queryPaperByOneKeyword(@RequestParam String keyword, @PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){
        Page<Paper> paperPage = paperService.findPapersByOneKeyword(pageable, keyword);
        model.addAttribute("page", paperPage);
        return "paper_list";
    }

    // 更新
    @GetMapping("/paper_update/{id}")
    public String updatePaper(@PathVariable Long id, Model model){
        Paper paper = paperService.getPaperById(id);
        model.addAttribute("paper", paper);
        return "admin/paper_update";
    }

    @PostMapping("/paper_update_post/{id}")
    public String updatePaper_Post(@Valid Paper paper, @PathVariable Long id, MultipartFile files[]) throws IOException{
        Paper paper_sql = paperService.getPaperById(id);
        String image_path = paper_sql.getFirst_picture();
        MultipartFile image1 = files[0];
        MultipartFile file1 = files[1];
        if (image1 != null && !Objects.equals(image1.getOriginalFilename(), "")){
            image_path = "/upload/paper_picture/" + paper.getName().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + image1.getOriginalFilename();
            String image_path_store = LenPath.getData() + image_path;
            File file_store = new File(image_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            image1.transferTo(file_store);
            LenFile.deleteFile(LenPath.getData() + paper_sql.getFirst_picture());
        }
        paper.setFirst_picture(image_path);
        // 保存文件
        String file_path = paper_sql.getFile_path();
        if (file1 != null && !Objects.equals(file1.getOriginalFilename(), "")){
            file_path = "/upload/paper_file/" + paper.getName().hashCode() + "_" + LenTime.ymdhms_pure_num() + "_" + file1.getOriginalFilename();
            String file_path_store = LenPath.getData() + file_path;
            File file_store = new File(file_path_store);
            if (!file_store.exists())
                file_store.createNewFile();
            file1.transferTo(file_store);
            LenFile.deleteFile(LenPath.getData() + paper_sql.getFile_path());
        }
        paper.setFile_path(file_path);
        // 设置Paper其他属性
        paper.setView_time(0);
        paperService.updateBook(id, paper);
        return "redirect:/admin/papers";
    }
}
