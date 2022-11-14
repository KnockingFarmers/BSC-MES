package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.enums.CurrentStation;
import com.github.ganlong.model.base.BaseEntity;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;


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

    @Serialization
    private static final long serialVersionUID=1L;

    /**
     * SN
     */
    private String sn;

    /**
     * 当前工站
     */
    @Range(min = 1,max =29,message = "类型范围 1~29")
    private Integer currentStation;


    /**
     * 所属订单
     */
    private Long orderId;



}
