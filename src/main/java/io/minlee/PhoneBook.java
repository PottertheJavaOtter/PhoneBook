package io.minlee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by minlee on 5/16/16.
 */
public class PhoneBook {

    private Map<String,ArrayList<String>> phoneEntries;

    public PhoneBook(){
        phoneEntries = new HashMap<String,ArrayList<String>>();
    }

    public void addEntry(String name, ArrayList<String> phoneNumbers) {
        phoneEntries.put(name,phoneNumbers);
    }

    public ArrayList<String> lookup(String name) {
        return phoneEntries.get(name);
    }

    public void removeRecord(String name) {
        phoneEntries.remove(name);
    }
    public void removePhoneNumber(String number) {
        for(Map.Entry<String,ArrayList<String>> entry : phoneEntries.entrySet()){
            for(String phoneNumber : entry.getValue()){
                if(phoneNumber == number){
                    entry.getValue().remove(phoneNumber);
                }
            }
        }
    }
    public String listNumbers(){
        String numbers = "";
        for(Map.Entry<String,ArrayList<String>> entry : phoneEntries.entrySet()){
            for(String phoneNumber : entry.getValue()){
                numbers += phoneNumber+"\n";
            }
        }
        return numbers;
    }
    public String listEntries(){
        String entries = "";
        for(Map.Entry<String,ArrayList<String>> entry : phoneEntries.entrySet()){
            entries += entry.getKey()+"\n";
            for(String phoneNumber : entry.getValue()){
                entries += phoneNumber+"\n";
            }
        }
        return entries;
    }

    public String reverseLookup(String number) {
        for(Map.Entry<String,ArrayList<String>> entry : phoneEntries.entrySet()){
            for(String phoneNumber : entry.getValue()){
                if(phoneNumber == number){
                    return entry.getKey();
                }
            }
        }
        return null;
    }
}
