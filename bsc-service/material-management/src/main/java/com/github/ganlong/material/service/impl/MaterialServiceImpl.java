package com.github.ganlong.material.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.enums.MaterialStatus;
import com.github.ganlong.material.mapper.MaterialMapper;
import com.github.ganlong.material.service.MaterialService;
import com.github.ganlong.model.material.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-12
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public List<Material> queryProductBindingMaterials(Long productId, Integer okMaterial) {
        MapperUtil<Material, MaterialMapper> mapperUtil = new MapperUtil<>();
        Integer exists = mapperUtil.dataExists("product_id", productId, materialMapper);

        if (exists > 0) {
            QueryWrapper<Material> wrapper = new QueryWrapper<>();
            wrapper.eq("product_id", productId);

            if (okMaterial.equals(0)) {
                return materialMapper.selectList(wrapper);
            }
            wrapper.eq("status", MaterialStatus.BINDING);

            return materialMapper.selectList(wrapper);
        }
        return new ArrayList<>();
    }

    @Override
    public Integer removeProductBindingMaterial(Long productId, Long materialId) {
        return null;
    }

}
