package com.devise.checkup.mapper;

import com.devise.checkup.domain.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendanceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Attendance record);

    Attendance selectByPrimaryKey(Long id);

    List<Attendance> selectAll();

    int updateByPrimaryKey(Attendance record);

    List<Attendance> selectByCondition(@Param("startTime") String startTime, @Param("endTime") String endTime);
}