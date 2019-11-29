package com.example.demo;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestArrayList {
    static{
        int a = 10;
    }
    //static int a = 4;

    public static void listAllFileName(String fileUrl){
        File file = new File(fileUrl);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isDirectory()){
                listAllFileName(files[i].toString());
            }else{
                System.out.println(files[i]);
            }
        }
    }
    public static void main(String[] args) {
        HashMap<String,String> testMap = new HashMap<>();
        testMap.put("1","2");
        testMap.put("2","12");
        Set<Map.Entry<String,String>> a = testMap.entrySet();
        for(Map.Entry<String,String> as : a){
            as.getValue();
            as.getKey();
        }
        //Iterator<Map.Entry<String,String>> entryIterator = testMap.entrySet();
//        Iterator<Map.Entry<String, String>> entryIterator = testMap.entrySet().iterator();
//        for (Iterator<Map.Entry<String, String>> it = entryIterator; it.hasNext(); ) {
//            Iterator s = it.next();
//
//
//        }
        //String a = "Z:\\BaiduNetdiskDownload\\tmp";
        //listAllFileName(a);
        /*Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            int len=s.length();
            int []arr1=new int[10];

            for(int i=len-1;i>=0;i--){
                if(arr1[s.charAt(i)-48]==0){
                    System.out.print(s.charAt(i)-48);
                    arr1[s.charAt(i)-48]++;
                }
            }
        }*/

    }






    public static void main11(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] ss = s.split(" ");
        System.out.println(ss[ss.length-1].length());
    }
    public static int findChar(HashMap<String,Integer> map,Character c){

        HashMap<Character,Integer> map1 = new HashMap<>();
        String str = "";
        char[] strs = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            //if()
        }
        return 0;
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3};
        System.out.println(Arrays.toString(array));

        int a = 10;
        System.out.println(a >> 1);
        System.out.println(a << 1);

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"wuqihui");

        ExecutorService aa = Executors.newFixedThreadPool(5);
        System.out.println(0x7fffffff);
        System.out.println(2<<2);

        //ReentrantLock

    }
}
