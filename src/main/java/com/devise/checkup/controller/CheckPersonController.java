package com.devise.checkup.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.devise.checkup.domain.CheckPerson;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.domain.ResponseResult;
import com.devise.checkup.service.CheckPersonService;
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
 * @Date:2020/4/21
 * @Content:
 */
@ApiOperation("巡检人员管理")
@RestController
@RequestMapping("/checkPerson")
@CrossOrigin
public class CheckPersonController {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonController.class);

    @Autowired
    private CheckPersonService checkPersonService;

    @GetMapping("/list")
    @ApiOperation(value = "分页查询巡检人员")
    public ResponseResult<PageBaseInfo<CheckPerson>> listCheckPerson(@RequestParam String startTime,
                                                                     @RequestParam String endTime,
                                                                     @RequestParam(required = false, defaultValue = "1") int page,
                                                                     @RequestParam(required = false, defaultValue = "20") int rows) {

        logger.info("分页查询巡检人员 start, startTime=【{}】, endTime=【{}】, page=【{}】, rows=【{}】", startTime, endTime, page, rows);
        try {
            PageBaseInfo<CheckPerson> pageBaseInfo = checkPersonService.listCheckPerson(startTime, endTime, page, rows);
            logger.info("分页查询巡检人员 success, 响应结果=【{}】", pageBaseInfo);
            return new ResponseResult().success(pageBaseInfo);
        } catch (Exception e) {
            logger.info("分页查询巡检人员 error", e);
            return new ResponseResult().error();
        }
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增巡检人员")
    public ResponseResult<Boolean> addCheckPerson(@RequestBody String checkPerson) {

        logger.info("新增巡检人员 start, checkPerson=【{}】", checkPerson);
        try {
            JSONObject jsonObject = JSON.parseObject(checkPerson);
            String str = jsonObject.getString("checkPerson");
            CheckPerson record = JSON.parseObject(str, CheckPerson.class);
            Boolean flag = checkPersonService.addCheckPerson(record);
            logger.info("新增巡检人员 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("新增巡检人员 error", e);
            return new ResponseResult().error();
        }

    }

    @PostMapping("/modify")
    @ApiOperation(value = "修改巡检人员")
    public ResponseResult<Boolean> modifyCheckPerson(@RequestBody String checkPerson) {
        logger.info("修改巡检人员 start, checkPerson=【{}】", checkPerson);
        try {
            JSONObject jsonObject = JSON.parseObject(checkPerson);
            String str = jsonObject.getString("checkPerson");
            CheckPerson record = JSON.parseObject(str, CheckPerson.class);
            Boolean flag = checkPersonService.modifyCheckPerson(record);
            logger.info("修改巡检人员 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("修改巡检人员 error", e);
            return new ResponseResult().error();
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除巡检人员")
    public ResponseResult<Boolean> deleteCheckPerson(@PathVariable Integer id) {
        logger.info("根据id删除巡检人员 start, id=【{}】", id);
        try {
            Boolean flag = checkPersonService.deleteCheckPerson(id);
            logger.info("根据id删除巡检人员 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("根据id删除巡检人员 error", e);
            return new ResponseResult().error();
        }
    }

    @ApiOperation(value = "导出巡检人员")
    @GetMapping(value = "/export")
    public void exportExcel(HttpServletRequest request,
                            HttpServletResponse response) {

        logger.info("导出巡检人员 start");
        try {
            checkPersonService.exportExcel(request, response);
            logger.info("导出巡检人员 success");
        } catch (Exception e) {
            logger.info("导出巡检人员 error", e);
        }
    }
}
