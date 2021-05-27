package company.pingduoduo.test2021;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 5/16/2021 6:05 PM.
 */

public class Main03 {
    public static void main(String[] args) {


        char [] c = "yxbpiplbso".toCharArray();
        Arrays.sort(c);
        System.out.println(c);

        String a = "dffjjmnv";
        String b = "bbioppsx";
        int res = 0;
        for (int i = 0; i <a.length() ; i++) {
            res += Math.abs(a.charAt(i)-b.charAt(i));
        }

        System.out.println(res);

    }

}
/**
 * dffjjlmnvy
 * bbiloppsxy
 *
 * dffjjmnv
 * bbioppsx
 *
 *
 *
 * */
