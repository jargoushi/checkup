package com.devise.checkup.mapper;

import com.devise.checkup.domain.CheckPerson;
import java.util.List;

public interface CheckPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CheckPerson record);

    CheckPerson selectByPrimaryKey(Integer id);

    List<CheckPerson> selectAll();

    int updateByPrimaryKey(CheckPerson record);

    CheckPerson queryMaxCodeOrderByCreateTime();

    List<CheckPerson> selectByCondition(String startTime, String endTime);
}