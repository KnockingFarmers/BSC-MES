package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "测试数据不能为空")
    private String testData;

    /**
     * 产品id
     */
    @NotNull(message = "产品id不能为空")
    private Long productId;

    /**
     * 测试工站
     */
    @NotNull(message = "测试工站不能为空")
    private Integer station;

    /**
     * 测试物料
     */
    private Long materialId;

    /**
     * 测试线体
     */
    @NotNull(message = "线体id不能为空")
    private Long lineId;

}
