package leetcode.contest.contest20210625;

/**
 * @author Edwin Xu
 * @date 6/25/2021 7:01 PM.
 *
 * 链接：https://ac.nowcoder.com/acm/contest/11175/B
 * 来源：牛客网
 *
 * 题目描述
 * 疲惫的你闲暇之余最爱听牛少芬的《命运交响曲》，其曲调在你脑中甚至可以抽象成一个长度为nn且仅包含小写字母的字符串SS。
 *
 * 一天，你最好的朋友得知你对《命运交响曲》颇有研究，想让你提供三段互不重复的《命运交响曲》片段，且要求这三段片段的优美度之和最大。你转头一想，也就是从《命运交响曲》曲调抽象成的这个字符串中选出三个不相交的区间，使这三个区间的区间长度之和最大。当然，要求选出的任意一个区间，区间内每种小写字母的出现次数不能超过mm。
 *
 * 请问最大的区间长度之和是多少?
 *
 * 输入描述:
 * 第一行两个正整数nn,mm，3\leq n\leq 10^{7}3≤n≤10
 * 7
 *  ,m\leq 10^{9}m≤10
 * 9
 *  。
 *
 * 第二行一个长度为nn且仅包含小写字母的字符串SS。
 *
 * 输出描述:
 * 输出最大区间长度之和。
 *
 * 示例1
 * 输入
 * 复制
 * 8 1
 * abccbaaa
 * 输出
 * 复制
 * 7
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nums = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        char [] chs = scanner.nextLine().toCharArray();

        // 从每个字符开始的最大长度
        int[] arr = new int[chs.length];
        Map<Character,Integer> map = new HashMap<>(32);
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a'+i),0);
        }
        int cur = 0;
        for (int i = 0; i < chs.length; i++) {
            while (cur<chs.length && map.get(chs[cur]) < m ){
                map.put(chs[cur], map.get(chs[cur])+1);
                cur++;
            }
            arr[i] = cur-i;
            map.put(chs[i], map.get(chs[i])-1);
        }

//        for (int i : arr) {
//            System.out.print(i);
//        }
//        System.out.println();


        // arr相邻两个，要么末端一样，要么后者长，即要么前者覆盖，要么后者超越
        // 如何选三个不想交的，得到最大和
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length  ; j++) {
                if (i+arr[i] >=j+arr[j])continue;
                for (int k = j+1; k < arr.length  ; k++) {
                    if (j+ arr[j] >= k + arr[k])continue;
//                    System.out.println(i+"-"+j+"-"+k);
                    int len = arr[i] + arr[j] + arr[k]
                            - (i+arr[i]>j?i+arr[i]-j:0 )
                            - (j+arr[j]>k?j+arr[j]-k:0);
//                    System.out.println(len);
                    max = Math.max(len,max);
                }
            }
        }

        System.out.println(max);

        scanner.close();
    }
}
