package com.devise.checkup.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.devise.checkup.domain.Checkmanage;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.domain.ResponseResult;
import com.devise.checkup.service.CheckmanageService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/5/7
 * @Content: 巡检管理
 */
@ApiOperation("巡检管理")
@RestController
@RequestMapping("/checkmanage")
@CrossOrigin
public class CheckManageController {

    private static final Logger logger = LoggerFactory.getLogger(CheckManageController.class);

    @Autowired
    private CheckmanageService checkmanageService;

    @GetMapping("/list")
    @ApiOperation(value = "分页查询巡检管理")
    public ResponseResult<PageBaseInfo<Checkmanage>> listCheckmanage(@RequestParam String startTime,
                                                                          @RequestParam String endTime,
                                                                          @RequestParam(required = false, defaultValue = "1") int page,
                                                                          @RequestParam(required = false, defaultValue = "20") int rows) {

        logger.info("分页查询巡检管理 start, startTime=【{}】, endTime=【{}】, page=【{}】, rows=【{}】", startTime, endTime, page, rows);
        try {
            PageBaseInfo<Checkmanage> pageBaseInfo = checkmanageService.listCheckmanage(startTime, endTime, page, rows);
            logger.info("分页查询巡检管理 success, 响应结果=【{}】", pageBaseInfo);
            return new ResponseResult().success(pageBaseInfo);
        } catch (Exception e) {
            logger.info("分页查询巡检管理 error", e);
            return new ResponseResult().error();
        }
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增巡检管理")
    public ResponseResult<Boolean> addCheckmanage(@RequestBody String checkmanage) {

        logger.info("新增巡检管理 start, checkmanage=【{}】", checkmanage);
        try {
            JSONObject jsonObject = JSON.parseObject(checkmanage);
            String str = jsonObject.getString("checkmanage");
            Checkmanage record = JSON.parseObject(str, Checkmanage.class);
            Boolean flag = checkmanageService.addCheckmanage(record);
            logger.info("新增巡检管理 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("新增巡检管理 error", e);
            return new ResponseResult().error();
        }

    }

    @PostMapping("/modify")
    @ApiOperation(value = "修改巡检管理")
    public ResponseResult<Boolean> modifyCheckmanage(@RequestBody String checkmanage) {
        logger.info("修改巡检管理 start, checkmanage=【{}】", checkmanage);
        try {
            JSONObject jsonObject = JSON.parseObject(checkmanage);
            String str = jsonObject.getString("checkmanage");
            Checkmanage record = JSON.parseObject(str, Checkmanage.class);
            Boolean flag = checkmanageService.modifyCheckmanage(record);
            logger.info("修改巡检管理 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("修改巡检管理 error", e);
            return new ResponseResult().error();
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据id删除巡检管理")
    public ResponseResult<Boolean> deleteCheckmanage(@PathVariable Integer id) {
        logger.info("根据id删除巡检管理 start, id=【{}】", id);
        try {
            Boolean flag = checkmanageService.deleteCheckmanage(id);
            logger.info("根据id删除巡检管理 success, 响应结果=【{}】", flag);
            return new ResponseResult().success(flag);
        } catch (Exception e) {
            logger.info("根据id删除巡检管理 error", e);
            return new ResponseResult().error();
        }
    }

    @ApiOperation(value = "导出巡检管理")
    @GetMapping(value = "/export")
    public void exportExcel(HttpServletRequest request,
                            HttpServletResponse response) {

        logger.info("导出巡检管理 start");
        try {
            checkmanageService.exportExcel(request, response);
            logger.info("导出巡检管理 success");
        } catch (Exception e) {
            logger.info("导出巡检管理 error", e);
        }
    }

    @PostMapping("/leadingIn")
    @ApiOperation("巡检管理导入")
    public ResponseResult<Boolean> leadingIn(MultipartFile file) {

        logger.info("巡检管理导入 start");
        if (file == null || file.getSize() == 0) {
            logger.info("巡检导入文件为空");
            return new ResponseResult().error();
        }

        boolean flag = false;
        try {
            checkmanageService.leadingIn(file);
            flag = true;
            logger.info("巡检管理导入 success");
        } catch (Exception e) {
            logger.info("巡检管理导入 error", e);
            flag = false;
        }
        return new ResponseResult().success(flag);
    }
}
