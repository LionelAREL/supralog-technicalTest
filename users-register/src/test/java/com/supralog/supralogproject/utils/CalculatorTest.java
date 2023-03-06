package com.supralog.supralogproject.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private LocalDate birthBefore;
    private LocalDate birthAfter;
    private final LocalDate referenceDate = LocalDate.of(2010,10,10);

    @Test
    void beforeBirthday(){
        this.birthBefore = this.referenceDate.plusYears(5).minusDays(1);
        assertEquals(4, Calculator.YearsBetween(this.referenceDate, this.birthBefore));         
        assertEquals(4, Calculator.YearsBetween(this.birthBefore, this.referenceDate));         
    }

    @Test
    void afterBirthday(){
        this.birthAfter = this.referenceDate.plusYears(5).plusDays(1);
        assertEquals(5, Calculator.YearsBetween(this.referenceDate, this.birthAfter));
        assertEquals(5, Calculator.YearsBetween(this.birthAfter, this.referenceDate));  
    }
    
}
