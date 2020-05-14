package com.devise.checkup.service.impl;

import com.devise.checkup.domain.CheckPerson;
import com.devise.checkup.domain.PageBaseInfo;
import com.devise.checkup.mapper.CheckPersonMapper;
import com.devise.checkup.service.CheckPersonService;
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
 * @Date:2020/4/21
 * @Content:
 */
@Service
public class CheckPersonServiceImpl extends AbstractExportService implements CheckPersonService {

    @Autowired
    private CheckPersonMapper checkPersonMapper;
    // 每月最大排班号
    private static final int MAX_CODE = 21;

    @Override
    public PageBaseInfo<CheckPerson> listCheckPerson(String startTime, String endTime, int page, int rows) {

        //开启分页
        PageHelper.startPage(page, rows);

        // 查询巡检模板
        List<CheckPerson> records = checkPersonMapper.selectByCondition(startTime, endTime);

        PageInfo pageInfo = new PageInfo(records);

        return new PageBaseInfo<>(page, pageInfo.getTotal(), pageInfo.getPages(), records);
    }

    @Override
    public Boolean addCheckPerson(CheckPerson record) {
        // 查询已存存在的最大排班号
        CheckPerson person = checkPersonMapper.queryMaxCodeOrderByCreateTime();
        Integer code = null;
        if (person == null) {
            code = 1;
        } else if (person.getCode() == null || person.getCode() >= MAX_CODE) {

        } else {
            code = person.getCode() + 1;
        }
        record.setCode(code);
        record.setCreatetime(new Date());
        return checkPersonMapper.insert(record) > 0;
    }

    @Override
    public Boolean modifyCheckPerson(CheckPerson record) {
        record.setUpdatetime(new Date());
        return checkPersonMapper.updateByPrimaryKey(record) > 0;
    }

    @Override
    public Boolean deleteCheckPerson(Integer id) {
        return checkPersonMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "checkPerson" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        super.exportFormWork(fileName, request, response);
    }


    @Override
    protected List<?> getData() {
        return checkPersonMapper.selectAll();
    }

    @Override
    protected List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("主键");
        titles.add("设备名称");
        titles.add("部位名称");
        titles.add("描述");
        titles.add("检修项目及标准");

        return titles;
    }
}
