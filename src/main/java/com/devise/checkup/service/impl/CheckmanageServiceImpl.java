package com.devise.checkup.service.impl;

import com.devise.checkup.domain.Checkmanage;
import com.devise.checkup.domain.Checkstandard;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.mapper.CheckmanageMapper;
import com.devise.checkup.mapper.CheckstandardMapper;
import com.devise.checkup.service.CheckmanageService;
import com.devise.checkup.util.LeadingInExcelUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/5/7
 * @Content:
 */
@Service
public class CheckmanageServiceImpl extends AbstractExportService implements CheckmanageService {

    @Autowired
    private CheckmanageMapper checkmanageMapper;

    @Autowired
    private CheckstandardMapper checkstandardMapper;

    @Override
    public PageBaseInfo<Checkmanage> listCheckmanage(String startTime, String endTime, int page, int rows) {

        //开启分页
        PageHelper.startPage(page, rows);

        // 查询巡检模板
        List<Checkmanage> records = checkmanageMapper.selectByCondition(startTime, endTime);

        PageInfo pageInfo = new PageInfo(records);

        return new PageBaseInfo<>(page, pageInfo.getTotal(), pageInfo.getPages(), records);
    }

    @Override
    public Boolean addCheckmanage(Checkmanage record) {
        record.setCreatetime(new Date());
        return checkmanageMapper.insert(record) > 0;
    }

    @Override
    public Boolean modifyCheckmanage(Checkmanage record) {
        return checkmanageMapper.updateByPrimaryKey(record) > 0;
    }

    @Override
    public Boolean deleteCheckmanage(Integer id) {
        return checkmanageMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "checkPerson" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        super.exportFormWork(fileName, request, response);
    }

    @Override
    public void leadingIn(MultipartFile file) {
        List<Checkstandard> checkstandards = LeadingInExcelUtils.readExcel(file);
        if (checkstandards == null || checkstandards.size() == 0) {
            return;
        }
        // 插入数据库表
        checkstandards.forEach(standard -> {
            checkstandardMapper.insert(standard);
        });
    }

    @Override
    protected List<?> getData() {
        return checkmanageMapper.selectAll();
    }

    @Override
    protected List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("主键");
        titles.add("姓名");
        titles.add("年龄");
        titles.add("性别");
        titles.add("工种");
        titles.add("版次号");
        titles.add("创建时间");
        titles.add("更新时间");

        return titles;
    }
}
