package company.oppo;

/*
* 三个线程：
* A：不断打压A
* B：不断打印B
* C：不断打印C
*
* 现在三个任务依次循环执行，打印ABCABCABC。。。
* */
public class Main2 {
    /*
    * 方法1：通过一个变量作为锁，每个任务通过修改该变量控制执行顺序。
    *
    * 确定：没有线程上下文切换，所有线程都不断在竞争CPU时间片
    * */
    volatile  static  Integer Lock = 0;
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock){
                    try {
                        while (true) {
                            if(Lock==0){
                                System.out.print("A");
                                Lock = 1;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock){
                    try {
                        while (true) {
                            if(Lock==1){
                                System.out.print("B");
                                Lock = 2;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Lock){
                    try {
                        while (true) {
                            if(Lock==2){
                                System.out.print("C");
                                Lock = 0;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

    }
}
