package com.github.ganlong.commons.api;

import com.github.ganlong.commons.api.enums.ApiMessageEnum;
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

    private String message;

    private String errorCode;


    public void queryOk(T data) {
        this.message = ApiMessageEnum.SELECT_OK.toString();
        this.data=data;
//        this.errorCode=
    }


}
