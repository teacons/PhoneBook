package phoneBook;


import java.util.*;

class phoneBook {
    static Map<String, List<String>> phoneBookMap = new HashMap<>();
    static void addPeople(String Name) {
        phoneBookMap.put(Name, new ArrayList<>());
    }
    static void delPeople(String Name) {
        phoneBookMap.remove(Name);
    }
    static void addPhone(String Name, String Phone) {
        checkWrongSym(Phone);
        List<String> temp = phoneBookMap.get(Name);
        temp.add(Phone);
        phoneBookMap.put(Name, temp);
    }
    static void delPhone(String Name, String Phone) {
        checkWrongSym(Phone);
        List<String> temp = phoneBookMap.get(Name);
        temp.remove(Phone);
        phoneBookMap.put(Name, temp);
    }
    static List<String> searchPhones(String Name) {
        for (Map.Entry<String, List<String>> entry : phoneBookMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (key.equals(Name)) return value;
        }
        return null;
    }
    static String searchPeople(String Phone) {
        checkWrongSym(Phone);
        for (Map.Entry<String, List<String>> entry : phoneBookMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value.contains(Phone)) return key;
        }
        return null;
    }
    private static void checkWrongSym(String Phone) {
        String valStr = "0123456789-+#*";
        for (int i = 0; i < Phone.length(); i++){
            char c = Phone.charAt(i);
            if (valStr.indexOf(c) == -1) throw new IllegalArgumentException();
        }
    }
}
