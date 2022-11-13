package com.github.ganlong.production.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.ganlong.commons.uitl.MapperUtil;
import com.github.ganlong.model.production.Line;
import com.github.ganlong.model.production.TestData;
import com.github.ganlong.model.production.Workshop;
import com.github.ganlong.production.mapper.LineMapper;
import com.github.ganlong.production.mapper.TestDataMapper;
import com.github.ganlong.production.mapper.WorkshopMapper;
import com.github.ganlong.production.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ganlong
 * @since 2022-11-12
 */
@Service
public class WorkshopServiceImpl extends ServiceImpl<WorkshopMapper, Workshop> implements WorkshopService {

}
