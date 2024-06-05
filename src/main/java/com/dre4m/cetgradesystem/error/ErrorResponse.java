package com.dre4m.cetgradesystem.error;

import lombok.Data;

@Data
public class ErrorResponse {
    private String msg;
    private int code;
    private String jsonData;

    public ErrorResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ErrorResponse(int code, String msg, String jsonData) {
        this.code = code;
        this.msg = msg;
        this.jsonData = jsonData;
    }
}
