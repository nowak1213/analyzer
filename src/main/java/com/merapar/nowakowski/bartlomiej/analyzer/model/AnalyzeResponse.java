package com.merapar.nowakowski.bartlomiej.analyzer.model;

import java.time.LocalDateTime;

public class AnalyzeResponse {

    private LocalDateTime analyzeDate;
    private Details details;

    public AnalyzeResponse() {
        details = new Details();
    }

    public LocalDateTime getAnalyzeDate() {
        return analyzeDate;
    }

    public void setAnalyzeDate(LocalDateTime analyzeDate) {
        this.analyzeDate = analyzeDate;
    }

    public Details getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "AnalyzeResponse{" +
                "analyzeDate=" + analyzeDate +
                ", details=" + details +
                '}';
    }

}

