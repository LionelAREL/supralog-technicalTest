package com.supralog.supralogproject.utils;

import java.time.LocalDate;
import java.time.Period;

public class Calculator {
    
    /** 
     * @param date1
     * @param date2
     * @return int, years between the 2 dates
     */
    public static int YearsBetween(LocalDate date1,LocalDate date2){
        int period = Period.between(date1,date2).getYears();
        return Math.abs(period);
    }
}
