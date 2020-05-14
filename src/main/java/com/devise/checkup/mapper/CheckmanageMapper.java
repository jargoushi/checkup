package com.devise.checkup.mapper;

import com.devise.checkup.domain.Checkmanage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckmanageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Checkmanage record);

    Checkmanage selectByPrimaryKey(Integer id);

    List<Checkmanage> selectAll();

    int updateByPrimaryKey(Checkmanage record);

    List<Checkmanage> selectByCondition(@Param("startTime") String startTime, @Param("endTime") String endTime);
}