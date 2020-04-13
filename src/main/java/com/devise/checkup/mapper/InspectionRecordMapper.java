package com.devise.checkup.mapper;

import com.devise.checkup.domain.InspectionRecord;

import java.util.List;
public interface InspectionRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InspectionRecord record);

    InspectionRecord selectByPrimaryKey(Long id);

    List<InspectionRecord> selectAll();

    int updateByPrimaryKey(InspectionRecord record);
}