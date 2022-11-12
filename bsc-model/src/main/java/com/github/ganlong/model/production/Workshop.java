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
 * @since 2022-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_workshop")
public class Workshop extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 工作人员姓名
     */
    private String personnelName;

    /**
     * 工作人员权限 0最大 9最小
     */
    private Integer personnelAuth;

    /**
     * 车间状态，1生产中，0休息或维修中
     */
    private Integer status;


}
