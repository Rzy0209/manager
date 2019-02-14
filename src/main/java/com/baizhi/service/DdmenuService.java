package com.baizhi.service;

import com.baizhi.entity.Ddmenu;

import java.util.List;

public interface DdmenuService {
    /**
     * 查一级 类别
     */
    List<Ddmenu> queryAll();

    /**
     * 查  二级 类别
     */
    List<Ddmenu> querAll(Integer id);

}
