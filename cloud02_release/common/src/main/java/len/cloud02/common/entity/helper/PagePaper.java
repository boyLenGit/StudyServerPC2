package len.cloud02.common.entity.helper;

import len.cloud02.common.entity.paper.Paper;
import org.springframework.data.domain.Page;

public class PagePaper {
    private Page<Paper> paperPage;

    public PagePaper() {
    }

    public Page<Paper> getPaperPage() {
        return paperPage;
    }

    public void setPaperPage(Page<Paper> paperPage) {
        this.paperPage = paperPage;
    }
}
