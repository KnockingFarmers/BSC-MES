package com.github.ganlong.commons.api;

import com.github.ganlong.commons.api.enums.ApiMessageEnum;
import com.github.ganlong.commons.api.enums.ApiStatusCodeEnum;
import lombok.*;

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
@ToString
public class ApiResult<T>{

    private T data;

    private String message;

    private Integer errorCode;

    public ApiResult(T data) {
        this.data=data;
    }

    public void queryOk(T data) {
        this.message = ApiMessageEnum.SELECT_OK.getMessage();
        this.errorCode = ApiStatusCodeEnum.OK.getStatus();
    }

    public void queryError(T data) {
        this.message = ApiMessageEnum.SELECT_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR.getStatus();
        this.data=data;
    }

    public void updateOk(T data) {
        this.message = ApiMessageEnum.UPDATE_OK.getMessage();
        this.errorCode = ApiStatusCodeEnum.OK.getStatus();
        this.data=data;
    }

    public void updateError(T data) {
        this.message = ApiMessageEnum.UPDATE_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR.getStatus();
        this.data=data;
    }

    public void deleteOk(T data) {
        this.message = ApiMessageEnum.DELETE_OK.getMessage();
        this.errorCode = ApiStatusCodeEnum.OK.getStatus();
        this.data=data;
    }

    public void deleteError(T data) {
        this.message = ApiMessageEnum.DELETE_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR.getStatus();
        this.data=data;
    }

    public void insertOk(T data) {
        this.message = ApiMessageEnum.INSERT_OK.getMessage();
        this.errorCode = ApiStatusCodeEnum.OK.getStatus();
        this.data=data;
    }

    public void insertError(T data) {
        this.message = ApiMessageEnum.INSERT_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR.getStatus();
        this.data=data;
    }

    public void notFountError(T data){
        this.message = ApiMessageEnum.NOT_FOUNT_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.NOT_FOUNT.getStatus();
        this.data=data;
    }

    public void notFountError(T data,String message){
        this.message = message;
        this.errorCode = ApiStatusCodeEnum.NOT_FOUNT.getStatus();
        this.data=data;
    }

    public void loginError(T data){
        this.message = ApiMessageEnum.LOGIN_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.PARAM_ERROR.getStatus();
        this.data=data;
    }

    public void notLoginError(T data){
        this.message = ApiMessageEnum.NOT_LOGIN.getMessage();
        this.errorCode = ApiStatusCodeEnum.NOT_LOGIN.getStatus();
        this.data=data;
    }

    public void paramsError(T data,String message){
        this.message = message;
        this.errorCode = ApiStatusCodeEnum.PARAM_ERROR.getStatus();
        this.data=data;
    }

    public void nothing(T data,String message){
        this.message = message;
        this.errorCode = ApiStatusCodeEnum.NO_THING.getStatus();
        this.data=data;
    }

}
