package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 11/2/2020 2:19 PM.
 *
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */

public class LC_349 {
    //set
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2==null|| nums2.length==0){
            return new int[]{};
        }

        Set<Integer> set = new HashSet<>();
        for(int n:nums1){
            set.add(n);
        }
        int index = 0;
        Set<Integer> set1 = new HashSet<>();
        for(int n:nums2){
            if(set.contains(n) && !set1.contains(n)){
                nums1[index++] = n;
                set1.add(n);
            }
        }
        int []res = new int[index];
        System.arraycopy(nums1,0,res,0,index);
        return res;
    }

    //方法2：
    //排序：还记得同花顺算法面试题吗？
    //合并两个有序数组
    //如果每个数组元素都是互异的，怎么合并
    //这里也是一样的，当相同时才会加入结果数组。


}
