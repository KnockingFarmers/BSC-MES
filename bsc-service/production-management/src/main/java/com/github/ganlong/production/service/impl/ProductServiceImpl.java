package com.github.ganlong.production.service.impl;

import com.github.ganlong.production.entity.Product;
import com.github.ganlong.production.mapper.ProductMapper;
import com.github.ganlong.production.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
