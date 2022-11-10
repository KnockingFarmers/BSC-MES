package com.github.ganlong.production.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.ganlong.model.order.Order;
import com.github.ganlong.model.order.Plan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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


    /**
     * 查询单个订单下的已完成产品数量
     * @param orderId
     * @return
     */
    Long selectOrderOkProductNum(Long orderId);

    /**
     * 查询单个订单下的作业计划报表
     * @param orderId 订单id
     * @return
     */
    Order selectPlanByOrderId(Long orderId);


}
