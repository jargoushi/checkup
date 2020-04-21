package com.devise.checkup.service.impl;

import com.devise.checkup.domain.InspectionRecord;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.mapper.InspectionRecordMapper;
import com.devise.checkup.service.InspectionRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
@Service
public class InspectionRecordServiceImpl extends AbstractExportService implements InspectionRecordService {

    @Autowired
    private InspectionRecordMapper inspectionRecordMapper;

    @Override
    public PageBaseInfo<InspectionRecord> listInspectionRecord(String startTime, String endTime, int page, int rows) {

        //开启分页
        PageHelper.startPage(page, rows);

        // 查询巡检模板
        List<InspectionRecord> attendances = inspectionRecordMapper.selectByCondition(startTime, endTime);

        PageInfo pageInfo = new PageInfo(attendances);

        return new PageBaseInfo<>(page, pageInfo.getTotal(), pageInfo.getPages(), attendances);
    }

    @Override
    public Boolean addInspectionRecord(InspectionRecord attendance) {
        attendance.setCreateTime(new Date());
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

    @Override
    public void exportExcel(String startTime, String endTime, HttpServletRequest request, HttpServletResponse response) {
        String fileName = "inspectionRecord" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        super.exportFormWork(startTime, endTime, fileName, request, response);
    }

    @Override
    public Boolean remind() {

        return inspectionRecordMapper.query30MinuteRecord() == 0;
    }

    @Override
    protected List<?> getData(String startTime, String endTime) {
        return inspectionRecordMapper.selectAll();
    }

    @Override
    protected List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("主键");
        titles.add("巡检编号");
        titles.add("巡检模板Id");
        titles.add("巡检结论");
        titles.add("上班遗留问题（机械）");
        titles.add("上班遗留问题（电气）");
        titles.add("本班发现问题（机械）");
        titles.add("本班发现问题（电气）");
        titles.add("本班遗留问题（机械）");
        titles.add("本班遗留问题（电气）");
        titles.add("巡检人(钳工)");
        titles.add("巡检人(电工)");
        titles.add("班次(夜班、早班、中班)");
        titles.add("检查人");
        titles.add("");
        titles.add("");
        titles.add("创建时间");
        titles.add("");
        titles.add("修改时间");
        titles.add("");

        return titles;
    }
}
