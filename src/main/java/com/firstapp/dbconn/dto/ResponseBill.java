package com.firstapp.dbconn.dto;

import java.util.List;

public class ResponseBill {
    List<Response> response;

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    public ResponseBill(List<Response> response, int totalBill) {
        this.response = response;
        this.totalBill = totalBill;
    }

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    int totalBill;
}
