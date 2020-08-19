package leetcode.interview.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Edwin Xu on 7/30/2020 5:55 PM
 *
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 *
 *
 * 分析：只要保证两两之间满足关系，整体就满足
 *
 */
public class Offer_42 {

    public String minNumber(int [] nums) {
        Integer arr[] = new Integer[nums.length];
        for(int i=0;i<nums.length;i++)arr[i]=nums[i];
        Arrays.sort(arr,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int)(Long.valueOf(o1+""+o2)-Long.valueOf(o2+""+o1));
            }
        });


        StringBuilder sb = new StringBuilder();
        for (int i:arr)sb.append(i);
        return sb.toString();
    }


    public static void main(String[] args) {
        int [] arr = {3,30,34,5,9};
        String s = new Offer_42().minNumber(arr);
        System.out.println(s);
    }


}
