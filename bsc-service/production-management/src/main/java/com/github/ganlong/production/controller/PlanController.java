package com.github.ganlong.production.controller;


import com.github.ganlong.model.order.Plan;
import com.github.ganlong.production.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ganlong
 * @since 2022-11-08
 */
@RestController
@RequestMapping("/production/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/findAll")
    public List<Plan> findAllOrder(){
        return planService.list();
    }

    @PostMapping("/add")
    public boolean addOrder(@NotNull Plan plan){
        return planService.save(plan);
    }

    @DeleteMapping("/deleted")
    public boolean deleteOrder(@NotNull String planId){
        return planService.removeById(planId);
    }

    @PutMapping("/update")
    public boolean updateOrder(@NotNull Plan plan){
        return planService.updateById(plan);
    }

}

