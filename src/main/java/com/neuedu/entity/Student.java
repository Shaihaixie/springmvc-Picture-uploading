package com.neuedu.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import java.util.Date;

public class Student {

    private String stunum;
    private String touxiang;
    @NotBlank(message = "不能为空")
    private String stuname;
//    private String stusex;
  //  private Date brith;
    private String banji;

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public String getTouxiang() {
        return touxiang;
    }

    public void setTouxiang(String touxiang) {
        this.touxiang = touxiang;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stunum='" + stunum + '\'' +
                ", touxiang='" + touxiang + '\'' +
                ", stuname='" + stuname + '\'' +
                ", banji='" + banji + '\'' +
                '}';
    }
}
