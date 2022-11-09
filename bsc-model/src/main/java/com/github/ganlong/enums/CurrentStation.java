package com.github.ganlong.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/9 21:16
 * @PackageName:com.github.ganlong.enums
 * @ClassName: CurrentStation
 * @Description: 工站枚举
 * @Version 1.0
 */
@Getter
public enum CurrentStation {

    /**
     * 工站状态 1 通过 0 未通过
     */

    OP010(1),

    OP020(1),

    OP030(1),

    OP040(1),

    OP050(1),

    OP060(1),

    OP070(1),

    OP080(1),

    OP090(1),

    OP110(1),

    OP120(1),

    OP140(1),

    OP150(1),

    OP160(1),

    OP170(1),

    OP180(1),

    OP185(1),

    OP186(1),

    OP190(1),

    OP210(1),

    OP220(1),

    OP230(1),

    OP240(1),

    OP250(1),

    OP260(1),

    OP265(1),

    OP270(1),

    OP275(1),

    OP280(1),
    ;

    @EnumValue
    private Integer status;

    CurrentStation(int status) {
        this.status=status;
    }
}
