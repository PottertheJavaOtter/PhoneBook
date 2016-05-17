package io.minlee;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by minlee on 5/16/16.
 */
public class PhoneBookSpec {

    PhoneBook phoneBook;

    @Before
    public void initialize() {
        phoneBook = new PhoneBook();
        phoneBook.addEntry("Min", "856-357-7458");
    }
    @Test
    public void reverseLookupTest(){
        String expectedName = "Min";
        String actualName = phoneBook.reverseLookup("856-357-7458");
        assertEquals(expectedName,actualName);
    }
    @Test
    public void lookupTest() {
        String expectedNumber = "856-357-7458";
        String actualNumber = phoneBook.lookup("Min");
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void addEntryTest() {
        phoneBook.addEntry("Joe", "856-357-7412");
        String expectedNumber = "856-357-7412";
        String actualNumber = phoneBook.lookup("Joe");
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    public void removeEntryTest() {
        phoneBook.removeEntry("Min");
        String actualNumber = phoneBook.lookup("Min");
        assertNull(actualNumber);
    }

    @Test
    public void listNumbersTest() {
        phoneBook.addEntry("Joe", "856-357-7412");
        String expectedNumbers = "856-357-7412\n856-357-7458\n";
        String actualNumbers = phoneBook.listNumbers();
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    public void listEntriesTest() {
        phoneBook.addEntry("Joe", "856-357-7412");
        String expectedNumbers = "Joe\n856-357-7412\nMin\n856-357-7458\n";
        String actualNumbers = phoneBook.listEntries();
        assertEquals(expectedNumbers, actualNumbers);
    }

}
