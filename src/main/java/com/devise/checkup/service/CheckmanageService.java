package com.devise.checkup.service;

import com.devise.checkup.domain.Checkmanage;
import com.devise.checkup.domain.PageBaseInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/5/7
 * @Content:
 */
public interface CheckmanageService {
    PageBaseInfo<Checkmanage> listCheckmanage(String startTime, String endTime, int page, int rows);

    Boolean addCheckmanage(Checkmanage record);

    Boolean modifyCheckmanage(Checkmanage record);

    Boolean deleteCheckmanage(Integer id);

    void exportExcel(HttpServletRequest request, HttpServletResponse response);

    void leadingIn(MultipartFile file);
}
