package com.github.ganlong.production.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.ganlong.model.production.Product;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-09
 */
public interface ProductService extends IService<Product> {

    /**
     * 查询产品生命周期
     * @param id id
     * @return
     */
    Product queryProductLife(Long id);

}
