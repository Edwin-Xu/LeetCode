package leetcode.lc;

/**
 * Created by Edwin Xu on 8/29/2020 12:12 PM
 * 704. 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class LC_704 {
    //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目
    // 标值 target  ，写一个函数搜索 nums 中的 target，
    // 如果目标值存在返回下标，否则返回 -1。
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = nums[mid];
            if (val == target) return mid;
            else if (val < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
