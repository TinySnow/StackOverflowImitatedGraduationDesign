package com.tinysnow.model;

import io.mybatis.provider.Entity;


/**
 * tags 
 *
 * @author Snow
 */
@Entity.Table(value = "tags", autoResultMap = true)
public class Tags {
  @Entity.Column(value = "id", id = true, remark = "标签id", updatable = false, insertable = false)
  private Integer id;

  @Entity.Column(value = "label", remark = "标签名称")
  private String label;


  /**
   * 获取 标签id
   *
   * @return id - 标签id
   */
  public Integer getId() {
    return id;
  }

  /**
   * 设置标签id
   *
   * @param id 标签id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 获取 标签名称
   *
   * @return label - 标签名称
   */
  public String getLabel() {
    return label;
  }

  /**
   * 设置标签名称
   *
   * @param label 标签名称
   */
  public void setLabel(String label) {
    this.label = label;
  }

}
