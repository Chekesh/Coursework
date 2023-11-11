package com.example.coursework;

public class HiSug {
    private int ID;
    private int ID_User;
    private int ID_Suggestion;
    private String Status;
    private String Process;
    private String Cost;
    private String Date;
    private String Coments;
    HiSug(int ID,int ID_User, int ID_Suggestion, String Status,
          String Process, String Cost, String Date, String Coments){
        this.ID=ID;
        this.ID_User = ID_User;
        this.ID_Suggestion = ID_Suggestion;
        this.Status = Status;
        this.Process = Process;
        this.Cost = Cost;
        this.Date = Date;
        this.Coments = Coments;
    }

    public int getID() {
        return ID;
    }

    public int getID_User() {
        return ID_User;
    }

    public int getID_Suggestion() {
        return ID_Suggestion;
    }

    public String getStatus() {
        return Status;
    }

    public String getProcess() {
        return Process;
    }

    public String getCost() {
        return Cost;
    }

    public String getDate() {
        return Date;
    }

    public String getComents() {
        return Coments;
    }
}
