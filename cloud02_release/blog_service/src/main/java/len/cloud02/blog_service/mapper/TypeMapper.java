package len.cloud02.blog_service.mapper;

import len.cloud02.blog_service.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/23 23:56
 */
@Repository
public interface TypeMapper {
    List<Type> getTypeList();
}
