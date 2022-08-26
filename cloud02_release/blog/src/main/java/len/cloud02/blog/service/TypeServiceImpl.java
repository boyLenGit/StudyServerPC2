package len.cloud02.blog.service;

import len.cloud02.blog.dao.TypeRepository;
import len.cloud02.blog.error.NotFoundException;
import len.cloud02.blog.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    private TypeRepository typeRepository;

    @Transactional  // 放在事务里。增删改需要放在事务里，但是查询不需要放在事务里
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.getOne(id);  // return typeRepository.findOne(id);报错的改为return typeRepository.getOne(id);或者return typeRepository.findById(id).orElse(null);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "blogs.size");
        Pageable pageable = PageRequest.of(0, size, sort);  // 设置分页内容从大到小排序
        return typeRepository.LenfindTop(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type_new) {
        Type type_old = typeRepository.getOne(id);
        if (type_old==null){
            throw new NotFoundException("不存在该类型！");
        }
        BeanUtils.copyProperties(type_new, type_old);
        return typeRepository.save(type_old);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);  // typeRepository.delete(id)换成typeRepository.deleteById(id)
    }
}
