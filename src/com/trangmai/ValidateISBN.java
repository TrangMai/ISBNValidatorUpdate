package com.trangmai;

public class ValidateISBN {

    public static final int longISBNLength = 13;
    public static final int shortISBN_length = 10;
    public static final int shortISBNParameter = 11;
    public static final int longISBNParameter = 10;

    public boolean checkISBN(String isbn) {
        if (isbn.length() == longISBNLength) {
            return validateLongISBN(isbn);
        } else if (isbn.length() == shortISBN_length) {
            return validateShortISBN(isbn);
        } else {
            throw new NumberFormatException("ISBN numbers should include 10 or 13 digits");
        }
    }

    private static boolean validateShortISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < shortISBN_length; i++) {
            if (i == 9 && isbn.charAt(i) == 'X') {
                total += 10;
            } else {
                if (!Character.isDigit(isbn.charAt(i)))
                    throw new NumberFormatException("ISBN should be numbers only");
                total += Character.getNumericValue(isbn.charAt(i)) * (shortISBN_length - i);
            }
        }
        return (total % shortISBNParameter == 0);
    }

    private static boolean validateLongISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < longISBNLength; i++) {
            if (!Character.isDigit(isbn.charAt(i)))
                throw new NumberFormatException("ISBN should be numbers only");
            if (i % 2 == 0){
                total += Character.getNumericValue(isbn.charAt(i));
            }
            else {
                total += Character.getNumericValue(isbn.charAt(i))*3;
            }
        }
        return (total % longISBNParameter == 0);
    }
}
