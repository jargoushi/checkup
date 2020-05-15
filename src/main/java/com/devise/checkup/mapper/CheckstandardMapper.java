package com.devise.checkup.mapper;

import com.devise.checkup.domain.Checkstandard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckstandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Checkstandard record);

    Checkstandard selectByPrimaryKey(Integer id);

    List<Checkstandard> selectAll();

    int updateByPrimaryKey(Checkstandard record);

    Checkstandard selectByCondition(@Param("device") String device,@Param("place") String place);
}