package com.tinysnow.model;

import io.mybatis.provider.Entity;

import java.util.Date;

/**
 * posts 
 *
 * @author Snow
 */
@Entity.Table(value = "posts", autoResultMap = true)
public class Posts {
  @Entity.Column(value = "id", id = true, remark = "文章id，唯一凭证", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "author", remark = "作者，关联users的id")
  private String author;

  @Entity.Column(value = "question", remark = "文章标题")
  private String question;

  @Entity.Column(value = "content", remark = "文章内容")
  private String content;

  @Entity.Column(value = "best_answer", remark = "最佳答案，关联comments的id")
  private String bestAnswer;

  @Entity.Column(value = "reward", remark = "悬赏分数，标注最佳答案后进行事务性扣除")
  private Integer reward;

  @Entity.Column(value = "created_time", remark = "创建时间", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date createdTime;

  @Entity.Column(value = "updated_time", remark = "更新时间，若无更改可为空", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date updatedTime;


  /**
   * 获取 文章id，唯一凭证
   *
   * @return id - 文章id，唯一凭证
   */
  public Long getId() {
    return id;
  }

  /**
   * 设置文章id，唯一凭证
   *
   * @param id 文章id，唯一凭证
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取 作者，关联users的id
   *
   * @return author - 作者，关联users的id
   */
  public String getAuthor() {
    return author;
  }

  /**
   * 设置作者，关联users的id
   *
   * @param author 作者，关联users的id
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * 获取 文章标题
   *
   * @return question - 文章标题
   */
  public String getQuestion() {
    return question;
  }

  /**
   * 设置文章标题
   *
   * @param question 文章标题
   */
  public void setQuestion(String question) {
    this.question = question;
  }

  /**
   * 获取 文章内容
   *
   * @return content - 文章内容
   */
  public String getContent() {
    return content;
  }

  /**
   * 设置文章内容
   *
   * @param content 文章内容
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * 获取 最佳答案，关联comments的id
   *
   * @return bestAnswer - 最佳答案，关联comments的id
   */
  public String getBestAnswer() {
    return bestAnswer;
  }

  /**
   * 设置最佳答案，关联comments的id
   *
   * @param bestAnswer 最佳答案，关联comments的id
   */
  public void setBestAnswer(String bestAnswer) {
    this.bestAnswer = bestAnswer;
  }

  /**
   * 获取 悬赏分数，标注最佳答案后进行事务性扣除
   *
   * @return reward - 悬赏分数，标注最佳答案后进行事务性扣除
   */
  public Integer getReward() {
    return reward;
  }

  /**
   * 设置悬赏分数，标注最佳答案后进行事务性扣除
   *
   * @param reward 悬赏分数，标注最佳答案后进行事务性扣除
   */
  public void setReward(Integer reward) {
    this.reward = reward;
  }

  /**
   * 获取 创建时间
   *
   * @return createdTime - 创建时间
   */
  public Date getCreatedTime() {
    return createdTime;
  }

  /**
   * 设置创建时间
   *
   * @param createdTime 创建时间
   */
  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  /**
   * 获取 更新时间，若无更改可为空
   *
   * @return updatedTime - 更新时间，若无更改可为空
   */
  public Date getUpdatedTime() {
    return updatedTime;
  }

  /**
   * 设置更新时间，若无更改可为空
   *
   * @param updatedTime 更新时间，若无更改可为空
   */
  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

}
