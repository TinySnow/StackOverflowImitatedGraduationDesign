package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;

import java.util.Date;

/**
 * users 
 *
 * @author Snow
 */
@Data
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

  @Entity.Column(value = "gender", remark = "性别，默认为 1，女性")
  private Boolean gender;

  @Entity.Column(value = "birthday", remark = "生日，仅日期", jdbcType = org.apache.ibatis.type.JdbcType.DATE)
  private Date birthday;

  @Entity.Column(value = "points", remark = "助人点分数")
  private Long points;

  @Entity.Column(value = "register_time", remark = "注册时间", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date registerTime;
}
