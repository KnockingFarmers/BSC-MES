package com.github.ganlong.production.controller;


import com.github.ganlong.model.order.TestData;
import com.github.ganlong.production.service.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ganlong
 * @since 2022-11-11
 */
@RestController
@RequestMapping("/production/test_data")
public class TestDataController {

    @Autowired
    private TestDataService testDataService;

    @GetMapping("/findByProductId")
    public List<TestData> findAllTestDataById(String id){
        return testDataService.getTestDataListByProductId(Long.valueOf(id));
    }

    @PostMapping("/add")
    public boolean addTestData(@NotNull TestData testData){
        return testDataService.save(testData);
    }

    @DeleteMapping("/deleted")
    public boolean deleteTestData(@NotNull String id){
        return testDataService.removeById(Long.valueOf(id));
    }

    @PutMapping("/update")
    public boolean updateOrder(@NotNull TestData testData){
        return testDataService.updateById(testData);
    }
}

