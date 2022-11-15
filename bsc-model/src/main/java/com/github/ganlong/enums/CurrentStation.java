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
     * 当前工站 1-29
     */

    OP010(1),

    OP020(2),

    OP030(3),

    OP040(4),

    OP050(6),

    OP060(7),

    OP070(8),

    OP080(9),

    OP090(10),

    OP110(11),

    OP120(12),

    OP140(13),

    OP150(14),

    OP160(15),

    OP170(16),

    OP180(17),

    OP185(18),

    OP190(19),

    OP210(20),

    OP220(21),

    OP230(22),

    OP240(23),

    OP250(24),

    OP260(25),

    OP265(26),

    OP270(27),

    OP275(28),

    OP280(29),
    ;

    @EnumValue
    private Integer status;

    CurrentStation(int status) {
        this.status=status;
    }
}
