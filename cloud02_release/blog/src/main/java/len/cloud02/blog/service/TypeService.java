package len.cloud02.blog.service;

import len.cloud02.blog.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
    Type saveType(Type type);  // 新增类型（保存）

    Type getType(Long id); // 查询类型

    Type getTypeByName(String name);  // 通过id查询类型

    Page<Type> listType(Pageable pageable);

    List<Type> listType();  // 返回所有数据，不需要传参

    List<Type> listTypeTop(Integer size);  // 用于云平台博客首页，抽取前size个type来显示

    Type updateType(Long id,Type type);

    void deleteType(Long id);
}
