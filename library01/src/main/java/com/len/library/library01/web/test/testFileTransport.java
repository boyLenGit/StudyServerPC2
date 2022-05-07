package com.len.library.library01.web.test;

import com.len.library.library01.util.LenLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class testFileTransport {

    // http://localhost:8081/test/upload01
    @GetMapping("/upload01")
    public String testUploadFile_get(){
        return "test/upload";
    }

    @PostMapping("/upload01_post")
//    @ResponseBody
    public String testUploadFile_post(MultipartFile file) throws IOException {
        File file1 =new File("/Users/mabolun/Downloads/"+file.getOriginalFilename());//创建file对象
        if(!file1.exists())
            file1.createNewFile();//在磁盘创建该文件
        file.transferTo(file1);//将接受的文件存储
        return "sucucess";
    }

    // http://localhost:8081/test/upload01_multi
    @GetMapping("/upload01_multi")
    public String testUploadMultiFile_get(){
        return "test/upload_multi";
    }

    @PostMapping("/upload01_multi_post")
    @ResponseBody
    public String testUploadMultiFile_post(MultipartFile files1[]) throws IOException {
        LenLog.info("testUploadMultiFile_post", String.valueOf(files1.length));
        for(int i=0;i<files1.length;i++)
        {
            if(!files1[i].isEmpty())//文件不空
            {
                File imgfile =new File("/Users/mabolun/Downloads/"+files1[i].getOriginalFilename());
                imgfile.createNewFile();
                files1[i].transferTo(imgfile);
                LenLog.info("testUploadMultiFile_post", files1[i].getOriginalFilename());
            }
        }
        return "sucucess";
    }



}
