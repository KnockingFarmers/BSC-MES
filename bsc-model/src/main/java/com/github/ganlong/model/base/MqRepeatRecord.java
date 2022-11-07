package com.github.ganlong.model.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @author: ganlong
 * @date: 2022/11/7 20:09
 **/
@Data
@ApiModel(description = "MqRepeatRecord")
@TableName("mq_repeat_record")
public class MqRepeatRecord extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "业务编号")
	@TableField("business_no")
	private String businessNo;

}