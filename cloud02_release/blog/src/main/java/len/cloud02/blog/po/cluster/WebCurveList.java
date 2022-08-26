package len.cloud02.blog.po.cluster;

import java.util.List;

public class WebCurveList {
    private List<Integer> list_mem_used;

    // ------------------------------------- Generate -------------------------------------

    public WebCurveList() {
    }

    public List<Integer> getList_mem_used() {
        return list_mem_used;
    }

    public void setList_mem_used(List<Integer> list_mem_used) {
        this.list_mem_used = list_mem_used;
    }

    @Override
    public String toString() {
        return "WebCurveList{" +
                "list_mem_used=" + list_mem_used +
                '}';
    }
}
