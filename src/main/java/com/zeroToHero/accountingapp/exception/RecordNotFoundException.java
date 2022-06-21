package com.zeroToHero.accountingapp.exception;


public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String s) {
        super(s);
    }
}