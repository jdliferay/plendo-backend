package com.maintacloud.domain.util;

/**
 * Created by issam on 17/07/2016.
 */
public enum ComptaDomainPatterns {

    PATTERN_SPLIT_STRING_COLUMN("-");

    private String pattern;


    ComptaDomainPatterns(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
