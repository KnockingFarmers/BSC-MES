package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableField("month_planned_num")
    private Double monthPlannedNum;

    /**
     * 日内生产数量
     */
    @TableField("day_planned_num")
    private Integer dayPlannedNum;

    /**
     * 已完成数量
     */
    @TableField("done_num")
    private Long doneNum;

    /**
     * 对应订单id，外键
     */
    @TableField("order_id")
    private Long orderId;

    /**
     * 当日报废产品数量
     */
    @TableField("day_scrap_num")
    private Integer dayScrapNum;

    /**
     * 预计月内完成指标
     */
    @TableField("expected_month_Planned_num")
    private Long expectedMonthPlannedNum;


}
