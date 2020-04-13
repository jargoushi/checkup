package com.devise.checkup.controller;

import com.devise.checkup.domain.Attendance;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.domain.ResponseResult;
import com.devise.checkup.service.AttendanceService;
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
@Api(value = "考勤")
@RestController
@RequestMapping("/attend")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/list")
    @ApiOperation(value = "分页查询考勤信息")
    public ResponseResult<PageBaseInfo<Attendance>> listAttendance(@RequestParam String startTime,
                                                       @RequestParam String endTime,
                                                       @RequestParam(required = false, defaultValue = "1") int page,
                                                       @RequestParam(required = false, defaultValue = "20") int rows) {

        attendanceService.listAttendance();
        return new ResponseResult<>();
    }

    @PostMapping("add")
    @ApiOperation(value = "新增考勤信息")
    public ResponseResult addAttendance(@RequestBody Attendance attendance) {

        return new ResponseResult();
    }

    @PostMapping("modify")
    @ApiOperation(value = "修改考勤信息")
    public ResponseResult modifyAttendance(@RequestBody Attendance attendance) {

        return new ResponseResult();
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "根据id考勤信息")
    public ResponseResult deleteAttendance(@PathVariable Integer id) {

        return new ResponseResult();
    }
}
