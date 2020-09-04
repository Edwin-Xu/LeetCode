package leetcode.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 9/1/2020 4:40 PM
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class LC_77 {
    /**
     * 我的解法:首先是使用递归
     * */
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int nums[] = new int[n];
        for (int i = 1; i <= n; i++) nums[i - 1] = i;
        comb_recur(nums, 0, 0, k, new ArrayList());
        return res;
    }

    public void comb_recur(int nums[], int startIndex, int foundNum, int n, ArrayList<Integer> list) {

        if (foundNum > n || nums.length - startIndex < n-foundNum||startIndex>=nums.length) { //如果K个已经找到了，或者剩余的不足，或者下标越界了
            if (list.size() == n) res.add(list);
            return;
        }
        comb_recur(nums, startIndex + 1, foundNum, n, list);
        ArrayList<Integer> newList = new ArrayList<>(list);
        newList.add(nums[startIndex]);
        comb_recur(nums, startIndex + 1, foundNum + 1, n, newList);
    }


    public static void main(String[] args) {
        LC_77 lc_77= new LC_77();
        lc_77.combine(3,3);
    }


    /*
    * 回溯：
    * 这个思路比我的还有简单
    * 性能比我的差多了
    * */
    class Solution_backtrack {
        List<List<Integer>> output = new LinkedList();
        int n;
        int k;
        public void backtrack(int first, LinkedList<Integer> curr) {
            if (curr.size() == k) output.add(new LinkedList(curr));
            for (int i = first; i < n + 1; ++i) {
                curr.add(i);
                backtrack(i + 1, curr);
                curr.removeLast();
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backtrack(1, new LinkedList<Integer>());
            return output;
        }
    }



/*字典序 (二进制排序) 组合
这个只适合本题，不适合找数组中的组合序列
* */
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            // init first combination
            LinkedList<Integer> nums = new LinkedList<Integer>();
            for(int i = 1; i < k + 1; ++i)
                nums.add(i);
            nums.add(n + 1);

            List<List<Integer>> output = new ArrayList<List<Integer>>();
            int j = 0;
            while (j < k) {
                // add current combination
                output.add(new LinkedList(nums.subList(0, k)));
                // increase first nums[j] by one
                // if nums[j] + 1 != nums[j + 1]
                j = 0;
                while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
                    nums.set(j, j++ + 1);
                nums.set(j, nums.get(j) + 1);
            }
            return output;
        }
    }

}
