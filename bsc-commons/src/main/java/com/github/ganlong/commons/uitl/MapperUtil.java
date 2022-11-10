package com.github.ganlong.commons.uitl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jdk.nashorn.internal.runtime.logging.Logger;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/10 19:58
 * @PackageName:com.github.ganlong.commons.uitl
 * @ClassName: MapperUtil
 * @Description: TODO
 * @Version 1.0
 */
public class MapperUtil<T,M extends BaseMapper<T>> {

    public Integer dataExists(String column,Object data,M baseMapper){
        if (data==null) {
            throw new IllegalArgumentException("data is null");
        }

       return baseMapper.selectCount(new QueryWrapper<T>().eq(column,data));
    }
}
