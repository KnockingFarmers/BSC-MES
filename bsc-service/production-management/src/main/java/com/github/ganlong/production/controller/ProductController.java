package com.github.ganlong.production.controller;


import com.github.ganlong.model.order.Product;
import com.github.ganlong.production.service.ProductService;
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
 * @since 2022-11-09
 */
@RestController
@RequestMapping("/production/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public List<Product> findAllOrder(){
        return productService.list();
    }

    @PostMapping("/add")
    public boolean addProduct(@NotNull Product product){
        return productService.save(product);
    }

    @DeleteMapping("/deleted")
    public boolean deleteProduct(@NotNull String productId){
        return productService.removeById(productId);
    }

    @PutMapping("/update")
    public boolean updateProduct(@NotNull Product product){
        return productService.updateById(product);
    }

    @GetMapping("/queryProductLife")
    public Product queryProductLife(String id){
        return productService.queryProductLife(Long.valueOf(id));
    }



}

