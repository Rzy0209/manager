package com.baizhi.mapper;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AdminMapper extends Mapper<Admin> {

    /**
     * 实现  登陆功能
     *
     * @param name     用户名
     * @param password 密码
     * @return 返回一个用户
     */
    Admin queryOne(@Param("name") String name, @Param("password") String password);
}
