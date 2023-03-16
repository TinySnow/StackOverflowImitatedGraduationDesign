package com.tinysnow.system.service;

import com.tinysnow.system.model.Question;
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
    public int save(User user);

    /**
     * 查找符合条件的全部 User
     */
    public User findList(User user);

    /**
     * 查找全部 User
     * @return
     */
    public List<User> findAll();

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
    public int update(User user);

    /**
     * 根据 id 删除 User
     */
    public int delete(Long id);
}
