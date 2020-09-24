package company.oppo;

/**
 * Created by Edwin Xu on 9/24/2020 2:40 PM
 *
 *
 * wait 是让一个线程等待
 * 需要结合同步锁
 * 同时需要在适当的条件下wait、notify
 */
public class ObjWaitNotify {
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
    }
}
