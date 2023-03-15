package com.tinysnow.system.model;

import io.mybatis.provider.Entity;
import lombok.Data;


/**
 * best_answer - 
 *
 * @author Snow
 */
@Data
@Entity.Table(value = "best_answer", remark = "", autoResultMap = true)
public class BestAnswer {
  @Entity.Column(value = "id", id = true, remark = "关联 question 的 id，随 question 的提出和删除一并操作，二者数量应该相等", updatable = false, insertable = false)
  private Long id;

  @Entity.Column(value = "best_answer", remark = "关联 comment 的 id")
  private Long bestAnswer;

}
