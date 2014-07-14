package net.flower.ixmsxms_admin.domain;

import java.util.Date;

public class Help extends BaseObject {
    public Long getHelpId() {
        return helpId;
    }

    public void setHelpId(Long helpId) {
        this.helpId = helpId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    private Long helpId;
    private String title;
    private String content;
    private String status;
    private Date regDatetime;
    private Date modDatetime;


}