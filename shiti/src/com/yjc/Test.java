package com.yjc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static final Lock lock1 = new ReentrantLock();
    public static final Lock lock2 = new ReentrantLock();
    public static final Condition condition1 = lock1.newCondition();
    public static final Condition condition2 = lock1.newCondition();

    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb = new StringBuilder("123");

        Thread t1 = new Thread(() -> {
            try {
                lock1.lock();

                        System.out.println(Thread.currentThread().getName() + "锁住i");
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName() + "释放锁i");
                        condition1.await();
                        System.out.println("我回来了");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                lock1.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                lock1.lock();
                for (int i = 0; i < 10; i++) {
                    if(i==0){
                        System.out.println(Thread.currentThread().getName() + "锁住j");
                        Thread.sleep(1000);
                        condition1.signalAll();
                    }else {
                        System.out.println(Thread.currentThread().getName() + "其他操作");
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock1.unlock();
            }
        });
        //t1.start();
        //t2.start();
        TestThread1 tt1 = new TestThread1();
        TestThread2 tt2 = new TestThread2();
        //tt2.start();
        //tt1.start();
        //tt1.join();
        System.out.println("haha");
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(null);
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add(null);
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(null);
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);
        TreeSet<Object> treeSet = new TreeSet<>();
        //treeSet.add(null);
        HashMap<Object,Object> hashMap = new HashMap<>();
        hashMap.put(null,null);
        LinkedHashMap<Object,Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(null,null);
        TreeMap<Object,Object> treeMap = new TreeMap<>();
        treeMap.put(null,null);
        long b = 012;
    }


}
