package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.commons.core.custom.validator.common.InsertGroup;
import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "测试数据不能为空",groups = {UpdateGroup.class, InsertGroup.class})
    @TableField("test_data")
    private String testData;

    /**
     * 产品id
     */
    @NotNull(message = "产品id不能为空",groups = {UpdateGroup.class, InsertGroup.class})
    @TableField("product_id")
    private Long productId;

    /**
     * 测试工站Id
     */
    @NotNull(message = "测试工站Id不能为空",groups = {UpdateGroup.class, InsertGroup.class})
    @TableField("station_id")
    private Long stationId;

    /**
     * 测试物料，id外键
     */
    @NotNull(message = "测试物料id不能为空",groups = {UpdateGroup.class, InsertGroup.class})
    @TableField("material_id")
    private Long materialId;

    /**
     * 测试线体
     */
    @NotNull(message = "测试线体不能为空",groups = {UpdateGroup.class, InsertGroup.class})
    @TableField("line_id")
    private Long lineId;

    /**
     * 测试名字
     */
    @NotBlank(message = "测试名字不能为空",groups = {UpdateGroup.class, InsertGroup.class})
    @TableField("test_name")
    private String testName;

    /**
     * 是否通过
     */
    @NotNull(message = "是否通过不能为空",groups = {UpdateGroup.class, InsertGroup.class})
    @TableField("passed")
    private Integer passed;

    /**
     * 测试结束时间
     */
    @NotNull(message = "测试结束时间不能为空",groups = {UpdateGroup.class, InsertGroup.class})
    @TableField("gmt_test_end")
    private Date gmtTestEnd;


}
