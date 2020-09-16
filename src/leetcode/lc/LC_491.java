package leetcode.lc;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 9/15/2020 7:25 PM
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 *
 *
 * 后面做，有点难
 */
public class LC_491 {

    public List<List<Integer>> findSubsequences(int[] nums) {

        return res;
    }
    private List<List<Integer>> res = new LinkedList<>();
    void find(int nums[], int start, List<Integer> list){
        //对于start: 可选，可不选

        list.add(nums[start]);
        find(nums,start+1,list);

    }

}







