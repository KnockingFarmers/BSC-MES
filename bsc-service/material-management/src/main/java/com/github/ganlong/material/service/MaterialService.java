package com.github.ganlong.material.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.ganlong.model.material.Material;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-12
 */
public interface MaterialService extends IService<Material> {

    /**
     * 根据产品 id 查询该产品当前绑定的所有物料
     * @param productId id
     * @param okMaterial 是否过滤报废物料
     * @return
     */
    List<Material> queryProductBindingMaterials(Long productId,Integer okMaterial);

    /**
     * 解绑物料绑定的产品
     * @param productId 产品id
     * @param materialId 物料id
     * @return
     */
    Integer removeProductBindingMaterial(Long productId,Long materialId);
}
