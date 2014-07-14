package net.flower.ixmsxms_admin.domain;

import java.util.Date;

public class Admin extends BaseObject {
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getOldAdminId() {
        return oldAdminId;
    }

    public void setOldAdminId(String oldAdminId) {
        this.oldAdminId = oldAdminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(Date regDatetime) {
        this.regDatetime = regDatetime;
    }

    public Date getModDatetime() {
        return modDatetime;
    }

    public void setModDatetime(Date modDatetime) {
        this.modDatetime = modDatetime;
    }

    private String adminId;
    private String oldAdminId;
    private String name;
    private String password;
    private Date regDatetime;
    private Date modDatetime;


}