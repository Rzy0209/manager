package com.baizhi.controller;

import com.baizhi.entity.Ddmenu;
import com.baizhi.service.DdmenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/ddmenu")
public class DdmenuController {
    @Resource
    DdmenuService ddmenuService;

    @RequestMapping("showAll")
    @ResponseBody
    public List<Ddmenu> showAll() {
        List<Ddmenu> list = ddmenuService.queryAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("two")
    public List<Ddmenu> two(Integer id) {
        List<Ddmenu> list = ddmenuService.querAll(id);
        return list;
    }
}
