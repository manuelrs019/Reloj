package com.example.zeppe.relog;

public class Header {
    private String headerCode;
    private String headerDate;
    private String ampm;

    public Header(String headerCode,  String ampm, String headerDate) {
        this.headerCode = headerCode;
        this.headerDate = headerDate;
        this.ampm = ampm;
    }

    public String getHeaderCode() {
        return headerCode;
    }

    public void setHeaderCode(String headerCode) {
        this.headerCode = headerCode;
    }

    public String getHeaderDate() {
        return headerDate;
    }

    public void setHeaderDate(String headerDate) {
        this.headerDate = headerDate;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }
}
