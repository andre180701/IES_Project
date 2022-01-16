package com.FastTravel.FastTravelService.modelMessages;

public class Message {

    private String method;
    private String identifier;
    private String scut;
    private String date;
    private String time;

    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    public String getScut() {
        return scut;
    }
    public void setScut(String scut) {
        this.scut = scut;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

}
