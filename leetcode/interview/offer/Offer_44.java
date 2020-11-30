package leetcode.interview.offer;

import java.util.*;

/**
 * Created by Edwin Xu on 10/17/2020 10:29 PM.
 *
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 *
 */

public class Offer_44 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }



    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(1000+20);
        for (int i = 0; i < 1000; i++) {
            if (sb.length()==1002)break;
            sb.append(i);
        }

        System.out.print(sb.charAt(1000-4));
        System.out.print(sb.charAt(1000-3));
        System.out.print(sb.charAt(1000-2));
        System.out.print(sb.charAt(1000-1));
        System.out.print(sb.charAt(1000));
        System.out.print(sb.charAt(1000+1));
    }
}
