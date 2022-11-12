package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.model.production.TestData;
import com.github.ganlong.production.mapper.TestDataMapper;
import com.github.ganlong.production.service.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-11
 */
@Service
public class TestDataServiceImpl extends ServiceImpl<TestDataMapper, TestData> implements TestDataService {

    @Autowired
    private TestDataMapper testDataMapper;


    @Override
    public List<TestData> getTestDataListByProductId(Long id) {

        MapperUtil<TestData, TestDataMapper> mapperUtil = new MapperUtil<>();
        Integer exists = mapperUtil.dataExists("product_id", id, testDataMapper);

        if (exists>0) {
            QueryWrapper wrapper=new QueryWrapper();
            wrapper.eq("product_id",id);
            return testDataMapper.selectList(wrapper);
        }
        return new ArrayList<>();
    }
}
