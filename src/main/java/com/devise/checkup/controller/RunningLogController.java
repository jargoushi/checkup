package com.devise.checkup.controller;

import com.devise.checkup.domain.Attendance;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.domain.RunningLog;
import com.devise.checkup.domain.ResponseResult;
import com.devise.checkup.service.RunningLogService;
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
@Api(value = "运行日志")
@RestController
@RequestMapping("/runninglog")
public class RunningLogController {

    @Autowired
    private RunningLogService runningLogService;

    @GetMapping("/list")
    @ApiOperation(value = "分页查询运行日志")
    public ResponseResult<PageBaseInfo<RunningLog>> listRunningLog(@RequestParam String startTime,
                                                                   @RequestParam String endTime,
                                                                   @RequestParam(required = false, defaultValue = "1") int page,
                                                                   @RequestParam(required = false, defaultValue = "20") int rows) {
        runningLogService.listRunningLog();
        return new ResponseResult<>();
    }

    @PostMapping("add")
    @ApiOperation(value = "新增运行日志")
    public ResponseResult addRunningLog(@RequestBody RunningLog RunningLog) {

        return new ResponseResult();
    }

    @PostMapping("modify")
    @ApiOperation(value = "修改运行日志")
    public ResponseResult modifyRunningLog(@RequestBody RunningLog RunningLog) {

        return new ResponseResult();
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "根据id删除运行日志")
    public ResponseResult deleteRunningLog(@PathVariable Integer id) {

        return new ResponseResult();
    }
}
