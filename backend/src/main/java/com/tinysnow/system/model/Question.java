package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * question - 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "question", remark = "", autoResultMap = true)
public class Question {
  @Entity.Column(value = "id", id = true, remark = "问题 id，唯一凭证", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "author", remark = "作者，关联 user 的 id")
  private String author;

  @Entity.Column(value = "title", remark = "文章标题")
  private String title;

  @Entity.Column(value = "content", remark = "文章内容")
  private String content;

  @Entity.Column(value = "reward", remark = "悬赏分数，标注最佳答案后进行事务性扣除")
  private Integer reward;

  @Entity.Column(value = "created_time", remark = "创建时间", jdbcType = JdbcType.TIMESTAMP)
  private Date createdTime;

  @Entity.Column(value = "updated_time", remark = "更新时间，若无更改可为空", jdbcType = JdbcType.TIMESTAMP)
  private Date updatedTime;

}
