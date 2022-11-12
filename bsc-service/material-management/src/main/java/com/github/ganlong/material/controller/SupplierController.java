package com.github.ganlong.material.controller;


import com.github.ganlong.material.service.SupplierService;
import com.github.ganlong.model.material.Supplier;
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
 * @since 2022-11-12
 */
@RestController
@RequestMapping("/material/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/findAll")
    public List<Supplier> findAllSupplier(){
        return supplierService.list();
    }

    @PostMapping("/add")
    public boolean addSupplier(@NotNull Supplier supplier){
        return supplierService.save(supplier);
    }

    @DeleteMapping("/deleted")
    public boolean deleteSupplier(@NotNull String supplierId){
        return supplierService.removeById(Long.valueOf(supplierId));
    }

    @PutMapping("/update")
    public boolean updateSupplier(@NotNull Supplier supplier){
        return supplierService.updateById(supplier);
    }


}

