package leetcode.lc;

import leetcode.util.Print;

/**
 * @author Edwin Xu
 * @date 5/23/2021 3:59 PM.
 *
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 */

public class LC_66 {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1] ++;

        int carry = 0;
        for (int i = digits.length -1; i >=0 ; i--) {
            digits[i] += carry;
            if (digits[i]>9){
                digits[i]-=10;
                carry =1;
            }else{
                carry = 0;
                break;
            }
        }
        if (carry == 1){
            int[] ints = new int[digits.length + 1];
            ints[0]=1;
            return ints;
        }
        return digits;
    }

    public static void main(String[] args) {
        LC_66 lc66 = new LC_66();
        int arr [] = {9,9,9};
        int[] plusOne = lc66.plusOne(arr);
        Print.printArr(plusOne);
    }
}
