package com.skyPro.HomeWorkJC25;

import org.apache.commons.lang3.StringUtils;

public class EmployeeValidator {
    public static boolean validate (String name, String lastName){
        return StringUtils.isAlpha(name) && StringUtils.isAlpha(lastName);
    }
}
