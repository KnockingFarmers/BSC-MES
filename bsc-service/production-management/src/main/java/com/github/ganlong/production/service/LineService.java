package com.github.ganlong.production.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.ganlong.model.production.Line;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-13
 */
public interface LineService extends IService<Line> {

    /**
     * 获取车间单个线体的数据
     * @param workshopId 车间id
     * @param lineNo 线体编号
     * @return
     */
    Line getLineReport(Long workshopId, Integer lineNo);
}
