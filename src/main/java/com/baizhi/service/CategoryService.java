package com.baizhi.service;

import com.baizhi.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryAll();

    void addCategory(Category category);

    void categoryAdd(Category category);
}
