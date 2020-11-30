package leetcode.lc;

/**
 * Created by Edwin Xu on 8/29/2020 1:29 PM
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 */
public class LC_35 {
    // 遍历解法 O(N)，不好
    public int searchInsert_iteration(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            if ((nums[i] < target) && (i + 1 == nums.length || nums[i + 1] > target)) return i + 1;
        }
        return 0;
    }

    /*
     * 二分查找
     * 如果存在就返回下标
     * 不存在应当返回 第一个小于 target的值
     * */
    public int searchInsert(int[] nums, int target) {
        int l = 0 , r = nums.length-1;
        int index = 0;
        while (l<=r){
            if (l==r){
                if(nums[l]==target)return l;
                index = r; //退出前更新index         (有两个退出点，都需要更新一下)
                break;
            }else{
//                int mid = (l+r)/2; //(除以2尽量用位运算 >>)
                int mid = (l+r)>>1;
                if (target==nums[mid])return mid;
                if (target<nums[mid])r =  mid-1;
                else l=mid+1;
            }
            if (l>r)index = l; //退出前记录下位置
        }
        return target>nums[index]?index+1:index;

    }

    public int searchInsert_LeetCode_Solution(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid; //这个ans很巧妙，如果<=, 则更新值，而不是判断==而返回
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int arr [] = {3,5,7,9,10};
        System.out.println(new LC_35().searchInsert(arr,8));
    }
}
