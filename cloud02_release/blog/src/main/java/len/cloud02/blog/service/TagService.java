package len.cloud02.blog.service;

import len.cloud02.blog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    Tag saveTag(Tag tag);  // 新增类型（保存）

    Tag getTag(Long id); // 查询类型

    Tag getTagByName(String name);  // 通过id查询类型

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);  // 用于在博客index页面显示指定数量、从大到小排列的tag

    Tag updateTag(Long id,Tag tag);

    void deleteTag(Long id);
}
