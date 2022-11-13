package com.github.ganlong.production.controller;


import com.github.ganlong.commons.core.custom.validator.common.UpdateGroup;
import com.github.ganlong.model.production.Equipment;
import com.github.ganlong.model.production.Line;
import com.github.ganlong.production.service.EquipmentService;
import com.github.ganlong.production.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ganlong
 * @since 2022-11-13
 */
@RestController
@RequestMapping("/production/line")
public class LineController {

    @Autowired
    private LineService lineService;

    @GetMapping("/findAll")
    public List<Line> findAllLine(){
        return lineService.list();
    }

    @PostMapping("/add")
    public boolean addLine(@Validated Line line){
        return lineService.save(line);
    }

    @DeleteMapping("/deleted")
    public boolean deleteLine(@Validated String lineId){
        return lineService.removeById(Long.valueOf(lineId));
    }

    @PutMapping("/update")
    public boolean updateLine(@Validated(UpdateGroup.class) Line line){
        return lineService.updateById(line);
    }

    @GetMapping("/findLine")
    public Line findLine(String workshopId,Integer lineNo){
        return lineService.getLineReport(Long.valueOf(workshopId),lineNo);
    }

}

