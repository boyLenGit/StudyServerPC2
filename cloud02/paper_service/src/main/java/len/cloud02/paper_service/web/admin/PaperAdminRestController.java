package len.cloud02.paper_service.web.admin;

import len.cloud02.common.Util.LenFile;
import len.cloud02.common.Util.LenLog;
import len.cloud02.common.Util.LenPath;
import len.cloud02.common.Util.LenTime;
import len.cloud02.common.entity.helper.PagePaper;
import len.cloud02.common.entity.paper.Paper;
import len.cloud02.paper_service.serviec.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/rest_paper/admin")
public class PaperAdminRestController {
    @Autowired
    private PaperService paperService;

    @PostMapping("/papers")
    public PagePaper paperListAdmin(Pageable pageable, Model model){
        Page<Paper> paperPage = paperService.getPaperList(pageable);
        PagePaper pagePaper = new PagePaper();
        pagePaper.setPaperPage(paperPage);
        return pagePaper;
//        model.addAttribute("page", paperPage);
//        return "/admin/paper_list";
    }

    @PostMapping("/add_paper_post")
    public String addPaper_Post(@RequestBody Paper paper) {
        paperService.addPaper(paper);
        return "Success";
    }

    @GetMapping("/paper_delete/{id}")
    public String deletePaper (@PathVariable Long id) throws IOException{
        String file_path = LenPath.getData() + paperService.getPaperById(id).getFile_path();
        LenFile.deleteFile(file_path);
        String image_path = LenPath.getData() + paperService.getPaperById(id).getFirst_picture();
        LenFile.deleteFile(image_path);
        LenLog.info2(this.getClass(), "deleteBook", String.valueOf(id) + " " + file_path + " | " + image_path);
        paperService.deleteBook(id);
        return "Success";
//        return "redirect:/admin/papers";
    }

    // Paper的关键词查询
    @PostMapping("/paper_query/one_keyword")
    public Page<Paper> queryPaperByOneKeyword(@RequestParam String keyword, @PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){
        Page<Paper> paperPage = paperService.findPapersByOneKeyword(pageable, keyword);
        return paperPage;
//        model.addAttribute("page", paperPage);
//        return "/admin/paper_list";
    }

    @PostMapping("/paper_update_post/{id}")
    public String updatePaper_Post(@RequestBody Paper paper, @PathVariable Long id){
        paperService.updateBook(id, paper);
        return "redirect:/admin/papers";
    }
}
