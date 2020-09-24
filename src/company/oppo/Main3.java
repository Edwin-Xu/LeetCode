package company.oppo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 三个线程：
 * A：不断打压A
 * B：不断打印B
 * C：不断打印C
 *
 * 现在三个任务依次循环执行，打印ABCABCABC。。。
 * */
public class Main3 {
    /*
     * 方法2：Synchronized
     * */

    static int cond = 0;
    public static void main(String[] args) {
        Integer lock = new Integer(1);
        Thread a = new Thread(()->{
            synchronized (lock){
                while (true){
                    try {
                        if (cond==0){
                            System.out.println("A");
                            cond = 1;
                            lock.notifyAll();
                        }else{
                            lock.wait();
                        }
                    }catch (Exception e){}
                }
            }

        });
        Thread b = new Thread(()->{
            synchronized (lock){
                while (true){
                    try {
                        if (cond==1){
                            System.out.println("B");
                            cond = 2;
                            lock.notifyAll();
                        }else{
                            lock.wait();
                        }
                    }catch (Exception e){}
                }
            }

        });
        Thread c = new Thread(()->{
            synchronized (lock){
                while (true){
                    try {
                        if (cond==2){
                            System.out.println("C");
                            cond = 0;
                            lock.notifyAll();
                        }else{
                            lock.wait();
                        }
                    }catch (Exception e){}
                }
            }

        });
        a.start();
        b.start();
        c.start();
    }

}
