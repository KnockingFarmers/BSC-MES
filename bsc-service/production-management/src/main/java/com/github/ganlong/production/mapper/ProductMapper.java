package com.github.ganlong.production.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.ganlong.model.order.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ganlong
 * @since 2022-11-09
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}
