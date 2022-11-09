package com.github.ganlong.production.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.ganlong.model.order.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 生产管理订单表 Mapper 接口
 * </p>
 *
 * @author ganlong
 * @since 2022-11-08
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {


    Long selectOrderOkProductNum(Long orderId);
}
