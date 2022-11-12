package com.github.ganlong.material.controller;


import com.github.ganlong.material.service.WarehouseService;
import com.github.ganlong.model.material.Warehouse;
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
 * @since 2022-11-11
 */
@RestController
@RequestMapping("/material/material")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/findAll")
    public List<Warehouse> findAllMaterial(){
        return warehouseService.list();
    }

    @PostMapping("/add")
    public boolean addMaterial(@NotNull Warehouse warehouse){
        return warehouseService.save(warehouse);
    }

    @DeleteMapping("/deleted")
    public boolean deleteMaterial(@NotNull String warehouseId){
        return warehouseService.removeById(Long.valueOf(warehouseId));
    }

    @PutMapping("/update")
    public boolean updateMaterial(@NotNull Warehouse warehouse){
        return warehouseService.updateById(warehouse);
    }


}

