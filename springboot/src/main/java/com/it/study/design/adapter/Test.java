package com.it.study.design.adapter;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println(set);

        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("1",4);
        linkedHashMap.put("8",8);
        linkedHashMap.put("5",1);
        linkedHashMap.put("9",9);
        final int max = 0;
        linkedHashMap.forEach((key,value) -> {
            System.out.println(key+ ":" + value);
        });


        for (Map.Entry<String,Integer> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

       /* Iterator<Map.Entry<String,String>> entrys= linkedHashMap.entrySet().iterator();
        while (entrys.hasNext()){
            Map.Entry<String,String> entry = entrys.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("***********************************");
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("a","bbb");
        treeMap.put("d","aaa");
        treeMap.put("b","ccc");
        treeMap.put("c","ddd");

        for (Map.Entry<String,String> map : treeMap.entrySet()){
            System.out.println(map.getKey() + ": " + map.getValue());
        }*/
        //Iterator<Map.Entry<String,String>> treeEntrys= treeMap.entrySet().iterator();

        //Iterator<Map.Entry<String, String>> entry= linkedHashMap.entrySet().iterator();
        //HashMap


        /*Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter();
        phone.setAdapter(adapter);
        phone.charge();*/
    }

    @Transactional(isolation = Isolation.SERIALIZABLE ,propagation = Propagation.REQUIRED)
    public void Test(){

    }

}
