package com.devise.checkup.domain;

import java.util.Date;

public class Attendance {
    private Long id;

    private String createBy;

    private Date createTime;

    private String delFlag;

    private String duration;

    private String enterImage;

    private String enterRecording;

    private Date entryTime;

    private Date inspectionTime;

    private String outImage;

    private String outRecording;

    private Date outTime;

    private Long process;

    private String realname;

    private String status;

    private String updateBy;

    private Date updateTime;

    private String userId;

    private String username;

    private String workNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getEnterImage() {
        return enterImage;
    }

    public void setEnterImage(String enterImage) {
        this.enterImage = enterImage == null ? null : enterImage.trim();
    }

    public String getEnterRecording() {
        return enterRecording;
    }

    public void setEnterRecording(String enterRecording) {
        this.enterRecording = enterRecording == null ? null : enterRecording.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(Date inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public String getOutImage() {
        return outImage;
    }

    public void setOutImage(String outImage) {
        this.outImage = outImage == null ? null : outImage.trim();
    }

    public String getOutRecording() {
        return outRecording;
    }

    public void setOutRecording(String outRecording) {
        this.outRecording = outRecording == null ? null : outRecording.trim();
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Long getProcess() {
        return process;
    }

    public void setProcess(Long process) {
        this.process = process;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }
}