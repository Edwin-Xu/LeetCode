package company.huawei.interview;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Edwin Xu on 10/15/2020 10:33 PM.
 *
 * 线程1：输出1
 * 线程2：输出2
 * 轮流输出
 *
 *
 * 使用Lock试一下
 * 不太好用
 * 需要设计逻辑
 */

public class ThreadLoopTast {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        AtomicInteger flag = new AtomicInteger(0);

        Thread t1 = new Thread(()->{
            while (true){
                if (flag.get()==0){
                    lock.lock();
                }
                System.out.println(0);
                flag.set(1);
                lock.unlock();
            }
        });
        Thread t2 = new Thread(()->{
            while (true){
                if (flag.get()==1){
                    lock.lock();
                }
                System.out.println(1);
                flag.set(1);
                lock.unlock();
            }
        });

        t1.start();
        t2.start();

    }
}
