package len.cloud02.paper_service.web;

import len.cloud02.paper_service.serviec.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PaperController {
    @Autowired
    private PaperService paperService;

}
