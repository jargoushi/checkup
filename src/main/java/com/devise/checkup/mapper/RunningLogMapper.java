package com.devise.checkup.mapper;

import com.devise.checkup.domain.RunningLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RunningLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RunningLog record);

    RunningLog selectByPrimaryKey(Long id);

    List<RunningLog> selectAll();

    int updateByPrimaryKey(RunningLog record);

    List<RunningLog> selectByCondition(@Param("startTime") String startTime, @Param("endTime") String endTime);
}