package com.devise.checkup.mapper;

import com.devise.checkup.domain.Attendance;

import java.util.List;

public interface AttendanceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Attendance record);

    Attendance selectByPrimaryKey(Long id);

    List<Attendance> selectAll();

    int updateByPrimaryKey(Attendance record);
}