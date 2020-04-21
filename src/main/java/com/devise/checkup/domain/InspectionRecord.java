package com.devise.checkup.domain;

import java.util.Date;

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

    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson == null ? null : checkPerson.trim();
    }

    public Integer getConclusion() {
        return conclusion;
    }

    public void setConclusion(Integer conclusion) {
        this.conclusion = conclusion;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getDuty() {
        return duty;
    }

    public void setDuty(Integer duty) {
        this.duty = duty;
    }

    public String getProblem1() {
        return problem1;
    }

    public void setProblem1(String problem1) {
        this.problem1 = problem1 == null ? null : problem1.trim();
    }

    public String getProblem2() {
        return problem2;
    }

    public void setProblem2(String problem2) {
        this.problem2 = problem2 == null ? null : problem2.trim();
    }

    public String getProblem3() {
        return problem3;
    }

    public void setProblem3(String problem3) {
        this.problem3 = problem3 == null ? null : problem3.trim();
    }

    public String getProblem4() {
        return problem4;
    }

    public void setProblem4(String problem4) {
        this.problem4 = problem4 == null ? null : problem4.trim();
    }

    public String getProblem5() {
        return problem5;
    }

    public void setProblem5(String problem5) {
        this.problem5 = problem5 == null ? null : problem5.trim();
    }

    public String getProblem6() {
        return problem6;
    }

    public void setProblem6(String problem6) {
        this.problem6 = problem6 == null ? null : problem6.trim();
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getStaff1() {
        return staff1;
    }

    public void setStaff1(String staff1) {
        this.staff1 = staff1 == null ? null : staff1.trim();
    }

    public String getStaff2() {
        return staff2;
    }

    public void setStaff2(String staff2) {
        this.staff2 = staff2 == null ? null : staff2.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "InspectionRecord{" +
                "id=" + id +
                ", checkPerson='" + checkPerson + '\'' +
                ", conclusion=" + conclusion +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", description='" + description + '\'' +
                ", duty=" + duty +
                ", problem1='" + problem1 + '\'' +
                ", problem2='" + problem2 + '\'' +
                ", problem3='" + problem3 + '\'' +
                ", problem4='" + problem4 + '\'' +
                ", problem5='" + problem5 + '\'' +
                ", problem6='" + problem6 + '\'' +
                ", serial='" + serial + '\'' +
                ", staff1='" + staff1 + '\'' +
                ", staff2='" + staff2 + '\'' +
                ", status='" + status + '\'' +
                ", templateId=" + templateId +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}