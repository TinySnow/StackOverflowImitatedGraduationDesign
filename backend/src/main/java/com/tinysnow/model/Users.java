package com.tinysnow.model;

import io.mybatis.provider.Entity;

import java.util.Date;

/**
 * users 
 *
 * @author Snow
 */
@Entity.Table(value = "users", autoResultMap = true)
public class Users {
  @Entity.Column(value = "id", id = true, remark = "主键，自增", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "username", remark = "用户名")
  private String username;

  @Entity.Column(value = "password", remark = "密码，加密")
  private String password;

  @Entity.Column(value = "avatar", remark = "头像，链接存储")
  private String avatar;

  @Entity.Column(value = "email", remark = "邮箱，唯一凭证")
  private String email;

  @Entity.Column(value = "gender", remark = "性别，默认为1，女性")
  private Boolean gender;

  @Entity.Column(value = "birthday", remark = "生日，仅日期", jdbcType = org.apache.ibatis.type.JdbcType.DATE)
  private Date birthday;

  @Entity.Column(value = "points", remark = "助人点分数")
  private Long points;

  @Entity.Column(value = "register_time", remark = "注册时间", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date registerTime;


  /**
   * 获取 主键，自增
   *
   * @return id - 主键，自增
   */
  public Long getId() {
    return id;
  }

  /**
   * 设置主键，自增
   *
   * @param id 主键，自增
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取 用户名
   *
   * @return username - 用户名
   */
  public String getUsername() {
    return username;
  }

  /**
   * 设置用户名
   *
   * @param username 用户名
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * 获取 密码，加密
   *
   * @return password - 密码，加密
   */
  public String getPassword() {
    return password;
  }

  /**
   * 设置密码，加密
   *
   * @param password 密码，加密
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * 获取 头像，链接存储
   *
   * @return avatar - 头像，链接存储
   */
  public String getAvatar() {
    return avatar;
  }

  /**
   * 设置头像，链接存储
   *
   * @param avatar 头像，链接存储
   */
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  /**
   * 获取 邮箱，唯一凭证
   *
   * @return email - 邮箱，唯一凭证
   */
  public String getEmail() {
    return email;
  }

  /**
   * 设置邮箱，唯一凭证
   *
   * @param email 邮箱，唯一凭证
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * 获取 性别，默认为1，女性
   *
   * @return gender - 性别，默认为1，女性
   */
  public Boolean getGender() {
    return gender;
  }

  /**
   * 设置性别，默认为1，女性
   *
   * @param gender 性别，默认为1，女性
   */
  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  /**
   * 获取 生日，仅日期
   *
   * @return birthday - 生日，仅日期
   */
  public Date getBirthday() {
    return birthday;
  }

  /**
   * 设置生日，仅日期
   *
   * @param birthday 生日，仅日期
   */
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  /**
   * 获取 助人点分数
   *
   * @return points - 助人点分数
   */
  public Long getPoints() {
    return points;
  }

  /**
   * 设置助人点分数
   *
   * @param points 助人点分数
   */
  public void setPoints(Long points) {
    this.points = points;
  }

  /**
   * 获取 注册时间
   *
   * @return registerTime - 注册时间
   */
  public Date getRegisterTime() {
    return registerTime;
  }

  /**
   * 设置注册时间
   *
   * @param registerTime 注册时间
   */
  public void setRegisterTime(Date registerTime) {
    this.registerTime = registerTime;
  }

}
