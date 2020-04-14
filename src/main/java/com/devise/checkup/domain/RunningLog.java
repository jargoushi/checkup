package com.devise.checkup.domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class RunningLog {
    private Long id;

    private String createBy;

    private Date createTime;

    private String description;

    private Long hour;

    private String operatorDuty;

    private String status;

    private Integer tag1;

    private Integer tag10;

    private Integer tag11;

    private Integer tag12;

    private Integer tag13;

    private Integer tag14;

    private Integer tag15;

    private Integer tag2;

    private Integer tag3;

    private Integer tag4;

    private Integer tag5;

    private Integer tag6;

    private Integer tag7;

    private Integer tag8;

    private Integer tag9;

    private String updateBy;

    private Date updateTime;

    private BigDecimal value1;

    private BigDecimal value10;

    private BigDecimal value11;

    private BigDecimal value12;

    private BigDecimal value13;

    private BigDecimal value14;

    private BigDecimal value15;

    private BigDecimal value2;

    private BigDecimal value3;

    private BigDecimal value4;

    private BigDecimal value5;

    private BigDecimal value6;

    private BigDecimal value7;

    private BigDecimal value8;

    private BigDecimal value9;

}