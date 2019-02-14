package com.baizhi.mapper;

import com.baizhi.entity.Ddmenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DdmenuMapper extends Mapper<Ddmenu> {
    List<Ddmenu> queryAll();
}
