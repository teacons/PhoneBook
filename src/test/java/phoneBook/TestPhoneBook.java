package phoneBook;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestPhoneBook {
    @Test
    public void addPersonTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        testMap.put("Яблоко", new ArrayList<>());
        PhoneBook test = new PhoneBook();
        test.addPerson("Яблоко");
        assertEquals(testMap, test.getPhoneBook());
        assertThrows(IllegalArgumentException.class, () -> test.addPerson("Яблоко"));
    }
    @Test
    public void delPersonTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        testMap.put("Апельсин", new ArrayList<>());
        PhoneBook test = new PhoneBook();
        test.addPerson("Яблоко");
        test.addPerson("Апельсин");
        test.delPerson("Яблоко");
        assertEquals(testMap, test.getPhoneBook());
        assertThrows(IllegalArgumentException.class, () -> test.delPerson("Яблоко"));
    }
    @Test
    public void addPhoneTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        List<String> testList = new ArrayList<>();
        testList.add("123456");
        testMap.put("Апельсин", testList);
        testMap.put("Яблоко", new ArrayList<>());
        PhoneBook test = new PhoneBook();
        test.addPerson("Яблоко");
        test.addPerson("Апельсин");
        test.addPhone("Апельсин", "123456");
        assertEquals(testMap, test.getPhoneBook());
        assertThrows(IllegalArgumentException.class, () -> test.addPhone("Апельсин", "dsfgbs"));
        assertThrows(IllegalArgumentException.class, () -> test.addPhone("Груша", "123456"));
        assertThrows(IllegalArgumentException.class, () -> test.addPhone("Апельсин", "123456"));
    }
    @Test
    public void delPhoneTest() {
        Map<String, List<String>> testMap = new HashMap<>();
        List<String> testList = new ArrayList<>();
        testList.add("123456");
        testMap.put("Апельсин", new ArrayList<>());
        testMap.put("Яблоко", new ArrayList<>());
        PhoneBook test = new PhoneBook();
        test.addPerson("Яблоко");
        test.addPerson("Апельсин");
        test.addPhone("Апельсин", "123456");
        test.delPhone("Апельсин", "123456");
        assertEquals(testMap, test.getPhoneBook());
        assertThrows(IllegalArgumentException.class, () -> test.delPhone("Апельсин", "dsfgbs"));
        assertThrows(IllegalArgumentException.class, () -> test.delPhone("Апельсин", "1"));
        assertThrows(IllegalArgumentException.class, () -> test.delPhone("Груша", "1"));
    }
    @Test
    public void searchPhonesTest() {
        List<String> testList = new ArrayList<>();
        testList.add("123456");
        List<String> test2List = new ArrayList<>();
        test2List.add("123");
        test2List.add("123456789");
        PhoneBook test = new PhoneBook();
        test.addPerson("Яблоко");
        test.addPerson("Апельсин");
        test.addPhone("Апельсин", "123456");
        test.addPerson("Мандарин");
        test.addPhone("Мандарин", "123");
        test.addPhone("Мандарин", "123456789");
        assertEquals(testList, test.searchPhones("Апельсин"));
        assertEquals(test2List, test.searchPhones("Мандарин"));
        assertNull(test.searchPhones("Груша"));
        assertEquals(new ArrayList<String>(), test.searchPhones("Яблоко"));
    }
    @Test
    public void searchPeopleTest() {
        List<String> testList = new ArrayList<>();
        testList.add("123456");
        List<String> test2List = new ArrayList<>();
        test2List.add("123456789");
        test2List.add("123");
        PhoneBook test = new PhoneBook();
        test.addPerson("Яблоко");
        test.addPhone("Яблоко", "123456789");
        test.addPhone("Яблоко", "123");
        test.addPerson("Апельсин");
        test.addPhone("Апельсин", "123456");
        assertEquals("Апельсин", test.searchPeople("123456"));
        assertEquals("Яблоко", test.searchPeople("123456789"));
        assertEquals("Яблоко", test.searchPeople("123"));
        assertNull(test.searchPeople("762354"));
        assertThrows(IllegalArgumentException.class, () -> test.searchPeople("dsfgbs"));
    }
}
