package com.github.ganlong.material.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.ganlong.model.material.Material;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ganlong
 * @since 2022-11-12
 */
@Mapper
public interface MaterialMapper extends BaseMapper<Material> {

    /**
     * 接触产品绑定的物料
     * @param productId 产品id
     * @param materialId 物料id
     * @return
     */
    Integer updateMaterialStatusByProductId(Long productId, Long materialId);
}
