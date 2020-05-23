package org.linqw.vhr.model;

import java.util.Date;

public class ChatMsg {
    private String from;
    private String to;
    private String content;
    private Date date;
    private String formNickname;

    public String getFormNickname() {
        return formNickname;
    }

    public void setFormNickname(String formNickname) {
        this.formNickname = formNickname;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
