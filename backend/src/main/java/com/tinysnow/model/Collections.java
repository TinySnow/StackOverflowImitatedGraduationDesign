package com.tinysnow.model;

import io.mybatis.provider.Entity;

import java.util.Date;

/**
 * collections 
 *
 * @author Snow
 */
@Entity.Table(value = "collections", autoResultMap = true)
public class Collections {
  @Entity.Column(value = "id", id = true, remark = "", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "title", remark = "问题集标题")
  private String title;

  @Entity.Column(value = "author", remark = "创建者，关联users的id")
  private String author;

  @Entity.Column(value = "description", remark = "问题集描述")
  private String description;

  @Entity.Column(value = "created_time", remark = "创建时间", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date createdTime;

  @Entity.Column(value = "updated_time", remark = "更改时间，若无可为空", jdbcType = org.apache.ibatis.type.JdbcType.TIMESTAMP)
  private Date updatedTime;


  /**
   * 获取 
   *
   * @return id - 
   */
  public Long getId() {
    return id;
  }

  /**
   * 设置
   *
   * @param id 
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取 问题集标题
   *
   * @return title - 问题集标题
   */
  public String getTitle() {
    return title;
  }

  /**
   * 设置问题集标题
   *
   * @param title 问题集标题
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * 获取 创建者，关联users的id
   *
   * @return author - 创建者，关联users的id
   */
  public String getAuthor() {
    return author;
  }

  /**
   * 设置创建者，关联users的id
   *
   * @param author 创建者，关联users的id
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * 获取 问题集描述
   *
   * @return description - 问题集描述
   */
  public String getDescription() {
    return description;
  }

  /**
   * 设置问题集描述
   *
   * @param description 问题集描述
   */
  public void setDescription(String description) {
    this.description = description;
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

}
