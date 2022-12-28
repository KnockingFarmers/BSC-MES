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
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


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
     * 当前工站
     */
    @TableField("current_station_id")
    @NotNull(message = "工站不能为空",groups = {UpdateGroup.class,InsertGroup.class})
    private Long currentStationId;


    /**
     * 所属订单Id
     */
    @NotNull(message = "所属订单Id不能为空",groups = {UpdateGroup.class,InsertGroup.class})
    @TableField("order_id")
    private Long orderId;

    /**
     * 生产线体Id
     */
    @NotNull(message = "生产线体Id不能为空",groups = {InsertGroup.class})
    @TableField("line_id")
    private Long lineId;

}
