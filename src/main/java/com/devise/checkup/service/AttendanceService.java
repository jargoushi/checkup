package com.devise.checkup.service;

import com.devise.checkup.domain.Attendance;
import com.devise.checkup.domain.PageBaseInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content: 考勤信息相关Service
 */
public interface AttendanceService {

    /**
     * 根据开始，结束时间分页查询考勤信息
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param page 起始页
     * @param rows 每页展示条数
     * @return  分页数据
     */
    PageBaseInfo<Attendance> listAttendance(String startTime, String endTime, int page, int rows);

    Boolean addAttendance(Attendance attendance);

    Boolean modifyAttendance(Attendance attendance);

    Boolean deleteAttendance(Integer id);

    void exportExcel(String startTime, String endTime, HttpServletRequest request, HttpServletResponse response);
}
