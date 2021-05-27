package leetcode.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Edwin Xu
 * @date 5/27/2021 4:12 PM.
 *
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */

public class LC_78 {
    List<List<Integer>>  ans ;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>(1<<nums.length);
        getSubset(nums, 0, new ArrayList<>());
        return ans;
    }

    private void getSubset(int[] nums, int index, List<Integer> list){
        if(index == nums.length-1){
            List<Integer> list1 = new ArrayList<>(list);
            ans.add(list1);
            List<Integer> list2 = new ArrayList<>(list);
            list2.add(nums[index]);
            ans.add(list2);
            return ;
        }
        list.add(nums[index]);
        getSubset(nums, index+1, list);
        list.remove(list.size()-1);
        getSubset(nums, index+1, list);
    }
}
