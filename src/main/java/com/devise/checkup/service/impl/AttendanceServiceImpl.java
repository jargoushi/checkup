package com.devise.checkup.service.impl;

import com.devise.checkup.domain.Attendance;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.mapper.AttendanceMapper;
import com.devise.checkup.service.AttendanceService;
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
public class AttendanceServiceImpl extends AbstractExportService implements AttendanceService {

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
        attendance.setCreateTime(new Date());
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

    @Override
    public void exportExcel(String startTime, String endTime, HttpServletRequest request, HttpServletResponse response) {

        String fileName = "attendance" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        super.exportFormWork(startTime, endTime, fileName, request, response);
    }

    @Override
    protected List<?> getData(String startTime, String endTime) {
        return attendanceMapper.selectAll();
    }

    protected List<String> getTitles() {

        List<String> titles = new ArrayList<>();
        titles.add("主键Id");
        titles.add("用户Id");
        titles.add("巡检员账号");
        titles.add("用户账号");
        titles.add("用户姓名");
        titles.add("进门时间");
        titles.add("进门照片");
        titles.add("进门录音");
        titles.add("出门时间");
        titles.add("出门照片");
        titles.add("出门录音");
        titles.add("在岗时间");
        titles.add("巡检时间");
        titles.add("考勤流程（1-进门，2-巡检完成，3-出门）");
        titles.add("创建者");
        titles.add("创建时间");
        titles.add("修改者");
        titles.add("修改时间");
        titles.add("");
        titles.add("删除状态（0-正常，1-已删除）");
        return titles;
    }
}
