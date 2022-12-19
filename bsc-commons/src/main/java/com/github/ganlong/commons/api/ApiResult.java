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

    public void queryOk() {
        this.message = ApiMessageEnum.SELECT_OK.getMessage();
        this.errorCode = ApiStatusCodeEnum.OK.getStatus();
    }

    public void queryError() {
        this.message = ApiMessageEnum.SELECT_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR.getStatus();
    }

    public void updateOk() {
        this.message = ApiMessageEnum.UPDATE_OK.getMessage();
        this.errorCode = ApiStatusCodeEnum.OK.getStatus();
    }

    public void updateError() {
        this.message = ApiMessageEnum.UPDATE_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR.getStatus();
    }

    public void deleteOk() {
        this.message = ApiMessageEnum.DELETE_OK.getMessage();
        this.errorCode = ApiStatusCodeEnum.OK.getStatus();
    }

    public void deleteError() {
        this.message = ApiMessageEnum.DELETE_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR.getStatus();
    }

    public void insertOk() {
        this.message = ApiMessageEnum.INSERT_OK.getMessage();
        this.errorCode = ApiStatusCodeEnum.OK.getStatus();
    }

    public void insertError() {
        this.message = ApiMessageEnum.INSERT_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.SERVER_ERROR.getStatus();
    }

    public void notFountError(){
        this.message = ApiMessageEnum.NOT_FOUNT_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.NOT_FOUNT.getStatus();
    }

    public void loginError(){
        this.message = ApiMessageEnum.LOGIN_ERROR.getMessage();
        this.errorCode = ApiStatusCodeEnum.PARAM_ERROR.getStatus();
    }

    public void notLoginError(){
        this.message = ApiMessageEnum.NOT_LOGIN.getMessage();
        this.errorCode = ApiStatusCodeEnum.NOT_LOGIN.getStatus();
    }

}
