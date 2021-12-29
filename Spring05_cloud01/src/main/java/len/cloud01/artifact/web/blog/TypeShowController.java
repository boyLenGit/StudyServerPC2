package len.cloud01.artifact.web.blog;

import len.cloud01.artifact.po.Type;
import len.cloud01.artifact.service.TypeService;
import len.cloud01.artifact.util.base.LenLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// 显示用户端按类别分类博客的页面
@Controller
public class TypeShowController {
    private TypeService typeService;

    public String types(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        @PathVariable Long id, Model model){
        // 查询出全部的type，这里指定了10000个Type，肯定能全部查到
        List<Type> typeList = typeService.listTypeTop(10000);
        if (id == -1){ // 在Web的导航中设置当点击"分类"时进入分类页面，给后端提交-1.因此这里就是判断是否是从分类按钮进来的
            LenLog.staticInfo("TypeShowController-types", "从分类按钮进入。");
        }
        return "";
    }
}
