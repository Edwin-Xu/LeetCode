package designpattern.singleton;

/**
 * Created by Edwin Xu on 10/18/2020 11:42 AM.
 */

public class LazySingleton {
    private static LazySingleton instance = new LazySingleton();
    public static LazySingleton getInstance() {
        return instance;
    }
}
