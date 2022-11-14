package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.model.production.Product;
import com.github.ganlong.production.mapper.ProductMapper;
import com.github.ganlong.production.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-09
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product queryProductLife(Long id) {
        Integer exists = new MapperUtil<Product, ProductMapper>()
                .dataExists("id", id,productMapper);

        if (exists!=0){
            QueryWrapper wrapper = new QueryWrapper<>();
            wrapper.eq("id",id);
            wrapper.select("current_station");
            return productMapper.selectOne(wrapper);
        }
        return new Product();
    }

    @Override
    public Integer modifiedProductStation(Long id, Integer modifiedStation) {
        Integer exists = new MapperUtil<Product, ProductMapper>()
                .dataExists("id", id,productMapper);

        if (exists>0) {
            Product product = productMapper.selectById(id);

            if (!product.getCurrentStation().equals(modifiedStation)) {
                product.setCurrentStation(modifiedStation);
                return productMapper.updateById(product);
            }else {
                //已在当前工站无需修改
                return new Integer(2);
            }
        }
        return new Integer(0);
    }
}
