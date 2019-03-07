package phoneBook;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

public class testPhoneBook {
    @Test
    public void addPeopleTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        testMap.put("Яблоко", new ArrayList<>());
        phoneBook.addPeople("Яблоко");
        assertEquals(testMap, phoneBook.phoneBookMap);
    }
    @Test
    public void delPeopleTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        testMap.put("Апельсин", new ArrayList<>());
        phoneBook.phoneBookMap.put("Яблоко", new ArrayList<>());
        phoneBook.phoneBookMap.put("Апельсин", new ArrayList<>());
        phoneBook.delPeople("Яблоко");
        assertEquals(testMap, phoneBook.phoneBookMap);
        phoneBook.phoneBookMap.clear();
    }
    @Test
    public void addPhoneTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        List<String> testList = new ArrayList<>();
        testList.add("123456");
        testMap.put("Апельсин", testList);
        testMap.put("Яблоко", new ArrayList<>());
        phoneBook.phoneBookMap.put("Яблоко", new ArrayList<>());
        phoneBook.phoneBookMap.put("Апельсин", new ArrayList<>());
        phoneBook.addPhone("Апельсин", "123456");
        assertEquals(testMap, phoneBook.phoneBookMap);
        assertThrows(IllegalArgumentException.class, () -> phoneBook.addPhone("Апельсин", "dsfgbs"));
        phoneBook.phoneBookMap.clear();
    }
    @Test
    public void delPhoneTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        List<String> testList = new ArrayList<>();
        testList.add("123456");
        testMap.put("Апельсин", new ArrayList<>());
        testMap.put("Яблоко", new ArrayList<>());
        phoneBook.phoneBookMap.put("Яблоко", new ArrayList<>());
        phoneBook.phoneBookMap.put("Апельсин", testList);
        phoneBook.delPhone("Апельсин", "123456");
        assertEquals(testMap, phoneBook.phoneBookMap);
        assertThrows(IllegalArgumentException.class, () -> phoneBook.delPhone("Апельсин", "dsfgbs"));
        phoneBook.phoneBookMap.clear();
    }
    @Test
    public void searchPhonesTest() {
        List<String> testList = new ArrayList<>();
        testList.add("123456");
        phoneBook.phoneBookMap.put("Яблоко", new ArrayList<>());
        phoneBook.phoneBookMap.put("Апельсин", testList);
        assertEquals(testList, phoneBook.searchPhones("Апельсин"));
        assertNull(phoneBook.searchPhones("Груша"));
        assertEquals(new ArrayList<String>(), phoneBook.searchPhones("Яблоко"));
        assertThrows(IllegalArgumentException.class, () -> phoneBook.searchPeople("dsfgbs"));
        phoneBook.phoneBookMap.clear();
    }
    @Test
    public void searchPeopleTest() {
        List<String> testList = new ArrayList<>();
        testList.add("123456");
        List<String> test2List = new ArrayList<>();
        test2List.add("123456789");
        test2List.add("123");
        phoneBook.phoneBookMap.put("Яблоко", test2List);
        phoneBook.phoneBookMap.put("Апельсин", testList);
        assertEquals("Апельсин", phoneBook.searchPeople("123456"));
        assertEquals("Яблоко", phoneBook.searchPeople("123456789"));
        assertEquals("Яблоко", phoneBook.searchPeople("123"));
        assertNull(phoneBook.searchPeople("762354"));
        phoneBook.phoneBookMap.clear();
    }
}
