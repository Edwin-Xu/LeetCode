package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 11/3/2020 11:52 PM.
 *
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 */

public class LC_941 {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        if(len<3)return false;

        int index = 0;
        while(index+1<len && A[index]<A[index+1]){
            index++;
        }
        //完全递增或者递减
        if(index==0 || index==len-1)return false;

        while(index+1<len && A[index]>A[index+1]){
            index++;
        }
        return index == len-1;
    }
}
