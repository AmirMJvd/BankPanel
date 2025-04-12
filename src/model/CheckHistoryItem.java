package model;

public class CheckHistoryItem {
    private String type;
    private String date;
    private String time;
    private String code;
    private String status;

    public String getType() { return type; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getCode() { return code; }
    public String getStatus() {return status;}


    public void setType(String type) {
        this.type = type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}