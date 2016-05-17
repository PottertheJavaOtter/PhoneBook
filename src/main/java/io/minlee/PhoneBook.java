package io.minlee;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    public String listNumbers(){
        String numbers = "";
        for(String value : phoneEntries.values()){
            numbers +=value+"\n";
        }
        return numbers;
    }
    public String listEntries(){
        String entries = "";
        for(Map.Entry<String,String> entry : phoneEntries.entrySet()){
            entries += entry.getKey()+"\n" + entry.getValue()+"\n";
        }
        return entries;
    }

    public String reverseLookup(String number) {
        for(Map.Entry<String,String> entry : phoneEntries.entrySet()){
            if(entry.getValue() == number){
                return entry.getKey();
            }
        }
        return null;
    }
}
