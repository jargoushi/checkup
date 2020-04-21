package com.devise.checkup.controller;

import com.devise.checkup.domain.*;
import com.devise.checkup.service.RunningLogService;
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
@Api(value = "运行日志")
@RestController
@RequestMapping("/runninglog")
@CrossOrigin
public class RunningLogController {

    private static final Logger logger = LoggerFactory.getLogger(RunningLogController.class);

    @Autowired
    private RunningLogService runningLogService;


    @GetMapping("/list")
    @ApiOperation(value = "分页查询运行日志")
    public ResponseResult<PageBaseInfo<RunningLog>> listRunningLog(@RequestParam String startTime,
                                                                   @RequestParam String endTime,
                                                                   @RequestParam(required = false, defaultValue = "1") int page,
                                                                   @RequestParam(required = false, defaultValue = "20") int rows) {

        logger.info("分页查询运行日志 start, startTime=【{}】, endTime=【{}】, page=【{}】, rows=【{}】", startTime, endTime, page, rows);
        try {
            PageBaseInfo<RunningLog> pageBaseInfo = runningLogService.listRunningLog(startTime, endTime, page, rows);
            logger.info("分页查询运行日志 success, 响应结果=【{}】", pageBaseInfo);
            return new ResponseResult().success(pageBaseInfo);
        } catch (Exception e) {
            logger.info("分页查询运行日志 error", e);
            return new ResponseResult().error();
        }
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增运行日志")
    public ResponseResult<Boolean> addRunningLog(@RequestBody RunningLog attendance) {
        logger.info("新增运行日志 start, attendance=【{}】", attendance);
        try {
            Boolean flag = runningLogService.addRunningLog(attendance);
            logger.info("新增运行日志 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("新增运行日志 error", e);
            return new ResponseResult().error();
        }

    }

    @PostMapping("/modify")
    @ApiOperation(value = "修改运行日志")
    public ResponseResult<Boolean> modifyRunningLog(@RequestBody RunningLog attendance) {
        logger.info("修改运行日志 start, attendance=【{}】", attendance);
        try {
            Boolean flag = runningLogService.modifyRunningLog(attendance);
            logger.info("修改运行日志 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("修改运行日志 error", e);
            return new ResponseResult().error();
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除运行日志")
    public ResponseResult<Boolean> deleteRunningLog(@PathVariable Integer id) {
        logger.info("根据id删除运行日志 start, id=【{}】", id);
        try {
            Boolean flag = runningLogService.deleteRunningLog(id);
            logger.info("根据id删除运行日志 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("根据id删除运行日志 error", e);
            return new ResponseResult().error();
        }
    }

    @ApiOperation(value = "导出运行日志")
    @GetMapping(value = "/export")
    public void exportExcel(@RequestParam(required = false) String startTime,
                            @RequestParam(required = false) String endTime,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        logger.info("导出运行日志 start, startTime=【{}】, endTime=【{}】", startTime, endTime);
        try {
            runningLogService.exportExcel(startTime, endTime, request, response);
            logger.info("导出运行日志 success");
        } catch (Exception e) {
            logger.info("导出运行日志 error", e);
        }
    }
}
