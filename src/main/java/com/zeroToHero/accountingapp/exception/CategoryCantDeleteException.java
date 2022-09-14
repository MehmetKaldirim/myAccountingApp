package com.zeroToHero.accountingapp.exception;

public class CategoryCantDeleteException extends RuntimeException{

    public CategoryCantDeleteException(String s) {
        super(s);
    }
}