package designpattern.singleton;

/**
 * Created by Edwin Xu on 10/18/2020 11:42 AM.
 *
 */

public class DCLHungrySingleton {
    private static DCLHungrySingleton instance ;

    /*
    * DCL:Double check lock
    *
    * 有一个严重问题：这段代码有可能引发空指针异常，也就是调用getInstance() 方法会拿到一个空对象。
    * new操作在更细的层面分为以下三个步骤:
        (A) 分配新对象内存
        (B) 调用类构造器初始化成员变量
        (C) instance被赋为指向新对象的引用
    *经过指令重排可能形成以下新顺序：
        (A) 分配新对象内存
        (B) instance被赋为指向新对象的引用
        (C) 调用类构造器初始化成员变量
    *
    * 出现的问题：
    *   线程1执行到语句2，执行到instance被赋为指向新对象引用这个步骤，还没有进行初始化对象
        此时线程2执行到语句1，由于instance已经被赋为指向新对象的引用，myConnection已经不等于null，所以可以执行到语句3
        但是语句3返回的是没有进行初始化的对象，所以使用这个对象就会抛出空指针异常
    *
    * 可以使用Volatile解决单例DCL空指针异常。
    * */
    public  static DCLHungrySingleton getInstance()  throws Exception{
        if (instance==null){
            synchronized (DCLHungrySingleton.class){
                if (instance==null){
                    instance = new DCLHungrySingleton(); //2
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i <2 ; i++) {
            new Thread(()->{
                try {
                    if ((DCLHungrySingleton.getInstance()==null)){
                        System.out.println("--------Null---------");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
