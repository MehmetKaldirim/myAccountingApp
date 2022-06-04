package com.zeroToHero.accountingapp.enums;

import org.springframework.stereotype.Component;


public enum CompanyStatus {

    ENABLED("Enabled",1l),
    DISABLED("Disabled",2L);

    private final String value;
    private final Long  id;

    CompanyStatus(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }
}
