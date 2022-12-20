package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.commons.core.custom.validator.common.InsertGroup;
import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "设备名称不能为空",groups = {InsertGroup.class, UpdateGroup.class})    @TableField("equipment_name")
    private String equipmentName;

    /**
     * 设备状态
     */
    @NotNull(message = "设备状态不能为空",groups = {UpdateGroup.class})
    @TableField("status")
    private Integer status;

    /**
     * 设备数量
     */
    @NotNull(message = "设备数量不能为空",groups = {InsertGroup.class, UpdateGroup.class})
    @TableField("equipment_num")
    private Integer equipmentNum;

    /**
     * 提供设备的供应商Id
     */
    @NotNull(message = "提供设备的供应商Id不能为空",groups = {InsertGroup.class})
    @TableField("supplier_id")
    private Long supplierId;

    /**
     * 设备所在线体Id
     */
    @NotNull(message = "设备所在线体Id不能为空",groups = {InsertGroup.class})
    @TableField("line_id")
    private Long lineId;


}
