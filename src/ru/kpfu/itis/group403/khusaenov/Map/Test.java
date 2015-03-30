package ru.kpfu.itis.group403.khusaenov.Map;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new ArrayMap<>(10);
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        System.out.println("size: " + map.size());
        System.out.println("Is it empty: " + map.isEmpty());
        System.out.println("Is it contains key1: " + map.containsKey("key1"));
        System.out.println("Is it contains value4: " + map.containsValue("value4"));
        System.out.println("Value for key3: " + map.get("key3"));
    }
}
