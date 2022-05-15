package len.cloud02.paper_service.web.admin;

import len.cloud02.paper_service.pojo.Paper;
import len.cloud02.paper_service.pojo.RestString;
import len.cloud02.paper_service.serviec.PaperService;
import len.cloud02.paper_service.util.LenLog;
import len.cloud02.paper_service.util.LenPath;
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
import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("/rest_paper/admin")
public class PaperAdminRestController {
    @Autowired
    private PaperService paperService;

//    @PostMapping("/papers")
//    public PagePaper paperListAdmin(Pageable pageable, Model model){
//        Page<Paper> paperPage = paperService.getPaperList(pageable);
//        PagePaper pagePaper = new PagePaper();
//        pagePaper.setPaperPage(paperPage);
//        return pagePaper;
////        model.addAttribute("page", paperPage);
////        return "/admin/paper_list";
//    }

    @PostMapping("/add_paper_post")
    public String addPaper_Post(@RequestBody Paper paper) {
        paperService.addPaper(paper);
        return "Success";
    }

    @GetMapping("/paper_delete/{id}")
    public String deletePaper (@PathVariable Long id){
        paperService.deleteBook(id);
        return "Success";
    }

    // Paper的关键词查询
    @PostMapping("/paper_query/one_keyword")
    public ArrayList<Paper> queryPaperByOneKeyword(@RequestBody RestString restString, Model model){
        return paperService.findPapersByOneKeyword(restString.getString1());
    }

    @PostMapping("/paper_update_post/{id}")
    public String updatePaper_Post(@RequestBody Paper paper, @PathVariable Long id){
        paperService.updateBook(id, paper);
        return "redirect:/admin/papers";
    }
}
