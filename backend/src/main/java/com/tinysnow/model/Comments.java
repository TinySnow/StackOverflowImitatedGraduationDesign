package com.tinysnow.model;

import io.mybatis.provider.Entity;

import java.util.Date;

/**
 * comments 
 *
 * @author Snow
 */
@Entity.Table(value = "comments", autoResultMap = true)
public class Comments {
  @Entity.Column(value = "id", id = true, remark = "评论id", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "post", remark = "关联posts的id")
  private String post;

  @Entity.Column(value = "parent", remark = "父评论id，关联comments的id，若无则为post的一级评论")
  private String parent;

  @Entity.Column(value = "author", remark = "关联users的id")
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


  /**
   * 获取 评论id
   *
   * @return id - 评论id
   */
  public Long getId() {
    return id;
  }

  /**
   * 设置评论id
   *
   * @param id 评论id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取 关联posts的id
   *
   * @return post - 关联posts的id
   */
  public String getPost() {
    return post;
  }

  /**
   * 设置关联posts的id
   *
   * @param post 关联posts的id
   */
  public void setPost(String post) {
    this.post = post;
  }

  /**
   * 获取 父评论id，关联comments的id，若无则为post的一级评论
   *
   * @return parent - 父评论id，关联comments的id，若无则为post的一级评论
   */
  public String getParent() {
    return parent;
  }

  /**
   * 设置父评论id，关联comments的id，若无则为post的一级评论
   *
   * @param parent 父评论id，关联comments的id，若无则为post的一级评论
   */
  public void setParent(String parent) {
    this.parent = parent;
  }

  /**
   * 获取 关联users的id
   *
   * @return author - 关联users的id
   */
  public String getAuthor() {
    return author;
  }

  /**
   * 设置关联users的id
   *
   * @param author 关联users的id
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * 获取 内容
   *
   * @return content - 内容
   */
  public String getContent() {
    return content;
  }

  /**
   * 设置内容
   *
   * @param content 内容
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * 获取 点赞数
   *
   * @return upvote - 点赞数
   */
  public Integer getUpvote() {
    return upvote;
  }

  /**
   * 设置点赞数
   *
   * @param upvote 点赞数
   */
  public void setUpvote(Integer upvote) {
    this.upvote = upvote;
  }

  /**
   * 获取 点踩数
   *
   * @return devote - 点踩数
   */
  public Integer getDevote() {
    return devote;
  }

  /**
   * 设置点踩数
   *
   * @param devote 点踩数
   */
  public void setDevote(Integer devote) {
    this.devote = devote;
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
   * 获取 更改时间，若无可为空
   *
   * @return updatedTime - 更改时间，若无可为空
   */
  public Date getUpdatedTime() {
    return updatedTime;
  }

  /**
   * 设置更改时间，若无可为空
   *
   * @param updatedTime 更改时间，若无可为空
   */
  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  /**
   * 获取 状态，是否可用
   *
   * @return status - 状态，是否可用
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * 设置状态，是否可用
   *
   * @param status 状态，是否可用
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * 获取 置顶，即是否为最佳答案
   *
   * @return isTop - 置顶，即是否为最佳答案
   */
  public Boolean getIsTop() {
    return isTop;
  }

  /**
   * 设置置顶，即是否为最佳答案
   *
   * @param isTop 置顶，即是否为最佳答案
   */
  public void setIsTop(Boolean isTop) {
    this.isTop = isTop;
  }

}
