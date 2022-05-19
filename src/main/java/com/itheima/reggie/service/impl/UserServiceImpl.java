package com.itheima.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.mapper.UserMapper;
import com.itheima.reggie.service.UserService;
import com.itheima.reggie.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public boolean sendEmailCode(String code, String from, String to) {
        try {
            // 用来设置邮件信息
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("瑞吉外卖");
            simpleMailMessage.setText("您收到的验证码是：" + code);
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(to);
            javaMailSender.send(simpleMailMessage);
            return true;
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }
    }
}
