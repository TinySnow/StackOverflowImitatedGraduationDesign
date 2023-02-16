package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;

import java.util.Date;

/**
 * comments 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "comments", autoResultMap = true)
public class Comments {
  @Entity.Column(value = "id", id = true, remark = "评论 id", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "post", remark = "关联 posts 的 id")
  private String post;

  @Entity.Column(value = "parent", remark = "父评论 id，关联 comments 的 id，若无则为 post 的一级评论")
  private String parent;

  @Entity.Column(value = "author", remark = "关联 users 的 id")
  private String author;

  @Entity.Column(value = "content", remark = "内容")
  private String content;

  @Entity.Column(value = "upvote", remark = "点赞数")
  private Integer upvote;

  @Entity.Column(value = "devote", remark = "点踩数")
  private Integer devote;

  @Entity.Column(value = "created_time", remark = "创建时间", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date createdTime;

  @Entity.Column(value = "updated_time", remark = "更改时间，若无可为空", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date updatedTime;

  @Entity.Column(value = "status", remark = "状态，是否可用")
  private Integer status;

  @Entity.Column(value = "is_top", remark = "置顶，即是否为最佳答案")
  private Boolean isTop;
}
