package com.devise.checkup.mapper;

import com.devise.checkup.domain.InspectionRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface InspectionRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InspectionRecord record);

    InspectionRecord selectByPrimaryKey(Long id);

    List<InspectionRecord> selectAll();

    int updateByPrimaryKey(InspectionRecord record);

    List<InspectionRecord> selectByCondition(@Param("startTime") String startTime, @Param("endTime") String endTime);

    int query30MinuteRecord();
}