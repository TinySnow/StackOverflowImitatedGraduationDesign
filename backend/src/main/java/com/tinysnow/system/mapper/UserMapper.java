package com.tinysnow.system.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.tinysnow.system.model.User;


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
    public User save(User user);

    /**
     * 查找全部的 User
     */
    public User findList(User user);

    /**
     * 根据 email 查找用户
     * 可以用来检测邮箱是否占用
     * 也可以用来登录校验
     *
     * @param email
     * @return
     */
    public User findByEmail(String email);

    /**
     * 根据 id 查找 User
     */
    public User find(Long id);

    /**
     * 更新 User
     */
    public User update(User user);

    /**
     * 根据 id 删除 User
     */
    public int delete(Long id);

}