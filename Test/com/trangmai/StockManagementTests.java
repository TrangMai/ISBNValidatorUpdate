package com.trangmai;

import org.junit.Test;

import static org.junit.Assert.*;

public class StockManagementTests {

    @Test
    public void testCanGetCorrectLocatorCode(){
        ExternalISBNDataService testService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "Of Mice And Men", "J. Steinberg");
            }
        };


        StockManager stockManager = new StockManager();
        stockManager.setService(testService);
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }
}
