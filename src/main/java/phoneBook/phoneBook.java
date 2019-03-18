package phoneBook;


import java.util.*;

class PhoneBook {
    private Map<String, List<String>> phoneBookMap = new HashMap<>();
    void addPerson(String name) {
        if (phoneBookMap.containsKey(name)) throw new IllegalArgumentException();
        phoneBookMap.put(name, new ArrayList<>());
    }
    void delPerson(String name) {
        if (!phoneBookMap.containsKey(name)) throw new IllegalArgumentException();
        phoneBookMap.remove(name);
    }
    void addPhone(String name, String phone) {
        checkWrongSym(phone);
        if (!phoneBookMap.containsKey(name)) throw new IllegalArgumentException();
        List<String> temp = phoneBookMap.get(name);
        if (temp.contains(phone)) throw new IllegalArgumentException();
        temp.add(phone);
        phoneBookMap.put(name, temp);
    }
    void delPhone(String name, String phone) {
        checkWrongSym(phone);
        if (!phoneBookMap.containsKey(name)) throw new IllegalArgumentException();
        List<String> temp = phoneBookMap.get(name);
        if (!temp.contains(phone)) throw new IllegalArgumentException();
        temp.remove(phone);
        phoneBookMap.put(name, temp);
    }
    List<String> searchPhones(String name) {
        return phoneBookMap.getOrDefault(name, null);
    }
    String searchPeople(String phone) {
        checkWrongSym(phone);
        for (Map.Entry<String, List<String>> entry : phoneBookMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value.contains(phone)) return key;
        }
        return null;
    }
    private void checkWrongSym(String phone) {
        if (!phone.matches("([0-9+\\-*#])+")) throw new IllegalArgumentException();
    }
    Map<String, List<String>> getPhoneBook() {
        return phoneBookMap;
    }
}
