package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * post - 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "post", remark = "", autoResultMap = true)
public class Post {
  @Entity.Column(value = "id", id = true, remark = "文章 id，唯一凭证", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "author", remark = "作者，关联 user 的 id")
  private String author;

  @Entity.Column(value = "title", remark = "文章标题")
  private String title;

  @Entity.Column(value = "content", remark = "文章内容")
  private String content;

  @Entity.Column(value = "created_time", remark = "创建时间", jdbcType = JdbcType.TIMESTAMP)
  private Date createdTime;

  @Entity.Column(value = "updated_time", remark = "更新时间，若无更改可为空", jdbcType = JdbcType.TIMESTAMP)
  private Date updatedTime;

}
