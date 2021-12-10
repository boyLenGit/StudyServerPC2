package len.cloud01.artifact.web.cluster.monitor;

import len.cloud01.artifact.po.cluster.ServerStateDynamic;
import len.cloud01.artifact.po.cluster.ServerStateDynamic_vmstat;
import len.cloud01.artifact.service.cluster.WebCurveListService;
import len.cloud01.artifact.service.cluster.connect.LinuxService;
import len.cloud01.artifact.util.base.LenLog;
import len.cloud01.artifact.util.cluster.LinuxMemoryUtil;
import len.cloud01.artifact.util.cluster.LinuxStateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class singleServerMonitorController {
    @Autowired
    private LinuxService linuxService;

    private ServerStateDynamic serverStateDynamic = new ServerStateDynamic();
    private ServerStateDynamic_vmstat serverStateDynamic_vmstat = new ServerStateDynamic_vmstat();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebCurveListService webCurveListService = new WebCurveListService();


    // singleServerMonitor页面
    @GetMapping("/cluster/monitor/singleServerMonitor")
    public String testMemoryUsageCurve(Model model){
        // URL: http://localhost:8080/cluster/monitor/singleServerMonitor
        this.webCurveListService.initMemUsageList();
        model.addAttribute("serverStateDynamic", this.serverStateDynamic);
        return "cluster/monitor/singleServerMonitor";
    }

    // Ajax传参：Object
    @ResponseBody  // 不加会报错，因为Thymeleaf无法识别非json、html的数据体。
    @PostMapping("/cluster/monitor/singleServerMonitor/ajaxObject")
    public ServerStateDynamic singleServerMonitorCurve_ByAjax_ByObject() throws IOException {
        String result = linuxService.executeCommand("172.19.144.52", "cloud", "123", "free -m");
        serverStateDynamic = LinuxMemoryUtil.shellMemoryInfoConvert(serverStateDynamic, result);
        LenLog.staticInfo("testAjaxTo_MemoryUsageValueCurve", Integer.toString(serverStateDynamic.getMem_usage()));
        return serverStateDynamic;
    }

    // Ajax传参：Object_vmstat
    @ResponseBody  // 不加会报错，因为Thymeleaf无法识别非json、html的数据体。
    @PostMapping("/cluster/monitor/singleServerMonitor/ajaxObject_vmstat")
    public ServerStateDynamic_vmstat singleServerMonitorCurve_ByAjax_ByObject_vmstat() throws IOException {
        String result = linuxService.executeCommand("172.19.144.52", "cloud", "123", "vmstat  1 2 -a");
        serverStateDynamic_vmstat = LinuxStateUtil.shellVmstatConvert(serverStateDynamic_vmstat, result);
        LenLog.staticInfo("testAjaxTo_MemoryUsageValueCurve", serverStateDynamic_vmstat.toString());
        return serverStateDynamic_vmstat;
    }
}
