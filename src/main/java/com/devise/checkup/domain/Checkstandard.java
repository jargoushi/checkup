package com.devise.checkup.domain;

public class Checkstandard {
    private Integer id;

    private String val1;

    private String val2;

    private String val3;

    private String val4;

    private String val5;

    private String val6;

    private String val7;

    private String val8;

    private String val9;

    private String val10;

    private String val11;

    private String val12;

    private String val13;

    private String val14;

    private String val15;

    private String val16;

    private String serial;

    private String templateid;

    public Checkstandard(String serial, String templateid, String val1, String val2, String val3, String val4, String val5, String val6, String val7, String val8, String val9, String val10, String val11, String val12, String val13, String val14, String val15, String val16) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
        this.val4 = val4;
        this.val5 = val5;
        this.val6 = val6;
        this.val7 = val7;
        this.val8 = val8;
        this.val9 = val9;
        this.val10 = val10;
        this.val11 = val11;
        this.val12 = val12;
        this.val13 = val13;
        this.val14 = val14;
        this.val15 = val15;
        this.val16 = val16;
        this.serial = serial;
        this.templateid = templateid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1 == null ? null : val1.trim();
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2 == null ? null : val2.trim();
    }

    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3 == null ? null : val3.trim();
    }

    public String getVal4() {
        return val4;
    }

    public void setVal4(String val4) {
        this.val4 = val4 == null ? null : val4.trim();
    }

    public String getVal5() {
        return val5;
    }

    public void setVal5(String val5) {
        this.val5 = val5 == null ? null : val5.trim();
    }

    public String getVal6() {
        return val6;
    }

    public void setVal6(String val6) {
        this.val6 = val6 == null ? null : val6.trim();
    }

    public String getVal7() {
        return val7;
    }

    public void setVal7(String val7) {
        this.val7 = val7 == null ? null : val7.trim();
    }

    public String getVal8() {
        return val8;
    }

    public void setVal8(String val8) {
        this.val8 = val8 == null ? null : val8.trim();
    }

    public String getVal9() {
        return val9;
    }

    public void setVal9(String val9) {
        this.val9 = val9 == null ? null : val9.trim();
    }

    public String getVal10() {
        return val10;
    }

    public void setVal10(String val10) {
        this.val10 = val10 == null ? null : val10.trim();
    }

    public String getVal11() {
        return val11;
    }

    public void setVal11(String val11) {
        this.val11 = val11 == null ? null : val11.trim();
    }

    public String getVal12() {
        return val12;
    }

    public void setVal12(String val12) {
        this.val12 = val12 == null ? null : val12.trim();
    }

    public String getVal13() {
        return val13;
    }

    public void setVal13(String val13) {
        this.val13 = val13 == null ? null : val13.trim();
    }

    public String getVal14() {
        return val14;
    }

    public void setVal14(String val14) {
        this.val14 = val14 == null ? null : val14.trim();
    }

    public String getVal15() {
        return val15;
    }

    public void setVal15(String val15) {
        this.val15 = val15 == null ? null : val15.trim();
    }

    public String getVal16() {
        return val16;
    }

    public void setVal16(String val16) {
        this.val16 = val16 == null ? null : val16.trim();
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid == null ? null : templateid.trim();
    }
}