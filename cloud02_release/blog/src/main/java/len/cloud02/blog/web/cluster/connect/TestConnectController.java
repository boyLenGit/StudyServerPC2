package len.cloud02.blog.web.cluster.connect;

import len.cloud02.blog.po.cluster.ServerStateDynamic;
import len.cloud02.blog.service.cluster.connect.LinuxService;
import len.cloud02.blog.util.cluster.LinuxMemoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class TestConnectController {

    @Autowired
    private LinuxService linuxService;

    private ServerStateDynamic serverStateDynamic_init = new ServerStateDynamic();

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/cluster/connect/test_connect")
    public void testConnect(Model model){
        // URL: http://localhost:8080/cluster/connect/test_connect
        String res = "";
        try {

            res = linuxService.executeCommand("172.19.144.52", "cloud", "123", "whoami");
            System.out.println("LenPrint 2 " + res);
        }catch (IOException e) {
            logger.error("发生了异常", e);
            model.addAttribute("error", e.getMessage());
        }
    }

    // 测试Command指令
    @GetMapping("/cluster/connect/test_command_jump")
    public String testCommand_Jump(Model model){
        // URL: http://localhost:8080/cluster/connect/test_command_jump
        return "cluster/connect/test_command";
    }

    @PostMapping("/cluster/connect/test_command")
    public String testCommand(@RequestParam String command, RedirectAttributes redirectAttributes){
        String result = "";
        try {
            result = linuxService.executeCommand("172.19.144.52", "cloud", "123", command);
            logger.info("LenPrint <testCommand>. Command: {}", result);
            redirectAttributes.addFlashAttribute("message", result);
        }catch (IOException e) {
            logger.error("发生了异常", e);
            redirectAttributes.addFlashAttribute("message", "指令错误");
        }
        return "redirect:/cluster/connect/test_command_jump";
    }

    // 测试Memory获取与对象
    @GetMapping("/cluster/connect/test_memory_object")
    public String testMemoryObject_Jump(Model model){
        // URL: http://localhost:8080/cluster/connect/test_memory_object
        serverStateDynamic_init.setMem_total(45464);
        model.addAttribute("serverStateDynamic", serverStateDynamic_init);
        return "cluster/connect/test_memory_object";
    }


    @PostMapping("/cluster/connect/test_memory_object/post")
    public String testMemoryObject(@Valid String command, @Valid ServerStateDynamic serverStateDynamic, RedirectAttributes redirectAttributes){
        try {
            String result = linuxService.executeCommand("172.19.144.52", "cloud", "123", command);
                    //logger.info("LenPrint <testMemoryObject>. Command: {}, object: {}.", result, serverStateDynamic.toString());
            serverStateDynamic_init = LinuxMemoryUtil.shellMemoryInfoConvert(serverStateDynamic, result);
                    //logger.info("LenPrint <testMemoryObject>. MemoryObject: {}", serverStateDynamic_refresh.toString());
            redirectAttributes.addFlashAttribute("message", "查询成功" + serverStateDynamic_init.toString());
        }catch (IOException e) {
            logger.error("发生了异常", e);
            redirectAttributes.addFlashAttribute("message", "指令错误");
        }
        return "redirect:/cluster/connect/test_memory_object";
    }


}
