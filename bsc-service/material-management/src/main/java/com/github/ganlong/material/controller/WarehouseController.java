package com.github.ganlong.material.controller;


import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.material.service.WarehouseService;
import com.github.ganlong.model.material.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/material/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/findAll")
    public List<Warehouse> findAllWarehouse(){
        return warehouseService.list();
    }

    @PostMapping("/add")
    public boolean addWarehouse(@NotNull Warehouse warehouse){
        return warehouseService.save(warehouse);
    }

    @DeleteMapping("/deleted")
    public boolean deleteWarehouse(@NotNull String warehouseId){
        return warehouseService.removeById(Long.valueOf(warehouseId));
    }

    @PutMapping("/update")
    public boolean updateWarehouse(@Validated(UpdateGroup.class) Warehouse warehouse){
        return warehouseService.updateById(warehouse);
    }


}

