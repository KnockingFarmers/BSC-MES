package com.github.ganlong.model.order;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

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

    private static final long serialVersionUID=1L;

    /**
     * 创建时间
     */
    private Date gtmCreated;

    /**
     * 订单号
     */
    private Long orderNo;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 责任人
     */
    private String responsiblePerson;

    /**
     * 下单金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单产品
     */
    private String orderProduct;

    /**
     * 下单数量
     */
    private Double productNum;

    /**
     * 客户id，外键
     */
    private Long customerId;


}
