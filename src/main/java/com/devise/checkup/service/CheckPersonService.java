package com.devise.checkup.service;


import com.devise.checkup.domain.CheckPerson;
import com.devise.checkup.domain.PageBaseInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/21
 * @Content:
 */
public interface CheckPersonService {


    PageBaseInfo<CheckPerson> listCheckPerson(String startTime, String endTime, int page, int rows);

    Boolean addCheckPerson(CheckPerson record);

    Boolean modifyCheckPerson(CheckPerson record);

    Boolean deleteCheckPerson(Integer id);

    void exportExcel(HttpServletRequest request, HttpServletResponse response);
}
