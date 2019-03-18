package PhoneBook;


import java.util.*;

class PhoneBook {
    private Map<String, List<String>> phoneBookMap = new HashMap<>();
    void addPerson(String Name) {
        if (phoneBookMap.containsKey(Name)) throw new IllegalArgumentException();
        phoneBookMap.put(Name, new ArrayList<>());
    }
    void delPerson(String Name) {
        if (!phoneBookMap.containsKey(Name)) throw new IllegalArgumentException();
        phoneBookMap.remove(Name);
    }
    void addPhone(String Name, String Phone) {
        checkWrongSym(Phone);
        if (!phoneBookMap.containsKey(Name)) throw new IllegalArgumentException();
        List<String> temp = phoneBookMap.get(Name);
        temp.add(Phone);
        phoneBookMap.put(Name, temp);
    }
    void delPhone(String Name, String Phone) {
        checkWrongSym(Phone);
        if (!phoneBookMap.containsKey(Name)) throw new IllegalArgumentException();
        List<String> temp = phoneBookMap.get(Name);
        temp.remove(Phone);
        phoneBookMap.put(Name, temp);
    }
    List<String> searchPhones(String Name) {
        for (Map.Entry<String, List<String>> entry : phoneBookMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (key.equals(Name)) return value;
        }
        return null;
    }
    String searchPeople(String Phone) {
        checkWrongSym(Phone);
        for (Map.Entry<String, List<String>> entry : phoneBookMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value.contains(Phone)) return key;
        }
        return null;
    }
    private void checkWrongSym(String Phone) {
        if (!Phone.matches("([0-9+\\-*#])+")) throw new IllegalArgumentException();
    }
    Map<String, List<String>> phoneBook() {
        return phoneBookMap;
    }
}
