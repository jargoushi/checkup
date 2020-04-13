package com.devise.checkup.service.impl;

import com.devise.checkup.domain.RunningLog;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.mapper.RunningLogMapper;
import com.devise.checkup.service.RunningLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
@Service
public class RunningLogServiceImpl implements RunningLogService {

    @Autowired
    private RunningLogMapper runningLogMapper;

    @Override
    public PageBaseInfo<RunningLog> listRunningLog(String startTime, String endTime, int page, int rows) {

        //开启分页
        PageHelper.startPage(page, rows);

        // 查询考勤信息
        List<RunningLog> attendances = runningLogMapper.selectByCondition(startTime, endTime);

        PageInfo pageInfo = new PageInfo(attendances);

        return new PageBaseInfo<>(page, pageInfo.getTotal(), pageInfo.getPages(), attendances);
    }

    @Override
    public Boolean addRunningLog(RunningLog attendance) {
        return runningLogMapper.insert(attendance) > 0;
    }

    @Override
    public Boolean modifyRunningLog(RunningLog attendance) {
        return runningLogMapper.updateByPrimaryKey(attendance) > 0;
    }

    @Override
    public Boolean deleteRunningLog(Integer id) {
        return runningLogMapper.deleteByPrimaryKey(Long.valueOf(id)) > 0;
    }
}
