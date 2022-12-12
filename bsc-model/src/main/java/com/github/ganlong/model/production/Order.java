package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
    @TableField("responsible_person")
    private String responsiblePerson;

    /**
     * 下单金额
     */
    @TableField("order_amount")
    private BigDecimal orderAmount;

    /**
     * 产品类型Id
     */
    @TableField("order_product_id")
    private Long orderProductId;

    /**
     * 下单数量
     */
    @TableField("product_num")
    private Double productNum;

    /**
     * 客户Id，外键
     */
    @TableField("customer_id")
    private Long customerId;


}
