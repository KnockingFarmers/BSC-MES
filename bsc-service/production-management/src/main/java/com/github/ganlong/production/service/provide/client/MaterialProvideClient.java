package com.github.ganlong.production.service.provide.client;

import com.github.ganlong.model.material.Material;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/12 20:31
 * @PackageName:com.github.ganlong.production.service
 * @ClassName: MaterialProvideClient
 * @Description: 调用 Material 服务
 * @Version 1.0
 */
@FeignClient("service-material")
public interface MaterialProvideClient {

    /**
     * 获取产品绑定的所有物料
     * @param id 产品id
     * @return
     */
    @GetMapping("/findBindingMaterialByProductId")
    List<Material> findBindingMaterialByProductId(Long id);
}
