package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.model.production.Product;
import com.github.ganlong.model.production.TestData;
import com.github.ganlong.production.mapper.ProductMapper;
import com.github.ganlong.production.mapper.TestDataMapper;
import com.github.ganlong.production.service.TestDataService;
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
    public Integer addTestData(TestData testData) {
        MapperUtil<Product, ProductMapper> mapperUtil = new MapperUtil<>();
        Integer exists = mapperUtil.dataExists(
                "product_id",
                testData.getProductId(),
                productMapper);

        //如果产品存在
        if (exists > 0) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.select("current_station");
            wrapper.eq("id", testData.getProductId());
            Product product = productMapper.selectById(wrapper);
            Integer currentStation = product.getCurrentStation();

            //如果测试工站是当前产品的下一个工站则添加
            if ((currentStation + 1) == testData.getStation()) {
                return testDataMapper.insert(testData);
            }
        }
        return 0;
    }
}
