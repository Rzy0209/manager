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

    /**
     * 查一级类别以及归属子类
     *
     * @return
     */
    @Override
    public List<Category> queryAll() {
        List<Category> list = categoryMapper.queryAll();
        if (list == null) {
            throw new RuntimeException("数据为空，请添加数据");
        } else {
            return list;
        }
    }

    /**
     * 添加类别
     */
    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    /**
     * 添加分类下的二级分类
     *
     * @param category
     */
    @Override
    public void categoryAdd(Category category) {
        Integer on = 1;

        if (on.equals(category.getStatus())) {
            category.setStatus(1);
            System.out.println(category.getStatus());
        } else {
            category.setStatus(0);
        }
        categoryMapper.categoryAdd(category);
    }
}
