package javabasis;

/**
 * Created by Edwin Xu on 6/27/2020 10:13 PM
 */
public class xor_performance {
    public static void main(String[] args) {
        int x = 100;
        int y = 200;

//        int z= x;
//        x = y;
//        y =z;

//        x = x+y;
//        y = x-y;
//        x = x-y;
//
        x^=y;
        y^=x;
        x^=y;
    }
}
