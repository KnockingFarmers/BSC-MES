package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.model.order.Product;
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
    public Product queryCycleLife(String sn) {
        Integer count = new MapperUtil<Product, ProductMapper>()
                .dataExists("sn", sn,productMapper);

        if (count!=0){
            QueryWrapper wrapper = new QueryWrapper<>();
            wrapper.eq("sn",sn);
            return productMapper.selectOne(wrapper);
        }
        return new Product();
    }
}
