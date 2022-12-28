package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.api.ApiResult;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.model.production.Product;
import com.github.ganlong.model.production.TestData;
import com.github.ganlong.production.entity.Station;
import com.github.ganlong.production.mapper.ProductMapper;
import com.github.ganlong.production.mapper.TestDataMapper;
import com.github.ganlong.production.service.TestDataService;
import com.github.ganlong.production.service.rpc.StationFeignClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-11
 */
@Service
public class TestDataServiceImpl extends ServiceImpl<TestDataMapper, TestData> implements TestDataService {

    @Autowired
    private TestDataMapper testDataMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StationFeignClient stationFeignClient;

    @Override
    public List<TestData> getTestDataListByProductId(Long id) {

        MapperUtil<TestData, TestDataMapper> mapperUtil = new MapperUtil<>();
        Integer exists = mapperUtil.dataExists("product_id", id, testDataMapper);

        if (exists > 0) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("product_id", id);
            return testDataMapper.selectList(wrapper);
        }
        return new ArrayList<>();
    }

    @Override
    public ApiResult addTestData(TestData testData) {

        MapperUtil<Product, ProductMapper> mapperUtil = new MapperUtil<>();
        Integer proExists = mapperUtil.dataExists(
                "product_id",
                testData.getProductId(),
                productMapper);

        ApiResult<Integer> result = new ApiResult<>();
        //如果产品存在
        if (proExists > 0) {

            QueryWrapper wrapper = new QueryWrapper();
            wrapper.select("current_station_id");
            wrapper.eq("id", testData.getProductId());
            Product product = productMapper.selectById(wrapper);

            Station station = stationFeignClient
                    .stationIsEmptyById(testData.getStationId());

            if (station!=null) {
                Integer howBig =stationFeignClient.getStationHowBigById(
                        station.getId(), product.getCurrentStationId());

                //如果测试工站是当前产品的下一个工站则添加
                if (howBig!=null&&howBig.equals(1)) {
                    int insert = testDataMapper.insert(testData);
                    result.insertOk(insert);
                }

            }
            result.notFountError(null,"找不到传入的工站");

        }

        result.notFountError(null,"不存在该产品");
        return result;
    }
}
