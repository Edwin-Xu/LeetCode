package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 9/27/2020 11:52 PM
 * <p>
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class Offer_53 {
    public int missingNumber_edwinxu(int[] nums) {
        if (nums[0] != 0) return 0;
        //保证第一个是0
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) { //中间某个数不存在
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] + 1;//末尾这个数不存在
    }


    /*
    -----------------------------------------------------------------------------------------
    二分：

    排序数组中的搜索问题，首先想到 二分法 解决。
    根据题意，数组可以按照以下规则划分为两部分。
    左子数组： nums[i] = inums[i]=i ；
    右子数组： nums[i] \ne inums[i]
    ​
    缺失的数字等于 “右子数组的首位元素” 对应的索引；因此考虑使用二分法查找 “右子数组的首位元素” 。

    */
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
