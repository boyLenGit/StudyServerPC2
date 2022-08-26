package len.cloud02.blog.util.cluster;

import len.cloud02.blog.po.cluster.ServerStateDynamic;
import len.cloud02.blog.util.LenList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinuxMemoryUtil {
    private ServerStateDynamic serverStateDynamic;

    public static ServerStateDynamic shellMemoryInfoConvert(ServerStateDynamic serverStateDynamic_input, String free_mem){
        // 空对象检查
        if(free_mem.equals("")){
            return new ServerStateDynamic();
        }
        // 转为List
        List<String> free_mem_list = LenList.shellToList1V(free_mem);
        // List<String> free_mem_list = new ArrayList<String>(Arrays.asList(free_mem.split("\r\n")));
        // 注入
        serverStateDynamic_input.setMem_total(Integer.parseInt(free_mem_list.get(7)));
        serverStateDynamic_input.setMem_usage(Integer.parseInt(free_mem_list.get(8)));
        serverStateDynamic_input.setMem_free(Integer.parseInt(free_mem_list.get(9)));
        serverStateDynamic_input.setMem_shared(Integer.parseInt(free_mem_list.get(10)));
        serverStateDynamic_input.setMem_cache(Integer.parseInt(free_mem_list.get(11)));
        serverStateDynamic_input.setMem_available(Integer.parseInt(free_mem_list.get(12)));
        return serverStateDynamic_input;
    }
}
