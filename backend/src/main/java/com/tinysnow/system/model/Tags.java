package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;

/**
 * tags - 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "tags", remark = "", autoResultMap = true)
public class Tags {
  @Entity.Column(value = "id", id = true, remark = "标签id", updatable = false, insertable = false)
  private Integer id;

  @Entity.Column(value = "label", remark = "标签名称")
  private String label;

}
