package com.devise.checkup.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class InspectionRecord {
    private Long id;

    private String checkPerson;

    private Integer conclusion;

    private String createBy;

    private Date createTime;

    private String description;

    private Integer duty;

    private String problem1;

    private String problem2;

    private String problem3;

    private String problem4;

    private String problem5;

    private String problem6;

    private String serial;

    private String staff1;

    private String staff2;

    private String status;

    private Long templateId;

    private String updateBy;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}