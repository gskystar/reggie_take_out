package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.entity.User;

public interface UserService extends IService<User> {
    boolean sendEmailCode(String code, String from, String to);
}
