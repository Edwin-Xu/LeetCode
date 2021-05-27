package company.pingduoduo.test2021;

import java.util.*;

/**
 * 多多君最近在研究字符串之间的变换，可以对字符串进行若干次变换操作:
 * <p>
 * 交换任意两个相邻的字符，代价为0。
 * 将任意一个字符a修改成字符b，代价为 |a - b|（绝对值）。
 * 现在有两个长度相同的字符串X和Y，多多君想知道，如果要将X和Y变成两个一样的字符串，需要的最少的代价之和是多少。
 * <p>
 * <p>
 * 从左往右，找出每一个不一样的区间，在这个区间内，先把一样的对齐，这个部分代价为0，
 * 剩下的都是不能通过移动解决的，都从大大小排列，成对相减，差加起来即可。
 */
public class Main01 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        char[] chs1 = sc.nextLine().toCharArray();
        char[] chs2 = sc.nextLine().toCharArray();
        sc.close();

        int res = 0;

        // 去掉一样的，然后排序相减
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map1.put(i, 0);
            map2.put(i, 0);
        }

        for (char c : chs1) {
            map1.put(c, map1.get(c) + 1);
        }
        for (char c : chs2) {
            map2.put(c, map2.get(c) + 1);
        }

        for (char i = 'a'; i <= 'z'; i++) {
            int a = map1.get(i);
            int b = map2.get(i);
            int min = Math.min(a, b);
            map1.put(i, a - min);
            map2.put(i, b - min);
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < map1.get(i); j++) {
                sb1.append(i);
            }
            for (int j = 0; j < map2.get(i); j++) {
                sb2.append(i);
            }
        }

        for (int i = 0; i <sb1.length() ; i++) {
            res+= Math.abs(sb1.charAt(i)-sb2.charAt(i));
        }

        System.out.println(res);
    }
}
