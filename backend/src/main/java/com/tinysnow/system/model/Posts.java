package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;

import java.util.Date;

/**
 * posts 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "posts", autoResultMap = true)
public class Posts {
  @Entity.Column(value = "id", id = true, remark = "文章 id，唯一凭证", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "author", remark = "作者，关联 users 的 id")
  private String author;

  @Entity.Column(value = "question", remark = "文章标题")
  private String question;

  @Entity.Column(value = "content", remark = "文章内容")
  private String content;

  @Entity.Column(value = "best_answer", remark = "最佳答案，关联 comments 的 id")
  private String bestAnswer;

  @Entity.Column(value = "reward", remark = "悬赏分数，标注最佳答案后进行事务性扣除")
  private Integer reward;

  @Entity.Column(value = "created_time", remark = "创建时间", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date createdTime;

  @Entity.Column(value = "updated_time", remark = "更新时间，若无更改可为空", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date updatedTime;
}
