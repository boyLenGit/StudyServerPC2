package len.cloud02.blog.web.cluster.monitor;

import len.cloud02.blog.po.cluster.ServerStateDynamic;
import len.cloud02.blog.service.cluster.WebCurveListService;
import len.cloud02.blog.service.cluster.connect.LinuxService;
import len.cloud02.blog.util.LenLog;
import len.cloud02.blog.util.cluster.LinuxMemoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class TestMonitorController {
    @Autowired
    private LinuxService linuxService;

    private ServerStateDynamic serverStateDynamic = new ServerStateDynamic();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebCurveListService webCurveListService = new WebCurveListService();

    // 测试Memory绘图
    @GetMapping("/cluster/monitor/test_memusage_curve")
    public String testMemoryUsageCurve(Model model){
        // URL: http://localhost:8080/cluster/monitor/test_memusage_curve
        this.webCurveListService.initMemUsageList();
        model.addAttribute("serverStateDynamic", this.serverStateDynamic);
        return "cluster/monitor/test_memusage_curve";
    }

    // 测试Ajax传递曲线绘图
    @ResponseBody  // 不加会报错，因为Thymeleaf无法识别非json、html的数据体。
    @PostMapping("/cluster/monitor/test_memusage_curve/ajaxList")
    public List<Integer> testAjaxTo_MemoryUsageListCurve() throws IOException {
        String result = linuxService.executeCommand("172.19.144.52", "cloud", "123", "free -m");
        serverStateDynamic = LinuxMemoryUtil.shellMemoryInfoConvert(serverStateDynamic, result);
        webCurveListService.addMemUsageList(serverStateDynamic.getMem_usage());
        List<Integer> mem_usage_list = webCurveListService.getMemUsageList();
        LenLog.staticInfo("testAjaxTo_MemoryUsageListCurve", serverStateDynamic.toString());
        return mem_usage_list;
    }

    // 测试Ajax传递曲线绘图
    @ResponseBody  // 不加会报错，因为Thymeleaf无法识别非json、html的数据体。
    @PostMapping("/cluster/monitor/test_memusage_curve/ajaxValue")
    public int testAjaxTo_MemoryUsageValueCurve() throws IOException {
        String result = linuxService.executeCommand("172.19.144.52", "cloud", "123", "free -m");
        serverStateDynamic = LinuxMemoryUtil.shellMemoryInfoConvert(serverStateDynamic, result);
        LenLog.staticInfo("testAjaxTo_MemoryUsageValueCurve", Integer.toString(serverStateDynamic.getMem_usage()));
        return serverStateDynamic.getMem_usage();
    }

}
