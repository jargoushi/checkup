package com.devise.checkup.service.impl;

import com.devise.checkup.domain.Attendance;
import com.devise.checkup.mapper.AttendanceMapper;
import com.devise.checkup.service.AttendanceService;
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
    public String listAttendance() {

        List<Attendance> attendances = attendanceMapper.selectAll();

        return String.valueOf(attendances.size());
    }
}
