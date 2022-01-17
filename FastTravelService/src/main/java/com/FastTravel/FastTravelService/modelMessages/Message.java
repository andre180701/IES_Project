package com.FastTravel.FastTravelService.modelMessages;

public class Message {

    private String method;
    private String identifier;
    private String scut;
    private String date;
    private String time;

    public Message(String method, String identifier, String scut, String date, String time) {
        this.method = method;
        this.identifier = identifier;
        this.scut = scut;
        this.date = date;
        this.time = time;
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
    @Override
    public String toString() {
        return "Message [date=" + date + ", identifier=" + identifier + ", method=" + method + ", scut=" + scut
                + ", time=" + time + "]";
    }

    
}
