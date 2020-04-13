package com.devise.checkup.service.impl;

import com.devise.checkup.domain.InspectionRecord;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.mapper.InspectionRecordMapper;
import com.devise.checkup.service.InspectionRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
@Service
public class InspectionRecordServiceImpl implements InspectionRecordService {

    @Autowired
    private InspectionRecordMapper inspectionRecordMapper;

    @Override
    public PageBaseInfo<InspectionRecord> listInspectionRecord(String startTime, String endTime, int page, int rows) {

        //开启分页
        PageHelper.startPage(page, rows);

        // 查询考勤信息
        List<InspectionRecord> attendances = inspectionRecordMapper.selectByCondition(startTime, endTime);

        PageInfo pageInfo = new PageInfo(attendances);

        return new PageBaseInfo<>(page, pageInfo.getTotal(), pageInfo.getPages(), attendances);
    }

    @Override
    public Boolean addInspectionRecord(InspectionRecord attendance) {
        return inspectionRecordMapper.insert(attendance) > 0;
    }

    @Override
    public Boolean modifyInspectionRecord(InspectionRecord attendance) {
        return inspectionRecordMapper.updateByPrimaryKey(attendance) > 0;
    }

    @Override
    public Boolean deleteInspectionRecord(Integer id) {
        return inspectionRecordMapper.deleteByPrimaryKey(Long.valueOf(id)) > 0;
    }
}
