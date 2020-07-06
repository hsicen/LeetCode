package com.hsicen.think_in_java;

import java.util.HashMap;
import java.util.Hashtable;

public class MyClass {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        Hashtable<String, String> hashtable = new Hashtable<>();

        hashMap.put(null, "Hello");
        hashMap.put(null, "World");

        hashtable.put("1", "Hello");

        System.out.println(hashMap.get(null));
        System.out.println(hashMap.get(null));
    }

}