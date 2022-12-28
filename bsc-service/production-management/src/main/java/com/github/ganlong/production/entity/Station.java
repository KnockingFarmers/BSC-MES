package com.github.ganlong.production.entity;

import com.github.ganlong.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2022-12-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_station")
public class Station extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 工站名称
     */
    private String stationName;

    /**
     * 工站顺序
     */
    private String stationSequence;

    /**
     * 工站所属车间‘
     */
    private Long stationWorkshopId;


}
