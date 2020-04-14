package com.devise.checkup.service;

import com.devise.checkup.domain.InspectionRecord;
import com.devise.checkup.domain.PageBaseInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
public interface InspectionRecordService {

    PageBaseInfo<InspectionRecord> listInspectionRecord(String startTime, String endTime, int page, int rows);

    Boolean addInspectionRecord(InspectionRecord attendance);

    Boolean modifyInspectionRecord(InspectionRecord attendance);

    Boolean deleteInspectionRecord(Integer id);

    void exportExcel(String startTime, String endTime, HttpServletRequest request, HttpServletResponse response);

    Boolean remind();

}
