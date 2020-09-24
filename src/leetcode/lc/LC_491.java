package leetcode.lc;

import leetcode.util.Print;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 9/15/2020 7:25 PM
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class LC_491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        find(nums, 0, new LinkedList<>());
        return res;
    }

    private List<List<Integer>> res = new LinkedList<>();

    /*
    * 还有一点小问题
    * */
    private void find(int nums[], int start, LinkedList<Integer> list) {
        //对于start: 可选，可不选
        if (start > nums.length) return;
        if (list.size() > 1) {
            res.add(new LinkedList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (i>start && nums[i]==nums[i-1])continue;
            if (list.isEmpty() || list.get(list.size() - 1) <= nums[start]) {
                list.add(nums[i]); //这里添加的是nums[i]，不是nums[start]多少次了！！！
                find(nums, i + 1, list);//这里是i+1，不是start+1,多少次了！！！
                list.removeLast();
            }
        }
    }

    /*
    *
List<List<Integer>> ans = new ArrayList<List<Integer>>();
List<Integer> temp = new ArrayList<Integer>();
public void dfs(int cur, int[] nums) {
    if (cur == nums.length) {
        // 判断是否合法，如果合法判断是否重复，将满足条件的加入答案
        if (isValid() && notVisited()) {
            ans.add(new ArrayList<Integer>(temp));
        }
        return;
    }
    // 如果选择当前元素
    temp.add(nums[cur]);
    dfs(cur + 1, nums);
    temp.remove(temp.size() - 1);
    // 如果不选择当前元素
    dfs(cur + 1, nums);
}

    * */

    public static void main(String[] args) {
        LC_491 lc_491 = new LC_491();
        int arr[] = {4, 6, 7, 7};
        List<List<Integer>> res = lc_491.findSubsequences(arr);
        Print.printListList(res);

    }

}







