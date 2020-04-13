package com.devise.checkup.service.impl;

import com.devise.checkup.domain.Attendance;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.mapper.AttendanceMapper;
import com.devise.checkup.service.AttendanceService;
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
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public PageBaseInfo<Attendance> listAttendance(String startTime, String endTime, int page, int rows) {

        //开启分页
        PageHelper.startPage(page, rows);

        // 查询考勤信息
        List<Attendance> attendances = attendanceMapper.selectByCondition(startTime, endTime);

        PageInfo pageInfo = new PageInfo(attendances);

        return new PageBaseInfo<>(page, pageInfo.getTotal(), pageInfo.getPages(), attendances);
    }

    @Override
    public Boolean addAttendance(Attendance attendance) {
        return attendanceMapper.insert(attendance) > 0;
    }

    @Override
    public Boolean modifyAttendance(Attendance attendance) {
        return attendanceMapper.updateByPrimaryKey(attendance) > 0;
    }

    @Override
    public Boolean deleteAttendance(Integer id) {
        return attendanceMapper.deleteByPrimaryKey(Long.valueOf(id)) > 0;
    }
}
