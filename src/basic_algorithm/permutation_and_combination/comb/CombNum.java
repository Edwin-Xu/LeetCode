package basic_algorithm.permutation_and_combination.comb;

import java.math.BigInteger;

/**
 * Created by Edwin Xu on 9/24/2020 12:50 AM
 */
public class CombNum {

    public static String combination(int n, int m) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        for (int i = 1; i <= m; i++) {
            b = b.multiply(new BigInteger(String.valueOf(i)));
            a = a.multiply(new BigInteger(String.valueOf(n - i + 1)));
        }
        return a.divide(b).toString();
    }


    public static void main(String[] args) {
        System.out.println(combination(1000,500));
    }
}
