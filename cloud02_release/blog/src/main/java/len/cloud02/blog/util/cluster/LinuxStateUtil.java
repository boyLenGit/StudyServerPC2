package len.cloud02.blog.util.cluster;

import len.cloud02.blog.po.cluster.ServerStateDynamic_vmstat;
import len.cloud02.blog.util.LenList;

import java.util.List;

public class LinuxStateUtil {

    public static ServerStateDynamic_vmstat shellVmstatConvert(ServerStateDynamic_vmstat serverStateDynamic_vmstat, String vmstat){
        // 空对象检查
        if(vmstat.equals("")){
            return new ServerStateDynamic_vmstat();
        }
        // 转为List
        List<List<String>> vmstat_list = LenList.shellToList2V(vmstat);
        List<String> vmstat_body = vmstat_list.get(3);
        // 注入
        serverStateDynamic_vmstat.setProcs_r(Integer.parseInt(vmstat_body.get(0)));
        serverStateDynamic_vmstat.setProcs_b(Integer.parseInt(vmstat_body.get(1)));
        serverStateDynamic_vmstat.setMem_swpd(Integer.parseInt(vmstat_body.get(2)));
        serverStateDynamic_vmstat.setMem_free(Integer.parseInt(vmstat_body.get(3)));
        serverStateDynamic_vmstat.setMem_buff(Integer.parseInt(vmstat_body.get(4)));
        serverStateDynamic_vmstat.setMem_cache(Integer.parseInt(vmstat_body.get(5)));
        serverStateDynamic_vmstat.setSwap_si(Integer.parseInt(vmstat_body.get(6)));
        serverStateDynamic_vmstat.setSwap_so(Integer.parseInt(vmstat_body.get(7)));
        serverStateDynamic_vmstat.setIo_bi(Integer.parseInt(vmstat_body.get(8)));
        serverStateDynamic_vmstat.setIo_bo(Integer.parseInt(vmstat_body.get(9)));
        serverStateDynamic_vmstat.setSys_in(Integer.parseInt(vmstat_body.get(10)));
        serverStateDynamic_vmstat.setSys_cs(Integer.parseInt(vmstat_body.get(11)));
        serverStateDynamic_vmstat.setCpu_us(Integer.parseInt(vmstat_body.get(12)));
        serverStateDynamic_vmstat.setCpu_sy(Integer.parseInt(vmstat_body.get(13)));
        serverStateDynamic_vmstat.setCpu_id(Integer.parseInt(vmstat_body.get(14)));
        serverStateDynamic_vmstat.setCpu_wa(Integer.parseInt(vmstat_body.get(15)));
        serverStateDynamic_vmstat.setCpu_st(Integer.parseInt(vmstat_body.get(16)));
        return serverStateDynamic_vmstat;
    }
}


// cpu:
//      cat /proc/stat | grep 'cpu' | awk '{print $2+$3+$4+$5+$6+$7+$8+$9+$10 $5}
// net:
//      cat /proc/net/dev
// disk:
//      df | grep ' /$'
//      df -h| grep 'Filesystem\|/dev/sda*'
// load: uptime
