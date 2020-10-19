package company.huawei.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Edwin Xu on 10/15/2020 9:05 PM.
 */

public class ThreadTest {
    public static void main(String[] args) {
        final int[] flag1 = {0};
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                flag1[0] =2;
            }
        });

        AtomicInteger flag2 = new AtomicInteger(1);
        Thread t2 = new Thread(()->{
            flag2.set(2);
        });

        int flag3=0;
        Thread t3 = new Thread(()->{
//            flag3 = 1;
        });

        /*
        *
        * 将变量作为一个新的类的属性，在构造函数中对该变量进行操作
将变量放在数组中的一个index绕开检查
        * */
    }
}
