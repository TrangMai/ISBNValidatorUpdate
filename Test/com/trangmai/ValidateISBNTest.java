package com.trangmai;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void checkValidTenISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0262035618");
        assertTrue("first value",result);
        boolean result2 = validator.checkISBN("1492032646");
        assertTrue("second value",result2);
    }

    @Test
    public void TenISBNNumbersEndingInAnXAreValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkInvalidTenISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0262035619");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");
    }


    @Test(expected = NumberFormatException.class)
    public void nonNumericTenISBNAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("helloworld");
    }

    @Test
    public void checkValidThirteenISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781492032649");
        assertTrue(result);
    }

    @Test
    public void checkInvalidThirteenISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781492032648");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericalISBN13IsNotAllowed(){
        ValidateISBN validate = new ValidateISBN();
        validate.checkISBN("helloworld123");

    }




}