package com.springmaster.springbegin.model;

import java.util.Date;

public class ExceptionResponse {

    Date exceptionDate;
    String message;

    public ExceptionResponse(Date exceptionDate, String message) {
        this.exceptionDate = exceptionDate;
        this.message = message;
    }

    public Date getExceptionDate() {
        return exceptionDate;
    }

    public void setExceptionDate(Date exceptionDate) {
        this.exceptionDate = exceptionDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
