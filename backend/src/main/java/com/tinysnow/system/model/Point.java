package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;


/**
 * point - 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "point", remark = "", autoResultMap = true)
public class Point {
  @Entity.Column(value = "id", id = true, remark = "关联 user 的 id，随用户注册或删除账户时一并操作，应该与 user 的数据库条数相同", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "point", remark = "助人点分数")
  private Long point;

}
