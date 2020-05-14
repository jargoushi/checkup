package com.devise.checkup.mapper;

import com.devise.checkup.domain.Checkstandard;

import java.util.List;

public interface CheckstandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Checkstandard record);

    Checkstandard selectByPrimaryKey(Integer id);

    List<Checkstandard> selectAll();

    int updateByPrimaryKey(Checkstandard record);
}