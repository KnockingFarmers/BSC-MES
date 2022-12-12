package com.github.ganlong.production.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.production.Order;
import com.github.ganlong.production.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 生产管理订单表 前端控制器
 * </p>
 *
 * @author ganlong
 * @since 2022-11-08
 */
@RestController
@RequestMapping("/production/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll")
    public List<Order> findAllOrder(){
        return orderService.list();
    }

    @PostMapping("/add")
    public boolean addOrder(@Validated Order order){
        return orderService.save(order);
    }

    @DeleteMapping("/deleted")
    public boolean deleteOrder(@Validated String orderId){
        return orderService.removeById(Long.valueOf(orderId));
    }

    @PutMapping("/update")
    public boolean updateOrder(@Validated(UpdateGroup.class) Order order){
        return orderService.updateById(order);
    }

    @GetMapping("/getOrderOkProduct")
    public Long getOrderOkProduct(@NotBlank(message = "id不能为空") String orderId){
        return orderService.queryOrderOkProductNum(Long.valueOf(orderId));
    }

    @GetMapping("/findByOrderNo")
    public Order getOrderById(String orderNo){
        return orderService.getOne(null);
    }
}

