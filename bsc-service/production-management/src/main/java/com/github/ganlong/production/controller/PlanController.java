package com.github.ganlong.production.controller;


import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.production.Plan;
import com.github.ganlong.production.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
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
    public List<Plan> findAllPlan(){
        return planService.list();
    }

    @PostMapping("/add")
    public boolean addPlan(@Validated Plan plan){
        return planService.save(plan);
    }

    @DeleteMapping("/deleted")
    public boolean deletePlan(@NotBlank String planId){
        return planService.removeById(planId);
    }

    @PutMapping("/update")
    public boolean updatePlan(@Validated(UpdateGroup.class) Plan plan){
        return planService.updateById(plan);
    }

}

