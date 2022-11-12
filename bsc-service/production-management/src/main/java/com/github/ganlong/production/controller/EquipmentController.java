package com.github.ganlong.production.controller;


import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.production.Equipment;
import com.github.ganlong.model.production.Order;
import com.github.ganlong.production.service.EquipmentService;
import com.github.ganlong.production.service.OrderService;
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
@RequestMapping("/production/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/findAll")
    public List<Equipment> findAllEquipment(){
        return equipmentService.list();
    }

    @PostMapping("/add")
    public boolean addEquipment(@Validated Equipment equipment){
        return equipmentService.save(equipment);
    }

    @DeleteMapping("/deleted")
    public boolean deleteEquipmentId(@Validated String equipmentId){
        return equipmentService.removeById(Long.valueOf(equipmentId));
    }

    @PutMapping("/update")
    public boolean updateEquipment(@Validated(UpdateGroup.class) Equipment equipment){
        return equipmentService.updateById(equipment);
    }


}

