package com.github.ganlong.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/12 20:13
 * @PackageName:com.github.ganlong.enums
 * @ClassName: MaterialStatus
 * @Description: TODO
 * @Version 1.0
 */
public enum MaterialStatus {

    BINDING(1),
    SAVING(0),
    SCRAP(3)
    ;

    @EnumValue
    private Integer status;

    MaterialStatus(int status) {
        this.status=status;
    }
}
