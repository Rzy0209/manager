package com.baizhi.controller;

import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @ResponseBody
    @RequestMapping("showAll")
    public List<Category> showAll() {
        List<Category> list = categoryService.queryAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("addCategory")
    public void addCategory(Category category) {
        categoryService.addCategory(category);
    }

    @ResponseBody
    @RequestMapping("categoryAdd")
    public void categoryAdd(Category category) {

        System.out.println(category);

        categoryService.categoryAdd(category);
    }
}
