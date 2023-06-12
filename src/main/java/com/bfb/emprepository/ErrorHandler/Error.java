package com.bfb.emprepository.ErrorHandler;

import jakarta.servlet.http.HttpServletRequest;

public class Error {
    private String url;
    private String message;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error(String url, String message){
        this.url=url;
        this.message=message;
    }

    public Error(HttpServletRequest request, String message){
        this.url=request.getRequestURI().toString();
        this.message=message;
    }

    public Error(HttpServletRequest request, Exception ex){
        this.url=request.getRequestURI().toString();
        this.message=ex.getMessage();
    }

}
