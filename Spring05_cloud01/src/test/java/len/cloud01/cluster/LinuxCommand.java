package len.cloud01.cluster;

import len.cloud01.artifact.po.cluster.ServerStateDynamic;
import len.cloud01.artifact.po.cluster.WebCurveList;
import len.cloud01.artifact.service.cluster.WebCurveListService;
import len.cloud01.artifact.util.LenList;
import len.cloud01.artifact.util.base.LenLog;
import len.cloud01.artifact.util.cluster.LinuxMemoryUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LinuxCommand {

    @Test
    public void test_types_iter() throws IOException {
        String free_mem = "total used free shared buff/cache available Mem: 257600 12749 112371 213 132479 242835 Swap: 123977 0 123977";
        String free_mem_list_removeResult_flag = "flag";
        // transferList
        // String[] free_mems = free_mem.split("\r\n");
        String[] free_mems = free_mem.split(" ");
        List<String> free_mem_list = new ArrayList<String>();
        for(String s:free_mems){
            free_mem_list.add(s);
        }
        // removeResultHead
        List<String> free_mem_list_removeResult = new ArrayList<String>();
        free_mem_list_removeResult.addAll(free_mem_list);
        for(String res:free_mem_list){
            if(res.contains(free_mem_list_removeResult_flag)){
                break;
            }
            free_mem_list_removeResult.remove(res);
        }

        System.out.println(free_mem_list);
        System.out.println(free_mem_list.size());
        //List<String> split_mem = Arrays.asList(free_mem.get());
    }

    @Test
    public void test_linuxMemoryUtil() throws IOException {
        String free_mem = "total used free shared buff/cache available Mem: 257600 12749 112371 213 132479 242835 Swap: 123977 0 123977";
        Logger logger = LoggerFactory.getLogger(this.getClass());


        ServerStateDynamic serverStateDynamic = LinuxMemoryUtil.shellMemoryInfoConvert(new ServerStateDynamic(), free_mem);
        logger.info("LenPrint <testMemoryObject>. MemoryObject: {}", serverStateDynamic.toString());
        System.out.println(serverStateDynamic);
    }

    @Test
    public void test_date() throws IOException {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        LenLog.staticInfo("Log", "123123");
    }

    @Test
    public void test_string_list() throws IOException {
        String string = "procs -----------memory---------- ---swap-- -----io---- -system-- ------cpu-----\n" +
                " r  b   swpd   free   buff  cache   si   so    bi    bo   in   cs us sy id wa st\n" +
                " 2  0    512 138553504 4407220 105154488    0    0     0     5    0    0  3  0 96  0  0\n" +
                " 0  0    512 138553232 4407220 105154488    0    0     0    44 4357 7259  0  0 100  0  0";
        List<List<String>> vmstat_list = LenList.shellToList2V(string);
        List<String> vmstat_head = vmstat_list.get(1);
        List<String> vmstat_body = vmstat_list.get(3);

        System.out.println(vmstat_list);
        // [procs, -----------memory----------, ---swap--, -----io----, -system--, ------cpu-----, r, b, swpd, free, buff, cache, si, so, bi, bo, in, cs, us, sy, id, wa, st, 1, 0, 0, 81395976, 4376980, 156329472, 0, 0, 0, 5, 0, 0, 3, 0, 96, 0, 0]
        //    0                 1                    2           3         4              5        6  7   8     9     10     11   12  13  14  15  16  17  18  19  20  21  22  23 24 25    26       27        28      29 30 31 32 33 34 35 36 37 38 39
    }
}
