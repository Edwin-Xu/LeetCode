package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/13/2020 10:11 PM.
 *
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 *
 * 提示：
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */

public class LC_41_ {
    /*
暴力：加入Set，然后从1开始找
*/
    public int firstMissingPositive_v(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        for(int i = 1 ; i<Integer.MAX_VALUE;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }




    /*
    * 怎么样才不利用其他空间
    *
    * */


    private void swap(int[] nums,int j,int i){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }




}
