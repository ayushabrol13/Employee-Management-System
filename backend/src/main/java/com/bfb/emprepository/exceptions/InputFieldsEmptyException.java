package com.bfb.emprepository.exceptions;

public class InputFieldsEmptyException extends RuntimeException{
    public InputFieldsEmptyException() {
        super("The given field has some missing values");
    }
}
