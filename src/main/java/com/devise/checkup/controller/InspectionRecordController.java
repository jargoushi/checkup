package com.devise.checkup.controller;

import com.devise.checkup.domain.Attendance;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.domain.ResponseResult;
import com.devise.checkup.domain.InspectionRecord;
import com.devise.checkup.service.InspectionRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
@Api(value = "巡检模板")
@RestController
@RequestMapping("/inspectionRecord")
public class InspectionRecordController {

    @Autowired
    private InspectionRecordService inspectionRecordService;

    @GetMapping("/list")
    @ApiOperation(value = "分页查询巡检模板")
    public ResponseResult<PageBaseInfo<InspectionRecord>> listInspectionRecord(@RequestParam String startTime,
                                                                         @RequestParam String endTime,
                                                                         @RequestParam(required = false, defaultValue = "1") int page,
                                                                         @RequestParam(required = false, defaultValue = "20") int rows) {
        inspectionRecordService.listInspectionRecord();
        return new ResponseResult<>();
    }

    @PostMapping("add")
    @ApiOperation(value = "新增巡检模板")
    public ResponseResult addInspectionRecord(@RequestBody InspectionRecord InspectionRecord) {

        return new ResponseResult();
    }

    @PostMapping("modify")
    @ApiOperation(value = "修改巡检模板")
    public ResponseResult modifyInspectionRecord(@RequestBody InspectionRecord InspectionRecord) {

        return new ResponseResult();
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "根据id巡检模板")
    public ResponseResult deleteInspectionRecord(@PathVariable Integer id) {

        return new ResponseResult();
    }
}
