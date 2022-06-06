package com.zeroToHero.accountingapp.enums;

public enum InvoiceType {

    PURCHASE("Purchase"), SALE("Sales");

    private final String value;

    InvoiceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
