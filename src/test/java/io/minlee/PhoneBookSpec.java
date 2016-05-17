package io.minlee;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by minlee on 5/16/16.
 */
public class PhoneBookSpec {

    PhoneBook phoneBook;
    ArrayList<String> phoneNumbers;
    @Before
    public void initialize() {
        phoneBook = new PhoneBook();
        phoneNumbers = new ArrayList<>();
        phoneNumbers.add("856-357-7458");
        phoneNumbers.add("856-357-7459");
        phoneBook.addEntry("Min", phoneNumbers);
    }
    @Test
    public void reverseLookupTest(){
        String expectedName = "Min";
        String actualName = phoneBook.reverseLookup("856-357-7458");
        assertEquals(expectedName,actualName);
    }
    @Test
    public void lookupTest() {
        ArrayList<String> expectedNumbers = new ArrayList<>();
        expectedNumbers.add("856-357-7458");
        expectedNumbers.add("856-357-7459");
        ArrayList<String> actualNumbers = phoneBook.lookup("Min");
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    public void addEntryTest() {
        ArrayList<String> joeNumbers = new ArrayList<>();
        joeNumbers.add("856-357-1111");
        joeNumbers.add("856-357-2222");
        phoneBook.addEntry("Joe", joeNumbers);
        ArrayList<String> expectedNumbers = new ArrayList<>();
        expectedNumbers.add("856-357-1111");
        expectedNumbers.add("856-357-2222");
        ArrayList<String> actualNumbers = phoneBook.lookup("Joe");
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    public void removeRecordTest() {
        phoneBook.removeRecord("Min");
        ArrayList<String> actualNumber = phoneBook.lookup("Min");
        assertNull(actualNumber);
    }

    @Test
    public void listNumbersTest() {
        ArrayList<String> joeNumbers = new ArrayList<>();
        joeNumbers.add("856-357-1111");
        joeNumbers.add("856-357-2222");
        phoneBook.addEntry("Joe", joeNumbers);
        String expectedNumbers = "856-357-1111\n856-357-2222\n856-357-7458\n856-357-7459\n";
        String actualNumbers = phoneBook.listNumbers();
        assertEquals(expectedNumbers, actualNumbers);
    }

    @Test
    public void listEntriesTest() {
        ArrayList<String> joeNumbers = new ArrayList<>();
        joeNumbers.add("856-357-1111");
        joeNumbers.add("856-357-2222");
        phoneBook.addEntry("Joe", joeNumbers);
        String expectedEntries = "Joe\n856-357-1111\n856-357-2222\nMin\n856-357-7458\n856-357-7459\n";
        String actualEntries = phoneBook.listEntries();
        assertEquals(expectedEntries, actualEntries);
    }
    @Test
    public void removePhoneNumberTest() {
        phoneBook.removePhoneNumber("856-357-7458");
        String expectedNumbers = "856-357-7459\n";
        String actualNumbers = phoneBook.listNumbers();
        assertEquals(expectedNumbers,actualNumbers);
    }
}
