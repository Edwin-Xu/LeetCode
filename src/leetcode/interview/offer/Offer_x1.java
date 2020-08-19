package leetcode.interview.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Edwin Xu on 7/22/2020 12:33 PM
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 *
 */
public class Offer_x1 {
    public static int getMinCombination(Integer []arr){
        Arrays.sort(arr,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = String.valueOf(o1);
                String b = String.valueOf(o2);
                return Integer.valueOf(a+b)-Integer.valueOf(b+a);
            }
        });

        for (int i: arr){
            System.out.print(i+" ");
        }
        return 0;

    }

    public static void main(String[] args) {
        Integer a[] = {999,0,1,2,15,21,29,105};
        Offer_x1.getMinCombination(a);
    }
}
