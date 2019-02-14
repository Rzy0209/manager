package com.baizhi.serviceImpl;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminMapper adminMapper;

    /**
     * 实现登陆功能
     */
    @Override
    public Admin getOne(String name, String password) {
        Admin admin = adminMapper.queryOne(name, password);
        if (admin == null) {
            throw new RuntimeException("用户不存在，请注册后在使用");
        } else {
            return admin;
        }
    }
}
