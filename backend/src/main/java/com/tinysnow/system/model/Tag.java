package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;


/**
 * tag - 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "tag", remark = "", autoResultMap = true)
public class Tag {
  @Entity.Column(value = "id", id = true, remark = "标签 id", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "label", remark = "标签名称")
  private String label;

}
