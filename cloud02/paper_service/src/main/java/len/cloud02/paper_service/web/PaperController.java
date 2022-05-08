package len.cloud02.paper_service.web;

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

@Controller
public class PaperController {
    @Autowired
    private PaperService paperService;

    @GetMapping("/papers")
    public String paperList(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                            Model model){
        Page<Paper> paperPage = paperService.getPaperList(pageable);
        model.addAttribute("page", paperPage);
        return "paper_list";
    }


}
