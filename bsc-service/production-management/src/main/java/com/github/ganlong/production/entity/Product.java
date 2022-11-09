package com.github.ganlong.production.entity;

import com.github.ganlong.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_product")
public class Product extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * SN
     */
    private String sn;

    /**
     * 当前工站
     */
    private String currentStation;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 所属订单
     */
    private Long orderId;


}
