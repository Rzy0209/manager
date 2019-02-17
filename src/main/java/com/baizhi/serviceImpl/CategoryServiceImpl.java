package com.baizhi.serviceImpl;

import com.baizhi.entity.Category;
import com.baizhi.mapper.CategoryMapper;
import com.baizhi.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAll() {
        List<Category> list = categoryMapper.queryAll();
        if (list == null) {
            throw new RuntimeException("数据为空，请添加数据");
        } else {
            return list;
        }
    }
}
