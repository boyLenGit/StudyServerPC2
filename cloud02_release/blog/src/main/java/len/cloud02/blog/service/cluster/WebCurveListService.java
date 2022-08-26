package len.cloud02.blog.service.cluster;

import len.cloud02.blog.po.cluster.WebCurveList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebCurveListService implements WebCurveListServiceImpl {
    private int draw_dots = 30;
    private WebCurveList webCurveList = new WebCurveList();

    public WebCurveListService() {
    }

    // ---------------------------------------- init ----------------------------------------
    @Override
    public void initMemUsageList() {
        List<Integer> list_temp = new ArrayList<Integer>();
        for(int i=0; i<=draw_dots-1;i++){
            list_temp.add(0);
        }
        webCurveList.setList_mem_used(list_temp);
    }

    // ---------------------------------------- Get ----------------------------------------
    @Override
    public List<Integer> getMemUsageList() {
        return webCurveList.getList_mem_used();
    }

    // ---------------------------------------- Add ----------------------------------------
    @Override
    public void addMemUsageList(int mem_usage) {
        List<Integer> list_temp = webCurveList.getList_mem_used();
        list_temp.remove(0);
        list_temp.add(mem_usage);
    }
}
