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
 * @since 2022-11-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_plan")
public class Plan extends BaseEntity {

    private static final long serialVersionUID=1L;


    /**
     * 月内生产数量
     */
    @NotNull(message = "月内生产数量不能为空",groups = {UpdateGroup.class})
    @TableField("month_planned_num")
    private Double monthPlannedNum;

    /**
     * 日内生产数量
     */
    @NotNull(message = "日内生产数量不能为空",groups = {UpdateGroup.class})
    @TableField("day_planned_num")
    private Integer dayPlannedNum;

    /**
     * 已完成数量
     */
    @NotNull(message = "已完成数量不能为空",groups = {UpdateGroup.class})
    @TableField("done_num")
    private Long doneNum;

    /**
     * 对应订单id，外键
     */
    @NotNull(message = "对应订单id不能为空",groups = {InsertGroup.class, UpdateGroup.class})
    @TableField("order_id")
    private Long orderId;

    /**
     * 当日报废产品数量
     */
    @NotNull(message = "当日报废产品数量不能为空",groups = {UpdateGroup.class})
    @TableField("day_scrap_num")
    private Integer dayScrapNum;

    /**
     * 预计月内完成指标
     */
    @NotNull(message = "预计月内完成指标不能为空",groups = {InsertGroup.class, UpdateGroup.class})
    @TableField("expected_month_Planned_num")
    private Long expectedMonthPlannedNum;


}
