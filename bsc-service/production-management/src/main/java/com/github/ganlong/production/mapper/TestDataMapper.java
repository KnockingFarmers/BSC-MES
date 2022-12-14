package com.github.ganlong.production.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.ganlong.model.production.TestData;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ganlong
 * @since 2022-11-11
 */
@Mapper
public interface TestDataMapper extends BaseMapper<TestData> {

    /**
     * 批量插入测试数据
     * @param testDataList 测试数据
     * @return
     */
    Integer insertBatchColumn(Collection<TestData> testDataList);
}
