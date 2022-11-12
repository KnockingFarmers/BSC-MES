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
@TableName("material_material")
public class Material extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 物料名称 供应商id+生产日期
     */
    private String materialName;

    /**
     * 绑定产品
     */
    private Long productId;

    /**
     * 物料状态，0存储中，1绑定中，3报废
     */
    private Integer status;

    /**
     * 仓库id，外键
     */
    private Long warehouseId;


}
