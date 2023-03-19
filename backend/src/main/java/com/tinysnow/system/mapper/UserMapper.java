package com.tinysnow.system.mapper;

import com.tinysnow.system.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.User;

import java.util.List;


/**
 * user -
 *
 * @author Snow
 */
@Mapper
public interface UserMapper {

    /**
     * 保存 User
     */
    int save(User user);

    /**
     * 查找全部的 User
     */
    User findList(User user);

    /**
     * 根据 email 查找用户
     * 可以用来检测邮箱是否占用
     * 也可以用来登录校验
     *
     * @param email
     * @return
     */
    User findByEmail(String email);

    List<User> findAll();

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

    List<UserDto> findListsWithPoint();
}