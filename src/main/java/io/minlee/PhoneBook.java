package io.minlee;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by minlee on 5/16/16.
 */
public class PhoneBook {

    private Map<String,String> phoneEntries;

    public PhoneBook(){
        phoneEntries = new HashMap<String, String>();
    }

    public void addEntry(String name, String phoneNumber) {
        phoneEntries.put(name,phoneNumber);
    }

    public String lookup(String name) {
        return phoneEntries.get(name);
    }

    public void removeEntry(String name) {
        phoneEntries.remove(name);
    }
}
