package com.tinysnow.system.service.impl;

import com.tinysnow.system.service.UserService;
import com.tinysnow.system.mapper.UserMapper;
import com.tinysnow.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * user -
 *
 * @author Snow
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    public User save(User user) {
        return userMapper.save(user);
    }

    /**
     * 根据 email 查找用户
     * 可以用来检测邮箱是否占用
     * 也可以用来登录校验
     *
     * @param email
     * @return
     */
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);

    }

    public User findList(User user) {
        return userMapper.findList(user);
    }

    public User find(Long id) {
        return userMapper.find(id);
    }

    public User update(User user) {
        return userMapper.update(user);
    }

    public int delete(Long id) {
        return userMapper.delete(id);
    }
}
