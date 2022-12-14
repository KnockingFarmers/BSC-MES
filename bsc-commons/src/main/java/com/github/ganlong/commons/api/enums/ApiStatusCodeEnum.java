package com.github.ganlong.commons.api.enums;

/**
 * @Author KnockingFarmers
 * @Date 2022/12/14 9:44
 * @PackageName:com.github.ganlong.commons.api.enums
 * @ClassName: ApiStatusCodeEnum
 * @Description: HTTP状态码枚举
 * @Version 1.0
 */
public enum ApiStatusCodeEnum {

    NOT_FOUNT(404),

    OK(200),

    SERVER_ERROR(500),

    PARAM_ERROR(412),

    TIME_OUT(408),

    AUTH_ERROR(406),

    NOT_LOGIN(401);

    private int status;

    ApiStatusCodeEnum(int status){
        this.status=status;
    }



}
