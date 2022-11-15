package com.github.ganlong.commons.config;

import lombok.Data;

import java.util.Map;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/14 19:08
 * @PackageName:com.github.ganlong.commons.config
 * @ClassName: JwtInfo
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class JwtInfo {

    private Map<String,Object> tokenInfo;
}
