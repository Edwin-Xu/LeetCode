package designpattern.singleton;

/**
 * Created by Edwin Xu on 10/18/2020 11:42 AM.
 *
 */

public class HungrySingleton {
    private static HungrySingleton instance ;

    /*
    * 锁粒度较大，可能会影响性能。
    * */
    public synchronized static HungrySingleton getInstance() {
        if (instance==null)instance = new HungrySingleton();
        return instance;
    }
}
