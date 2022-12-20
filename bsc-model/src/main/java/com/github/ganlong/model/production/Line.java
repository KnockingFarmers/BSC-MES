package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.commons.core.custom.validator.common.InsertGroup;
import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_line")
public class Line extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 线体代号
     */
    @NotNull(message = "线体代号不能为空",groups = {InsertGroup.class,UpdateGroup.class})
    @TableField("line_no")
    private Integer lineNo;

    /**
     * 线体所属车间
     */
    @NotNull(message = "线体所属车间不能为空",groups = {InsertGroup.class,UpdateGroup.class})
    @TableField("workshop_id")
    private Long workshopId;

    /**
     * 当日生产良品数量
     */
    @NotNull(message = "当日生产良品数量不能为空",groups = {InsertGroup.class,UpdateGroup.class})
    @TableField("day_product_good_num")
    private Integer dayProductGoodNum;

    /**
     * 当然生产不良品数量
     */
    @NotNull(message = "当然生产不良品数量不能为空",groups = {InsertGroup.class,UpdateGroup.class})
    @TableField("day_product_defective_num")
    private Integer dayProductDefectiveNum;


}
