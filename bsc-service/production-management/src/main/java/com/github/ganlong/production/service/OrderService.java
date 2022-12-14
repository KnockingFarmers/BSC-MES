package com.github.ganlong.production.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.ganlong.commons.api.ApiResult;
import com.github.ganlong.model.production.Order;

/**
 * <p>
 * 生产管理订单表 服务类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-08
 */
public interface OrderService extends IService<Order> {

    /**
     * 查询单个订单下已产出产品的数量
     * @param orderId 订单id
     * @return 数量
     */
    Long queryOrderOkProductNum(Long orderId);

    /**
     * 查询单个订单下的作业计划报表
     * @param orderId 订单id
     * @return OrderDTO
     */
    ApiResult queryOrderPlan(Long orderId);

    /**
     * 添加订单
     * @param order
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    ApiResult saveOrder(Order order) throws NoSuchFieldException, IllegalAccessException;

    /**
     * 根据订单号获取订单
     * @param orderNo 订单号
     * @return
     */
    ApiResult queryOrderByOrderNo(String orderNo);



}
