package com.example.coursework;

public class Suggestion {
    int idSuggestion;
    String Title;
    String Approximate_Сost;
    String Approximate_Time_Performance;
    Suggestion(int idSuggestion,String Title, String Approximate_Сost,
               String Approximate_Time_Performance){
        this.idSuggestion=idSuggestion;
        this.Title=Title;
        this.Approximate_Сost=Approximate_Сost;
        this.Approximate_Time_Performance=Approximate_Time_Performance;
    }

    Suggestion() {}

    public int getIdSuggestion() {
        return idSuggestion;
    }

    public String getTitle() {
        return Title;
    }

    public String getApproximate_Сost() {
        return Approximate_Сost;
    }

    public String getApproximate_Time_Performance() {
        return Approximate_Time_Performance;
    }
}
