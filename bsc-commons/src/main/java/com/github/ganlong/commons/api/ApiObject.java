package com.github.ganlong.commons.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author KnockingFarmers
 * @Date 2022/12/12 9:41
 * @PackageName:com.github.ganlong.commons.api
 * @ClassName: ApiObject
 * @Description: TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ApiObject<T> extends HashMap<String,Object> {

    private T data;

    private String message;

    private String errorCode;
}
