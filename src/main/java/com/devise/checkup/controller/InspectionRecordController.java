package com.devise.checkup.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.devise.checkup.domain.InspectionRecord;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.domain.ResponseResult;
import com.devise.checkup.service.InspectionRecordService;
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
@Api(value = "巡检模板")
@RestController
@RequestMapping("/inspectionRecord")
@CrossOrigin
public class InspectionRecordController {

    private static final Logger logger = LoggerFactory.getLogger(InspectionRecordController.class);

    @Autowired
    private InspectionRecordService inspectionRecordService;


    @GetMapping("/list")
    @ApiOperation(value = "分页查询巡检模板")
    public ResponseResult<PageBaseInfo<InspectionRecord>> listInspectionRecord(@RequestParam String startTime,
                                                                               @RequestParam String endTime,
                                                                               @RequestParam(required = false, defaultValue = "1") int page,
                                                                               @RequestParam(required = false, defaultValue = "20") int rows) {

        logger.info("分页查询巡检模板 start, startTime=【{}】, endTime=【{}】, page=【{}】, rows=【{}】", startTime, endTime, page, rows);
        try {
            PageBaseInfo<InspectionRecord> pageBaseInfo = inspectionRecordService.listInspectionRecord(startTime, endTime, page, rows);
            logger.info("分页查询巡检模板 success, 响应结果=【{}】", pageBaseInfo);
            return new ResponseResult().success(pageBaseInfo);
        } catch (Exception e) {
            logger.info("分页查询巡检模板 error", e);
            return new ResponseResult().error();
        }
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增巡检模板")
    public ResponseResult<Boolean> addInspectionRecord(@RequestBody String attendance) {

        logger.info("新增巡检模板 start, attendance=【{}】", attendance);
        try {
            JSONObject jsonObject = JSON.parseObject(attendance);
            String str = jsonObject.getString("attendance");
            InspectionRecord record = JSON.parseObject(str, InspectionRecord.class);
            Boolean flag = inspectionRecordService.addInspectionRecord(record);
            logger.info("新增巡检模板 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("新增巡检模板 error", e);
            return new ResponseResult().error();
        }

    }

    @PostMapping("/modify")
    @ApiOperation(value = "修改巡检模板")
    public ResponseResult<Boolean> modifyInspectionRecord(@RequestBody String attendance) {
        logger.info("修改巡检模板 start, attendance=【{}】", attendance);
        try {
            JSONObject jsonObject = JSON.parseObject(attendance);
            String str = jsonObject.getString("attendance");
            InspectionRecord record = JSON.parseObject(str, InspectionRecord.class);
            Boolean flag = inspectionRecordService.modifyInspectionRecord(record);
            logger.info("修改巡检模板 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("修改巡检模板 error", e);
            return new ResponseResult().error();
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除巡检模板")
    public ResponseResult<Boolean> deleteInspectionRecord(@PathVariable Integer id) {
        logger.info("根据id删除巡检模板 start, id=【{}】", id);
        try {
            Boolean flag = inspectionRecordService.deleteInspectionRecord(id);
            logger.info("根据id删除巡检模板 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("根据id删除巡检模板 error", e);
            return new ResponseResult().error();
        }
    }

    @ApiOperation(value = "导出巡检模板")
    @GetMapping(value = "/export")
    public void exportExcel(@RequestParam(required = false) String startTime,
                            @RequestParam(required = false) String endTime,
                            HttpServletRequest request,
                            HttpServletResponse response) {

        logger.info("导出巡检模板 start, startTime=【{}】, endTime=【{}】", startTime, endTime);
        try {
            inspectionRecordService.exportExcel(startTime, endTime, request, response);
            logger.info("导出巡检模板 success");
        } catch (Exception e) {
            logger.info("导出巡检模板 error", e);
        }
    }

    @ApiOperation(value = "报警提醒")
    @GetMapping(value = "/remind")
    public ResponseResult<Boolean> remind() {

        logger.info("报警提醒 start");
        try {
            Boolean flag = inspectionRecordService.remind();
            logger.info("报警提醒 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("报警提醒 error", e);
            return new ResponseResult().error();
        }
    }
}
