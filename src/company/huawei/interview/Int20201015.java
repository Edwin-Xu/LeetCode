package company.huawei.interview;

/**
 * Created by Edwin Xu on 10/15/2020 3:58 PM.
 *
 *
 * 华为面试
 *
 *
 *
 *
 *
 * docker?????????????
 *
 * // 内存泄露
 * A = Obj
 * List<A>
 *     list.add A
 *
 *     A= null
 *
 *
 *
 */

public class Int20201015 {

    private A a ;


    class A{

    }

    public void f(){
        class B{

        }

//        Integer a =100;

        String a = "100";
        String b = "100";
        // true
        // 两者都指向常量池中这个对象，
        // 这里是没有在堆里面在开对象的，你想啊，也没必要在堆里面再次开辟一个对象，直接是栈里面的一个引用



        Integer a1  =100;
        Integer a2 = 100;
        System.out.println(a1==a2);

        String c = new String("12");
        String d = new String("12");

        System.out.println(c==d); //false

    }



    public static void main(String[] args) {
        Int20201015 main2 = new Int20201015();
//        main2.new A();

        final int[] flag = {1};

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //这里synchronized (main2)放到外面会更好吧
                    synchronized (main2) {
                        if (flag[0] == 1) {
                            try {
                                main2.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(1);
                        flag[0] = 1; //这里太坑了，前面是1才会阻塞，没阻塞才会运行到这里，说明flag[0]=2，这里就需要设置为1；
                        main2.notify();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (main2) {
                        if (flag[0] == 2) {
                            try {
                                main2.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.print(2);
                        flag[0] = 2;
                        main2.notifyAll();
                    }
                }
            }
        });

        t1.start();;
        t2.start();

    }

}
