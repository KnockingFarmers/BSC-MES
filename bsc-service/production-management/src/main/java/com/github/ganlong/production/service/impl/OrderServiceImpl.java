package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.api.ApiResult;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.commons.uitl.UniqueNumberUtil;
import com.github.ganlong.model.production.Order;
import com.github.ganlong.production.mapper.OrderMapper;
import com.github.ganlong.production.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 生产管理订单表 服务实现类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;


    @Override
    public Long queryOrderOkProductNum(Long orderId) {
        MapperUtil<Order, OrderMapper> mapperUtil = new MapperUtil<>();
        Integer count = mapperUtil.dataExists("id",orderId,orderMapper);
        if (count!=0) {
            return orderMapper.selectOrderOkProductNum(orderId);
        }
        return 0L;
    }

    @Override
    public Order queryOrderPlan(Long orderId) {
        MapperUtil<Order, OrderMapper> mapperUtil = new MapperUtil<>();
        Integer count = mapperUtil.dataExists("id",orderId,orderMapper);
        if (count!=0) {
            return orderMapper.selectPlanByOrderId(orderId);
        }
        return new Order();
    }

    @Override
    public ApiResult saveOrder(Order order) throws NoSuchFieldException, IllegalAccessException {

        order.setGmtCreated(new Date());

        order.setStatus(0);

        String orderNo = UniqueNumberUtil.generateUniqueNum(String.valueOf(order.getCustomerId()));

        order.setOrderNo(orderNo);
        int insert = orderMapper.insert(order);

        ApiResult<Integer> apiObject=new ApiResult<>(insert);

        if (insert>0) {
            apiObject.queryOk();
        }else {
            apiObject.queryError();
        }

        apiObject.setData(insert);
        return apiObject;
    }

    @Override
    public ApiResult queryOrderByOrderNo(String orderNo) {

        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderNo);
        Order order = orderMapper.selectOne(wrapper);

        ApiResult<Order> apiObject=new ApiResult<>(order);

        if (order!=null) {
           apiObject.queryOk();
        }else {
            apiObject.notFountError();
        }

        apiObject.setData(order);
        return apiObject;
    }


}
