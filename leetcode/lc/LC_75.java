package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/7/2020 8:04 PM.
 * <p>
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */

public class LC_75 {
    //排序:O(NlogN)
    public void sortColors_sort(int[] nums) {
        Arrays.sort(nums);
    }

    //先计数，然后分配数组中的位置
    //两趟扫描 O(2N)
    public void sortColors_2_traversal(int[] nums) {
        int red = 0;
        int white = 0;
        for (int n : nums) {
            if (n == 0) red++;
            else if (n == 1) white++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < red) nums[i] = 0;
            else if (i < white + red) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    /*一次遍历
    双指针：
     //双指针
        int p = 0, q = n - 1;
        for (int i = 0; i <= q; ++i)
        {
            if (nums[i] == 0)
            {
                nums[i] = nums[p];
                nums[p] = 0;
                ++p;
            }
            if (nums[i] == 2)
            {
                nums[i] = nums[q];
                nums[q] = 2;
                --q;
                if (nums[i] != 1)
                    --i;
            }
        }
    */

    /**
     * 用两个指针p,q指向红色、蓝色——即头尾
     * 然后从头遍历，遇到红色，就交换到p处，遇到blue，交换到q处
     */
    public void sortColors(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        for (int i = 0; i <= q; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p);
                p++;
            } else if (nums[i] == 2) {
                swap(nums, i, q);
                q--;
                i--;
            }
        }
    }

    private void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
