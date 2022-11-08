package com.github.ganlong.production.controller;


import com.github.ganlong.model.order.Order;
import com.github.ganlong.production.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public boolean addOrder(@NotNull Order order){
        return orderService.save(order);
    }

    @DeleteMapping("/deleted")
    public boolean deleteOrder(@NotNull String orderId){
        return orderService.removeById(orderId);
    }

    @PutMapping("/update")
    public boolean updateOrder(@NotNull Order order){
        return orderService.updateById(order);
    }
}

