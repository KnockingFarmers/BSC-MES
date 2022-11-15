package com.github.ganlong.production.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.ganlong.model.production.TestData;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-11
 */
public interface TestDataService extends IService<TestData> {

    /**
     * 根据产品id查询产品该产品的所有测试数据
     * @param id id
     * @return
     */
    List<TestData> getTestDataListByProductId(Long id);

    /**
     * 批量添加测试数据
     * @param testData 数据对象
     * @return
     */
    Integer addTestData(TestData testData);
}
