package com.github.ganlong.production.service.rpc;

import com.github.ganlong.production.entity.Station;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author KnockingFarmers
 * @Date 2022/12/28 10:34
 * @PackageName:com.github.ganlong.production.service.rpc
 * @ClassName: StationFeignClient
 * @Description: TODO
 * @Version 1.0
 */
@Component
@FeignClient("station-management")
public interface StationFeignClient {

    /**
     * 查询工站是否存在
     * @param stationId
     * @return
     */
    @GetMapping("/station/getById")
    Station stationIsEmptyById(@RequestParam("stationId") Long stationId);


    /**
     * 根据两个工站获取两个工站相隔的工站数量
     * @param newStationId
     * @param oldStationId
     * @return
     */
    @GetMapping("/station/getStationHowBigById")
    Integer getStationHowBigById(@RequestParam("newStationId") Long newStationId,
                                 @RequestParam("oldStationId") Long oldStationId);
}
