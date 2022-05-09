package len.cloud02.paper_service.web;

import len.cloud02.common.Util.LenLog;
import len.cloud02.common.Util.LenPath;
import len.cloud02.common.entity.helper.PagePaper;
import len.cloud02.common.entity.paper.Paper;
import len.cloud02.paper_service.serviec.PaperService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@RestController
@RequestMapping("/rest_paper")
public class PaperRestController {
    @Autowired
    private PaperService paperService;

    // http://localhost:8086/rest_paper/papers
    @GetMapping("/papers")
    public ArrayList<Paper> paperList(){
        ArrayList<Paper> paperPage = paperService.getPaperListNoPageable();
        return paperPage;
//        model.addAttribute("page", paperPage);
//        return "paper_list";
    }

    @PostMapping("/papers")
    public PagePaper paperListAdmin(@RequestBody Pageable pageable, Model model){
        Page<Paper> paperPage = paperService.getPaperList(pageable);
        PagePaper pagePaper = new PagePaper();
        pagePaper.setPaperPage(paperPage);
        return pagePaper;
//        model.addAttribute("page", paperPage);
//        return "/admin/paper_list";
    }

    // 文献详情
    @GetMapping("/detail/{id}")
    public Paper paperDetail(@PathVariable Long id, Model model){
        Paper paper = paperService.getPaperById(id);
//        Paper paper = paperService.getPaperByIdByMapper(id);
        paper.setView_time(paper.getView_time()+1);
        paperService.updateBook(id, paper);
        return paper;
//        model.addAttribute("paper", paper);
//        return "paper_detail";
    }

    // 下载
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadPaperPDF(@PathVariable Long id) throws IOException {
        Paper paper = paperService.getPaperById(id);
        String file_path = paper.getFile_path();
        String file_path_full = LenPath.getData() + file_path;
        LenLog.info2(this.getClass(), "downloadPaperPDF", file_path_full);
        File file =new File(file_path_full);
        //创建字节输入流，这里不实用Buffer类
        InputStream in = new FileInputStream(file);
        //available:获取输入流所读取的文件的最大字节数
        byte[] body = new byte[in.available()];
        //把字节读取到数组中
        in.read(body);
        //设置请求头
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        //设置响应状态
        HttpStatus statusCode = HttpStatus.OK;
        in.close();
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;//返回
    }

    @GetMapping("/quote/{id}")
    @ResponseBody
    public String quote(@PathVariable Long id){
        Paper paper = paperService.getPaperById(id);
        String quote = paper.getAuthor() + ". " + paper.getName() + ". " + paper.getPublisher();
        return quote;
    }

    @PostMapping("/paper_query/one_keyword")
    public Page<Paper> queryPaperByOneKeyword(@RequestParam String keyword, @PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable, Model model){
        Page<Paper> paperPage = paperService.findPapersByOneKeyword(pageable, keyword);
        return paperPage;
//        model.addAttribute("page", paperPage);
//        return "/paper_list";
    }
}
