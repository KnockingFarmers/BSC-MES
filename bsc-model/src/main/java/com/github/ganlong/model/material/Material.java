package com.github.ganlong.model.material;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("material_material")
public class Material extends BaseEntity {

    @Serialization
    private static final long serialVersionUID=1L;

    /**
     * 物料编号，供应商id+生产日期
     */
    private String materialNo;

    /**
     * 物料状态, 1可使用，0冻结中
     */
    private Integer status;

    /**
     * 物料名
     */
    private String materialName;

    /**
     * 库存
     */
    private Long materialInventory;

    /**
     * 从仓库出口的数量
     */
    private Long materialOutNum;

    /**
     * 已报废数量
     */
    private Integer materialScrapNum;

    /**
     * 存储在哪个仓库
     */
    private Long warehouseId;


}
