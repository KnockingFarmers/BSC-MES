package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_test_data")
public class TestData extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 测试数据
     */
    private String testData;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 测试工站
     */
    private Integer station;

    /**
     * 测试物料，id外键
     */
    private Long materialId;

    /**
     * 测试线体
     */
    private Long lineId;

    /**
     * 测试名字
     */
    private String testName;

    /**
     * 是否通过
     */
    private Integer passed;

    /**
     * 测试结束时间
     */
    private Date gmtTestEnd;


}
