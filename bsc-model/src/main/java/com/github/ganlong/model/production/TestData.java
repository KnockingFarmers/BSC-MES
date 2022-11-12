package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-11
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


}
