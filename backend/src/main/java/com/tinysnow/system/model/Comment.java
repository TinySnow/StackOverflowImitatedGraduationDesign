package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * comment - 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "comment", remark = "", autoResultMap = true)
public class Comment {
  @Entity.Column(value = "id", id = true, remark = "评论 id", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "question", remark = "关联 question 的 id")
  private String question;

  @Entity.Column(value = "parent", remark = "父评论 id，关联 comment 的 id，若无则为 question 的一级评论")
  private String parent;

  @Entity.Column(value = "author", remark = "关联 user 的 id")
  private String author;

  @Entity.Column(value = "content", remark = "内容")
  private String content;

  @Entity.Column(value = "upvote", remark = "点赞数")
  private Integer upvote;

  @Entity.Column(value = "devote", remark = "点踩数")
  private Integer devote;

  @Entity.Column(value = "created_time", remark = "创建时间", jdbcType = JdbcType.TIMESTAMP)
  private Date createdTime;

  @Entity.Column(value = "updated_time", remark = "更改时间，若无可为空", jdbcType = JdbcType.TIMESTAMP)
  private Date updatedTime;

  @Entity.Column(value = "status", remark = "状态，是否可用")
  private Integer status;

}
