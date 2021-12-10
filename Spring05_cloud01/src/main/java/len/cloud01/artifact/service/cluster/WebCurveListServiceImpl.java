package len.cloud01.artifact.service.cluster;

import java.util.List;

public interface WebCurveListServiceImpl {
    // 初始化
    void initMemUsageList();

    // Pick
    List<Integer> getMemUsageList();

    // Input
    void addMemUsageList(int mem_usage);
}
