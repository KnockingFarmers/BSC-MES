package com.github.ganlong.material.controller;


import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.material.service.MaterialService;
import com.github.ganlong.material.service.SupplierService;
import com.github.ganlong.model.material.Material;
import com.github.ganlong.model.material.Supplier;
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
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/material/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/findAll")
    public List<Material> findAllMaterial(){
        return materialService.list();
    }

    @PostMapping("/add")
    public boolean addMaterial(@NotNull Material material){
        return materialService.save(material);
    }

    @DeleteMapping("/deleted")
    public boolean deleteMaterial(@NotNull String supplierId){
        return materialService.removeById(Long.valueOf(supplierId));
    }

    @PutMapping("/update")
    public boolean updateMaterial(@Validated(UpdateGroup.class) Material material){
        return materialService.updateById(material);
    }

}

