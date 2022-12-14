package com.github.ganlong.commons.api;

import com.github.ganlong.commons.api.enums.ApiMessageEnum;
import com.github.ganlong.commons.api.enums.ApiStatusCodeEnum;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @Author KnockingFarmers
 * @Date 2022/12/12 9:41
 * @PackageName:com.github.ganlong.commons.api
 * @ClassName: ApiResult
 * @Description: TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ApiResult<T> extends HashMap<String, Object> {

    private T data;

    private ApiMessageEnum message;

    private ApiStatusCodeEnum errorCode;

    public ApiResult(T data) {
        this.data=data;
    }

    public void queryOk() {
        this.message = ApiMessageEnum.SELECT_OK;
        this.errorCode = ApiStatusCodeEnum.OK;
    }

    public void queryError() {
        this.message = ApiMessageEnum.SELECT_ERROR;
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR;
    }

    public void updateOk() {
        this.message = ApiMessageEnum.UPDATE_OK;
        this.errorCode = ApiStatusCodeEnum.OK;
    }

    public void updateError() {
        this.message = ApiMessageEnum.UPDATE_ERROR;
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR;
    }

    public void deleteOk() {
        this.message = ApiMessageEnum.DELETE_OK;
        this.errorCode = ApiStatusCodeEnum.OK;
    }

    public void deleteError() {
        this.message = ApiMessageEnum.DELETE_ERROR;
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR;
    }

    public void insertOk() {
        this.message = ApiMessageEnum.INSERT_OK;
        this.errorCode = ApiStatusCodeEnum.OK;
    }

    public void insertError() {
        this.message = ApiMessageEnum.INSERT_ERROR;
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR;
    }

    public void notFountError(){
        this.message = ApiMessageEnum.NOT_FOUNT_ERROR;
        this.errorCode = ApiStatusCodeEnum.NOT_FOUNT;
    }

    public void loginError(){
        this.message = ApiMessageEnum.LOGIN_ERROR;
        this.errorCode = ApiStatusCodeEnum.PARAM_ERROR;
    }

    public void notLoginError(){
        this.message = ApiMessageEnum.NOT_LOGIN;
        this.errorCode = ApiStatusCodeEnum.NOT_LOGIN;
    }

}
