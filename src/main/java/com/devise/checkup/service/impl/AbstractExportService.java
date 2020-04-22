package com.devise.checkup.service.impl;

import com.devise.checkup.domain.ExcelData;
import com.devise.checkup.util.ExportExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/14
 * @Content:    抽象的excel导出service
 */
public abstract class AbstractExportService {

    private static final Logger logger = LoggerFactory.getLogger(AbstractExportService.class);

    protected void exportFormWork(String fileName, HttpServletRequest request, HttpServletResponse response) {

        try {
            // 1. 准备数据
            List<?> data = getData();
            // 2. 准备表头
            List<String> titles = getTitles();

            // 3. 转换为导出的数据
            List<List<Object>> objs = changeData(data);

            // 4. 执行导出
            ExportExcelUtils.exportExcel(request, response, fileName, new ExcelData(titles, objs, "巡检模板"));
            logger.info("巡检模板导出成功. fileName=【{}】", fileName);
        } catch (Exception e) {
            logger.info("巡检模板导出失败. fileName=【{}】", fileName, e);
        }
    }

    private List<List<Object>> changeData(List<?> data) {
        if (data == null || data.size() == 0) {
            return Collections.EMPTY_LIST;
        }

        List<List<Object>> rows = new ArrayList<>();
        for (Object obj : data) {
            List<Object> cells = new ArrayList<>();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                //对于private的属性，如果不解锁，那么将无法访问，会报错
                field.setAccessible(true);
                Object cellVal = "";
                try {
                    cellVal = String.valueOf(field.get(obj));
                } catch (IllegalAccessException e) {
                    cellVal = "";
                }
                cells.add(cellVal);
            }
            rows.add(cells);
        }
        return rows;
    }

    protected abstract List<String> getTitles();

    protected abstract List<?> getData();
}
