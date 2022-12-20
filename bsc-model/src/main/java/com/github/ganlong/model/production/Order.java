package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.commons.core.custom.validator.common.InsertGroup;
import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.base.BaseEntity;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * <p>
 * 生产管理订单表
 * </p>
 *
 * @author ganlong
 * @since 2022-11-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_order")
public class Order extends BaseEntity {

    @Serialization
    private static final long serialVersionUID=1L;


    /**
     * 订单号
     */
    @NotBlank(message = "订单号不能为空",groups = {UpdateGroup.class})
    @TableField("order_no")
    private String orderNo;


    /**
     * 订单状态
     */
    @TableField("status")
    private Integer status;

    /**
     * 责任人
     */
    @NotBlank(message = "责任人不能为空",groups = {InsertGroup.class, UpdateGroup.class})
    @TableField("responsible_person")
    private String responsiblePerson;

    /**
     * 下单金额
     */
    @NotNull(message = "订单金额不能为空",groups = {InsertGroup.class, UpdateGroup.class})
    @TableField("order_amount")
    private BigDecimal orderAmount;

    /**
     * 产品类型Id
     */
    @NotNull(message = "产品类型不能为空",groups = {InsertGroup.class, UpdateGroup.class})
    @TableField("order_product_id")
    private Long orderProductId;

    /**
     * 下单数量
     */
    @NotNull(message = "下单的产品数量不能为空",groups = {InsertGroup.class, UpdateGroup.class})
    @TableField("product_num")
    private Double productNum;

    /**
     * 客户Id，外键
     */
    @NotNull(message = "客户Id不能为空",groups = {InsertGroup.class, UpdateGroup.class})
    @TableField("customer_id")
    private Long customerId;


}
