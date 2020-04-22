package com.devise.checkup.service;

import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.domain.RunningLog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/13
 * @Content:
 */
public interface RunningLogService {

    PageBaseInfo<RunningLog> listRunningLog(String startTime, String endTime, int page, int rows);

    Boolean addRunningLog(RunningLog attendance);

    Boolean modifyRunningLog(RunningLog attendance);

    Boolean deleteRunningLog(Integer id);

    void exportExcel(HttpServletRequest request, HttpServletResponse response);
}
