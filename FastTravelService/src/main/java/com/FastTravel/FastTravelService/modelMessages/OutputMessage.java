package com.FastTravel.FastTravelService.modelMessages;

public class OutputMessage {

    private String method;
    private String identifier;
    private String scut;
    private String date;
    private String time;
    private String timeMessage;

    public OutputMessage(String method, String identifier, String scut, String date, String time, String timeMessage) {
        this.method = method;
        this.identifier = identifier;
        this.scut = scut;
        this.date = date;
        this.time = time;
        this.timeMessage = timeMessage;
    }
    
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
    public String getTimeMessage() {
        return timeMessage;
    }
    public void setTimeMessage(String timeMessage) {
        this.timeMessage = timeMessage;
    }

}
