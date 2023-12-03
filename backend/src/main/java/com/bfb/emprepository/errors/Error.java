package com.bfb.emprepository.errors;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private String type;
    private String title;
    private String status;
    private String detail;

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

    public Error(HttpServletRequest request, String message, String status,String detail){
        this.type=request.getRequestURI().toString();
        this.title=message;
    }

    public Error(HttpServletRequest request, Exception ex){
        this.type=request.getRequestURI().toString();
        this.title=ex.getMessage();
    }

}
