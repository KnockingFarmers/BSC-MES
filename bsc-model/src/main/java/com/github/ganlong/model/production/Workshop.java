package com.github.ganlong.model.production;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.commons.core.custom.validator.common.InsertGroup;
import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_workshop")
public class Workshop extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 工作人员Id
     */
    @NotNull(message = "工作人员Id不能为空",groups = {UpdateGroup.class, InsertGroup.class})
    @TableField("user_id")
    private Long userId;

    /**
     * 工作人员权限 0最大 9最小
     */
    @TableField("personnel_auth")
    private Integer personnelAuth;

    /**
     * 车间状态，1生产中，0休息或维修中
     */
    @NotNull(message = "车间状态不能为空",groups = {UpdateGroup.class})
    @TableField("status")
    private Integer status;


}
