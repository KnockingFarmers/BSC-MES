package com.github.ganlong.production.controller;


import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.material.Material;
import com.github.ganlong.model.production.Product;
import com.github.ganlong.production.service.ProductService;
import com.github.ganlong.production.service.rpc.MaterialFeignClient;
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
 * @since 2022-11-09
 */
@RestController
@RequestMapping("/production/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MaterialFeignClient materialFeignClient;

    @GetMapping("/findAll")
    public List<Product> findAllProduct(){
        return productService.list();
    }

    @PostMapping("/add")
    public Boolean addProduct(@Validated Product product){
        return productService.save(product);
    }

    @DeleteMapping("/deleted")
    public Boolean deleteProduct(@NotBlank String productId){
        return productService.removeById(productId);
    }

    @PutMapping("/update")
    public Boolean updateProduct(@Validated(UpdateGroup.class) Product product){
        return productService.updateById(product);
    }

    @GetMapping("/queryProductLife")
    public Product queryProductLife(@NotBlank String id){
        return productService.queryProductLife(Long.valueOf(id));
    }

    @GetMapping("/findMaterialByProductId")
    List<Material> findMaterialByProductId(String id,Integer okMaterial){
        return materialFeignClient.findMaterialByProductId(Long.valueOf(id),okMaterial);
    }

    @PutMapping("/modifiedStation")
    public Integer updateProduct(@Validated String id, Integer modifiedStation){
        return productService.modifiedProductStation(Long.valueOf(id),modifiedStation);
    }

}

