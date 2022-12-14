package com.github.ganlong.model.material;

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
@TableName("material_warehouse")
public class Warehouse extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 提供物料的供应商，外键id
     */
    private Long supplierId;

    /**
     * 物料状态, 1可使用，0冻结中
     */
    private Integer status;

    /**
     * 物料名
     */
    private String materialName;

    /**
     * 从仓库出口的数量
     */
    private Long materialOutNum;

    /**
     * 已报废数量
     */
    private Integer materialScrapNum;

    /**
     * 存储在几号仓库
     */
    private Integer warehouseId;


}
