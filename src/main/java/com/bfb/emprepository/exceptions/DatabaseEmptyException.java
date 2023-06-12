package com.bfb.emprepository.exceptions;

public class DatabaseEmptyException extends RuntimeException{

    public DatabaseEmptyException(){
        super("The given database is empty");
    }
}
