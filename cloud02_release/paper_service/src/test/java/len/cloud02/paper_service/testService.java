package len.cloud02.paper_service;

import len.cloud02.paper_service.pojo.Paper;
import len.cloud02.paper_service.serviec.PaperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/6/22 10:30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class testService {
    @Autowired
    PaperService paperService;

    @Test
    public void test01(){
        Paper paper = paperService.getPaperById(95L);
        System.out.println(paper.getAuthor());
    }
}
