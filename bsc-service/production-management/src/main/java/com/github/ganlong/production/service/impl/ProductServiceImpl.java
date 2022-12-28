package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.api.ApiResult;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.model.production.Product;
import com.github.ganlong.production.entity.Station;
import com.github.ganlong.production.mapper.ProductMapper;
import com.github.ganlong.production.service.ProductService;
import com.github.ganlong.production.service.rpc.StationFeignClient;
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

    @Autowired
    private StationFeignClient stationFeignClient;

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
    public ApiResult modifiedProductStation(Long id, Long modifiedStation) {
        Integer proExists = new MapperUtil<Product, ProductMapper>()
                .dataExists("id", id,productMapper);

        ApiResult<Integer> result=new ApiResult<>(null);
        if (proExists>0) {
            Product product = productMapper.selectById(id);

            Station station = stationFeignClient.stationIsEmptyById(product.getCurrentStationId());
            if (station!=null) {
                if (!product.getCurrentStationId().equals(station.getId())) {
                    product.setCurrentStationId(modifiedStation);
                    int update = productMapper.updateById(product);
                    result.updateOk(update);

                }else {
                    //已在当前工站无需修改
                    result.nothing(null,"已是当前工站");
                }
            }

            result.notFountError(null,"更改工站不存在");
        }

        result.notFountError(null);
        return result;
    }


}
