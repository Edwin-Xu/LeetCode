package leetcode.interview.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin Xu on 9/28/2020 8:15 PM
 * <p>
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class Offer_57_2 {
    /*
b(b+1)/2 - a(a+1)/2
=
暴力
*/
    public int[][] findContinuousSequence_edwinxu(int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int max = 0;
        int mid = (target + 1) / 2;
        for (int i = 1; i <= mid; i++) {
            for (int j = i + 1; j < mid + 1; j++) {
                int sum = (j * (j + 1) - i * (i - 1)) / 2;
                if (sum == target) {
                    ArrayList<Integer> aList = new ArrayList<>();
                    for (int k = i; k <= j; k++) aList.add(k);
                    list.add(aList);
                    max = Math.max(max, aList.size());
                } else if (sum > target) break;
            }
        }

        int[][] res = new int[list.size()][max];
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> tmp = list.get(i);
            int[] arr = new int[tmp.size()];
            for (int j = 0; j < tmp.size(); j++) arr[j] = tmp.get(j);
            res[i] = arr;

        }
        return res;
    }


/*
双指针：

class Solution {
public:
    vector<vector<int>> findContinuousSequence(int target) {
        vector<vector<int>>vec;
        vector<int> res;
        for (int l = 1, r = 2; l < r;){
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target){
                res.clear();
                for (int i = l; i <= r; ++i) res.emplace_back(i);
                vec.emplace_back(res);
                l++;
            }
            else if (sum < target) r++;
            else l++;
        }
        return vec;
    }
};


*/


    /*滑动窗口

    这算是滑动窗口的经典问题了吧


    当窗口的和小于 target 的时候，窗口的和需要增加，所以要扩大窗口，窗口的右边界向右移动
    当窗口的和大于 target 的时候，窗口的和需要减少，所以要缩小窗口，窗口的左边界向右移动
    当窗口的和恰好等于 target 的时候，我们需要记录此时的结果。设此时的窗口为 [i, j)[i,j)，那么我们已经找到了一个 ii 开头的序列，也是唯一一个 ii 开头的序列，接下来需要找 i+1i+1 开头的序列，所以窗口的左边界要向右移动

    */
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }


}
