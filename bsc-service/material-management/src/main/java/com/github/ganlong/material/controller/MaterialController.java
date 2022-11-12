package com.github.ganlong.material.controller;


import com.github.ganlong.material.service.MaterialService;
import com.github.ganlong.model.material.Material;
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
    public boolean deleteMaterial(@NotNull String materialId){
        return materialService.removeById(Long.valueOf(materialId));
    }

    @PutMapping("/update")
    public boolean updateMaterial(@NotNull Material material){
        return materialService.updateById(material);
    }


}

