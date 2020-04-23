package com.devise.checkup.mapper;

import com.devise.checkup.domain.CheckPerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckPerson record);

    CheckPerson selectByPrimaryKey(Integer id);

    List<CheckPerson> selectAll();

    int updateByPrimaryKey(CheckPerson record);

    List<CheckPerson> selectByCondition(@Param("startTime") String startTime,@Param("endTime") String endTime);
}