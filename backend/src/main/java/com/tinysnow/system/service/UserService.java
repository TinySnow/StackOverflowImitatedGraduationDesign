package com.tinysnow.system.service;

import com.tinysnow.system.dto.UserDto;
import com.tinysnow.system.model.User;

import java.util.List;

/**
 * user -
 *
 * @author Snow
 */
public interface UserService {

    /**
     * 保存 User
     */
    int save(User user);

    /**
     * 查找符合条件的全部 User
     */
    User findList(User user);

    /**
     * 查找全部 User
     */
    List<User> findAll();

    /**
     * 根据 email 查找用户
     * 可以用来检测邮箱是否占用
     * 也可以用来登录校验
     */
    User findByEmail(String email);

    List<UserDto> findListsWithPoint();

    /**
     * 根据 id 查找 User
     */
    User find(Long id);

    /**
     * 更新 User
     */
    int update(User user);

    /**
     * 根据 id 删除 User
     */
    int delete(Long id);

    UserDto getProfile(Long id);

    int updateAvatar(Long id, String url);
}
