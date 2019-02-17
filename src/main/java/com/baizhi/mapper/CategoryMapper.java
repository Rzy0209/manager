package com.baizhi.mapper;

import com.baizhi.entity.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> queryAll();

    void addCategory(Category category);

    void categoryAdd(Category category);
}
