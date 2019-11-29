package com.it.study;

import com.it.study.demain.Account;
import com.it.study.mapper.AccountAmpper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class AccountTest {

    @Resource
    private AccountAmpper accountAmpper;

    @Test
    public void accountTest(){
        List<Account> accounts = accountAmpper.finalAll();
        for (Account account : accounts) {
            System.out.println("-------------------------");
            System.out.println(account);
            System.out.println(account.getStudent());
        }
    }

    @Test
    public void test(){
        /*Map map = new HashMap();
        map.put("s","123");
        System.out.println(map);*/

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);

        int[] in = new int[arrayList.size()];
        int e = 0;
        for (int i : arrayList) {
            System.out.println(in[e++] = i);
        }
        System.out.println(Arrays.toString(in));

    }

    @Test
    public void testArray(){
        int[] nums1 = new int[]{1,9,3,1};
        int[] nums2 = new int[]{1,2,4,1};
        System.out.println(Arrays.toString(intersect2(nums2,nums1)));
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums1.length;i++) {
            Integer val=map.get(nums1[i]);
            map.put(nums1[i], (val==null)?1:++val);
        }
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0,val;i<nums2.length;i++) {
            if(map.containsKey(nums2[i]) && (val=map.get(nums2[i]))>0) {
                al.add(nums2[i]);
                map.put(nums2[i], --val);
            }
        }

        int[] in = new int[al.size()];
        int e=0;
        for(int i:al)
            in[e++] = i;
        return in;

    }

    @Test
    public void Tst2() {
        String s = new String("a");
        ArrayList arryList = new ArrayList<>();

        Vector vector = new Vector();

        LinkedList linkedList = new LinkedList();

        HashSet hashSet = new HashSet();
        hashSet.add("wuqihui");
        hashSet.add("aaa");
        hashSet.add("yangxiulan");
        System.out.println("-------------:"+hashSet);

        TreeSet treeSet = new TreeSet();

        //Queue queue
        HashMap hashMap = new HashMap();

        TreeMap treeMap = new TreeMap();

        treeMap.put("wuqihui","asd");
        treeMap.put("awuqihui","asd");
        treeMap.put("bawuqihui","asd");
        System.out.println("******************:" + treeMap);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();




        Hashtable<String,String> table = new Hashtable<>();
        table.put("123","456");
        System.out.println(table);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        System.out.println(2<<3);

        //Set s = new HashSet();
        //s.add("wuqihui");
        //System.out.println(s);

        ArrayList<Integer> al= new ArrayList<Integer>();
        // boolean[] bl = new Boolean[1];
    }
}
