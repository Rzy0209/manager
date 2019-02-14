package com.baizhi.service;

import com.baizhi.entity.Admin;

public interface AdminService {
    /**
     * 登陆功能
     * 参数 用户名  密码
     * 返回一个  用户对象
     */
    Admin getOne(String name, String password);
}
