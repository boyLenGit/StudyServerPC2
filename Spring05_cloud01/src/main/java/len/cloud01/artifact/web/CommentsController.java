package len.cloud01.artifact.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommentsController {
    @GetMapping("/comments/{blogId}")
    public String Comments(@PathVariable Long blogId){
        return "blog :: commentList";
    }
}
