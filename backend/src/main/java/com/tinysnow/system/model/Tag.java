package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;


/**
 * tag - 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "tag", remark = "", autoResultMap = true)
public class Tag {
  @Entity.Column(value = "id", id = true, remark = "标签 id", updatable = false, insertable = false)
  private Integer id;

  @Entity.Column(value = "label", remark = "标签名称")
  private String label;

}
