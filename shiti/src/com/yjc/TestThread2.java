package com.yjc;

public class TestThread2 extends Thread{


    @Override
    public void run() {

            try {
                Test.lock1.lock();
                System.out.println("2开始了");
                Test.lock1.unlock();
                this.yield();

                System.out.println("2结束了");
            }catch (Exception e){
                e.printStackTrace();
            }

    }
}
