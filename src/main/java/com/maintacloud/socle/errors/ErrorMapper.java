package com.maintacloud.socle.errors;

/**
 * Created by Issam on 28/08/2015.
 */
public class ErrorMapper {

    private String code;

    private String message;

    public ErrorMapper() { }

    public ErrorMapper(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }


}
