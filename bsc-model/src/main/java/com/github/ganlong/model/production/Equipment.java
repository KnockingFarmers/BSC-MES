package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_equipment")
public class Equipment extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 设备名称
     */
    private String equipmentName;

    /**
     * 设备状态
     */
    private Integer status;

    /**
     * 设备数量
     */
    private Integer equipmentNum;

    /**
     * 提供设备的供应商
     */
    private Long supplierId;

    /**
     * 设备所在线体
     */
    private Long lineId;


}
