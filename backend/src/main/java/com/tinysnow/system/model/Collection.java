package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * collection - 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "collection", remark = "", autoResultMap = true)
public class Collection {
  @Entity.Column(value = "id", id = true, remark = "问题集 id", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "title", remark = "问题集标题")
  private String title;

  @Entity.Column(value = "author", remark = "创建者，关联 user 的 id")
  private String author;

  @Entity.Column(value = "description", remark = "问题集描述")
  private String description;

  @Entity.Column(value = "created_time", remark = "创建时间", jdbcType = JdbcType.TIMESTAMP)
  private Date createdTime;

  @Entity.Column(value = "updated_time", remark = "更改时间，若无可为空", jdbcType = JdbcType.TIMESTAMP)
  private Date updatedTime;

}
