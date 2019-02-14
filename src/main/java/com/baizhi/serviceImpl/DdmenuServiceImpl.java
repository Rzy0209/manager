package com.baizhi.serviceImpl;

import com.baizhi.entity.Ddmenu;
import com.baizhi.mapper.DdmenuMapper;
import com.baizhi.service.DdmenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class DdmenuServiceImpl implements DdmenuService {
    @Resource
    DdmenuMapper ddmenuMapper;

    /**
     * 查所有分类
     */
    @Override
    public List<Ddmenu> queryAll() {
        List<Ddmenu> list = ddmenuMapper.queryAll();
        if (list == null) {
            throw new RuntimeException("数据为空，请添加数据");
        } else {
            return list;
        }
    }

    /**
     * 查 一级 分类下的二级
     *
     * @param id 父类id
     * @return 子类集合
     */
    @Override
    public List<Ddmenu> querAll(Integer id) {
        Ddmenu ddmenu = new Ddmenu();
        ddmenu.setParentId(id);
        List<Ddmenu> list = ddmenuMapper.select(ddmenu);

        for (Ddmenu ddmenu1 : list) {
            ddmenu1.setText(ddmenu1.getTitle());
        }
        return list;
    }
}
