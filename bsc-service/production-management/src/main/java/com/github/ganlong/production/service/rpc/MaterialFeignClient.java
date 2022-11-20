package com.github.ganlong.production.service.rpc;

import com.github.ganlong.model.material.Material;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/12 20:31
 * @PackageName:com.github.ganlong.production.service
 * @ClassName: MaterialProvideClient
 * @Description: 调用 Material 服务
 * @Version 1.0
 */
@Component
@FeignClient("material-management")
public interface MaterialFeignClient {

    /**
     * 获取产品绑定的所有物料
     * @param id 产品id
     * @param okMaterial 是否只获取绑定物料
     * @return
     */
    @GetMapping("/material/material/findMaterialByProductId")
    List<Material> findMaterialByProductId(@RequestParam("id") Long id,
                                           @RequestParam("okMaterial") Integer okMaterial);


}
