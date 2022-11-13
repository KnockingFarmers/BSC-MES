package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.model.production.Line;
import com.github.ganlong.production.mapper.LineMapper;
import com.github.ganlong.production.service.LineService;
import org.springframework.stereotype.Service;

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

}
