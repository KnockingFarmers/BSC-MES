package com.github.ganlong.production.controller;


import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.production.TestData;
import com.github.ganlong.model.production.Workshop;
import com.github.ganlong.production.service.TestDataService;
import com.github.ganlong.production.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ganlong
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/production/workshop")
public class WorkshopController {

    @Autowired
    private WorkshopService workshopService;

    @GetMapping("/findAll")
    public List<Workshop> findAllWorkshop(){
        return workshopService.list();
    }


    @PostMapping("/add")
    public boolean addWorkshop(@Validated Workshop workshop){
        return workshopService.save(workshop);
    }

    @DeleteMapping("/deleted")
    public boolean deleteWorkshop(@NotBlank String id){
        return workshopService.removeById(Long.valueOf(id));
    }

    @PutMapping("/update")
    public boolean updateWorkshop(@Validated(UpdateGroup.class) Workshop workshop){
        return workshopService.updateById(workshop);
    }

}

