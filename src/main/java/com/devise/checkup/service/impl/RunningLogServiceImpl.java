package com.devise.checkup.service.impl;

import com.devise.checkup.domain.RunningLog;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.mapper.RunningLogMapper;
import com.devise.checkup.service.RunningLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
@Service
public class RunningLogServiceImpl extends AbstractExportService implements RunningLogService {

    @Autowired
    private RunningLogMapper runningLogMapper;

    @Override
    public PageBaseInfo<RunningLog> listRunningLog(String startTime, String endTime, int page, int rows) {

        //开启分页
        PageHelper.startPage(page, rows);

        // 查询运行日志
        List<RunningLog> runningLogs = runningLogMapper.selectByCondition(startTime, endTime);

        PageInfo pageInfo = new PageInfo(runningLogs);

        return new PageBaseInfo<>(page, pageInfo.getTotal(), pageInfo.getPages(), runningLogs);
    }

    @Override
    public Boolean addRunningLog(RunningLog runningLog) {

        runningLog.setCreateTime(new Date());
        return runningLogMapper.insert(runningLog) > 0;
    }

    @Override
    public Boolean modifyRunningLog(RunningLog runningLog) {
        runningLog.setUpdateTime(new Date());
        return runningLogMapper.updateByPrimaryKey(runningLog) > 0;
    }

    @Override
    public Boolean deleteRunningLog(Integer id) {
        return runningLogMapper.deleteByPrimaryKey(Long.valueOf(id)) > 0;
    }

    @Override
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "runningLog" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        super.exportFormWork(fileName, request, response);
    }

    @Override
    protected List<?> getData() {
        return runningLogMapper.selectAll();
    }

    @Override
    protected List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("主键");
        titles.add("时间");
        titles.add("制动油");
        titles.add("主电机");
        titles.add("1#变压器");
        titles.add("2#变压器");
        titles.add("辅助变压器");
        titles.add("冷却风机左轴承");
        titles.add("冷却风机右轴承");
        titles.add("风机温度");
        titles.add("高压电压");
        titles.add("励磁电流");
        titles.add("制动油压");
        titles.add("油位");
        titles.add("备用");
        titles.add("备用");
        titles.add("备用");
        titles.add("信号系统");
        titles.add("监控机");
        titles.add("操作台");
        titles.add("液压站");
        titles.add("盘形制动器");
        titles.add("主轴");
        titles.add("主电机");
        titles.add("高压柜");
        titles.add("变压器");
        titles.add("电抗器");
        titles.add("直流快开");
        titles.add("冷却风机");
        titles.add("整流柜风机");
        titles.add("励磁柜风机");
        titles.add("备用");
        titles.add("值班人员");
        titles.add("");
        titles.add("");
        titles.add("创建时间");
        titles.add("");
        titles.add("修改时间");
        titles.add("");

        return titles;
    }
}
