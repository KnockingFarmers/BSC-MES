package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.model.production.Line;
import com.github.ganlong.model.production.TestData;
import com.github.ganlong.production.mapper.LineMapper;
import com.github.ganlong.production.mapper.TestDataMapper;
import com.github.ganlong.production.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-13
 */
@Service
public class LineServiceImpl extends ServiceImpl<LineMapper, Line> implements LineService {

    @Autowired
    private LineMapper lineMapper;

    @Override
    public Line getLineReport(Long workshopId, Integer lineNo) {
        MapperUtil<Line, LineMapper> mapperUtil = new MapperUtil<>();
        Integer exists = mapperUtil.dataExists("workshop_id", workshopId, lineMapper);

        if (exists>0) {
            QueryWrapper wrapper=new QueryWrapper();
            wrapper.eq("workshop_id",workshopId);
            wrapper.eq("line_no",lineNo);
            return lineMapper.selectOne(wrapper);
        }
        return new Line();
    }
}
