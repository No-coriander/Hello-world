package com.yjc;

public class TestThread1 extends Thread{

    @Override
    public void run() {

            try {
                Test.lock1.lock();
                System.out.println("1开始了");
                Thread.sleep(10000);
                System.out.println("1结束了");
                Test.lock1.unlock();
            }catch (Exception e){
                e.printStackTrace();
            }

    }
}
