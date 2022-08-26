package len.cloud02.blog.web.cluster.monitor;

import len.cloud02.blog.po.cluster.ServerStateDynamic;
import len.cloud02.blog.po.cluster.ServerStateDynamic_vmstat;
import len.cloud02.blog.pojo.ServerOfUser;
import len.cloud02.blog.service.cluster.WebCurveListService;
import len.cloud02.blog.service.cluster.connect.LinuxService;
import len.cloud02.blog.service.cluster2.ClusterServerImpl;
import len.cloud02.blog.util.LenLog;
import len.cloud02.blog.util.cluster.LinuxMemoryUtil;
import len.cloud02.blog.util.cluster.LinuxStateUtil;
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
    @Autowired
    private ClusterServerImpl clusterServer;

    private ServerStateDynamic serverStateDynamic = new ServerStateDynamic();
    private ServerStateDynamic_vmstat serverStateDynamic_vmstat = new ServerStateDynamic_vmstat();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private WebCurveListService webCurveListService = new WebCurveListService();

    private String server_ip = "39.103.160.64";
    private String server_username = "lenguest";
    private String server_password = "boylen.com";


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
        String result = linuxService.executeCommand(server_ip, server_username, server_password, "free -m");
        serverStateDynamic = LinuxMemoryUtil.shellMemoryInfoConvert(serverStateDynamic, result);
        LenLog.staticInfo("testAjaxTo_MemoryUsageValueCurve", Integer.toString(serverStateDynamic.getMem_usage()));
        return serverStateDynamic;
    }

    // Ajax传参：Object_vmstat
    @ResponseBody  // 不加会报错，因为Thymeleaf无法识别非json、html的数据体。
    @PostMapping("/cluster/monitor/singleServerMonitor/ajaxObject_vmstat")
    public ServerStateDynamic_vmstat singleServerMonitorCurve_ByAjax_ByObject_vmstat() throws IOException {
//        String result = linuxService.executeCommand(server_ip, server_username, server_password, "vmstat  1 2 -a");
        String result = clusterServer.commandWithResponse(server_ip, server_username, server_password, "vmstat  1 2 -a");
        LenLog.info2(getClass(), "ServerStateDynamic_vmstat", "\n"+result);
        serverStateDynamic_vmstat = LinuxStateUtil.shellVmstatConvert(serverStateDynamic_vmstat, result);
        LenLog.staticInfo("testAjaxTo_MemoryUsageValueCurve", serverStateDynamic_vmstat.toString());
        return serverStateDynamic_vmstat;
    }
}
