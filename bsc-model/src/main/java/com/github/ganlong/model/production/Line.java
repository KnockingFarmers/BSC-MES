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
 * @since 2022-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_line")
public class Line extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 线条代号
     */
    private Integer lineNo;

    /**
     * 线体所属车间
     */
    private Long workshopId;

    /**
     * 当日生产良品数量
     */
    private Integer dayProductGoodNum;

    /**
     * 当然生产不良品数量
     */
    private Integer dayProductDefectiveNum;


}
