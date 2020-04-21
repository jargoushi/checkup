package com.devise.checkup.controller;

import com.devise.checkup.domain.Attendance;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.domain.ResponseResult;
import com.devise.checkup.service.AttendanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
@Api(value = "考勤")
@RestController
@RequestMapping("/attend")
@CrossOrigin
public class AttendanceController {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceController.class);

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/list")
    @ApiOperation(value = "分页查询考勤信息")
    public ResponseResult<PageBaseInfo<Attendance>> listAttendance(@RequestParam String startTime,
                                                                   @RequestParam String endTime,
                                                                   @RequestParam(required = false, defaultValue = "1") int page,
                                                                   @RequestParam(required = false, defaultValue = "20") int rows) {

        logger.info("分页查询考勤信息 start, startTime=【{}】, endTime=【{}】, page=【{}】, rows=【{}】", startTime, endTime, page, rows);
        try {
            PageBaseInfo<Attendance> pageBaseInfo = attendanceService.listAttendance(startTime, endTime, page, rows);
            logger.info("分页查询考勤信息 success, 响应结果=【{}】", pageBaseInfo);
            return new ResponseResult().success(pageBaseInfo);
        } catch (Exception e) {
            logger.info("分页查询考勤信息 error", e);
            return new ResponseResult().error();
        }
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增考勤信息")
    public ResponseResult<Boolean> addAttendance(@RequestBody Attendance attendance) {
        logger.info("新增考勤信息 start, attendance=【{}】", attendance);
        try {
            Boolean flag = attendanceService.addAttendance(attendance);
            logger.info("新增考勤信息 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("新增考勤信息 error", e);
            return new ResponseResult().error();
        }

    }

    @PostMapping("/modify")
    @ApiOperation(value = "修改考勤信息")
    public ResponseResult<Boolean> modifyAttendance(@RequestBody Attendance attendance) {
        logger.info("修改考勤信息 start, attendance=【{}】", attendance);
        try {
            Boolean flag = attendanceService.modifyAttendance(attendance);
            logger.info("修改考勤信息 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("修改考勤信息 error", e);
            return new ResponseResult().error();
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除考勤信息")
    public ResponseResult<Boolean> deleteAttendance(@PathVariable Integer id) {
        logger.info("根据id删除考勤信息 start, id=【{}】", id);
        try {
            Boolean flag = attendanceService.deleteAttendance(id);
            logger.info("根据id删除考勤信息 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("根据id删除考勤信息 error", e);
            return new ResponseResult().error();
        }
    }

    @ApiOperation(value = "导出考勤信息")
    @GetMapping(value = "/export")
    public void exportExcel(@RequestParam(required = false) String startTime,
                                               @RequestParam(required = false) String endTime,
                                               HttpServletRequest request,
                                               HttpServletResponse response) {

        logger.info("导出考勤信息 start, startTime=【{}】, endTime=【{}】", startTime, endTime);
        try {
            attendanceService.exportExcel(startTime, endTime, request, response);
            logger.info("导出考勤信息 success");
        } catch (Exception e) {
            logger.info("导出考勤信息 error", e);
        }
    }
}
