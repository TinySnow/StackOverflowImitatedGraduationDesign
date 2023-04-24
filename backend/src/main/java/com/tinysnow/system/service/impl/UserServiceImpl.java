package com.tinysnow.system.service.impl;

import com.tinysnow.system.dto.UserDto;
import com.tinysnow.system.mapper.PointMapper;
import com.tinysnow.system.model.Point;
import com.tinysnow.system.service.UserService;
import com.tinysnow.system.mapper.UserMapper;
import com.tinysnow.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * user -
 *
 * @author Snow
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PointMapper pointMapper;

    @Transactional
    public int save(User user) {
        userMapper.save(user);
        Point point = new Point();
        point.setId(user.getId());
        point.setPoint(0L);
        return pointMapper.save(point);
    }

    /**
     * 根据 email 查找用户
     * 可以用来检测邮箱是否占用
     * 也可以用来登录校验
     */
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);

    }

    public List<UserDto> findListsWithPoint() {
        return userMapper.findListsWithPoint();
    }

    public User findList(User user) {
        return userMapper.findList(user);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User find(Long id) {
        return userMapper.find(id);
    }

    public int update(User user) {
        return userMapper.update(user);
    }

    public int delete(Long id) {
        return userMapper.delete(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public UserDto getProfile(Long id) {
        return userMapper.getProfile(id);
    }

    /**
     * @param id
     * @param url
     * @return
     */
    @Override
    public int updateAvatar(Long id, String url) {
        return userMapper.updateAvatar(id, url);
    }

    /**
     * @param id
     * @param user
     * @return
     */
    @Override
    public int updateProfile(Long id, User user) {
        return userMapper.updateProfile(id, user);
    }
}
