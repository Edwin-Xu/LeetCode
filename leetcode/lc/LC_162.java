package leetcode.lc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 8/29/2020 12:36 PM
 * 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 */
public class LC_162 {
    /*
    * 二分查找，但是不知道走那边，因为走左边、右边都行。
    * 只能用递归，先尝试走左边，不行再回溯走右边
    * */

    public int findPeakElement(int[] nums) {
        int L =0 , R= nums.length-1;
        if(R<=0)return 0; // 数组长度不足直接返回
        return binarySearch(nums,L,R);
    }

    //递归二叉查找
    private int binarySearch(int [] nums, int L,int R){
        if (L>R)return -1; // 不满足条件
        if (L==R){
            return isPeak(nums,L)?L:-1; // 递归终止条件。
        }else{
            int mid = (L+R)/2;
            if (isPeak(nums,mid))return mid;
            int left = binarySearch(nums,L,mid-1);//先搜索左边
            if (left!=-1)return left;//左边有峰值，直接返回，不用搜右边
            else return binarySearch(nums,mid+1,R);//左边没有再搜索右边
        }
    }

    //判断一个数是不是峰值
    private boolean isPeak(int nums[] ,int index){
        if (index==0 || index==nums.length-1){//左右两个极端值，大于一边即可
            int nextIndex = index==0?1:index-1;
            if (nums[index]>nums[nextIndex])return true;
            return false;
        }else{//中间值，需要大于左右两边
            if (nums[index-1]<nums[index] && nums[index]>nums[index+1])return true;
            else return false;
        }
    }



    /*
    * 上面这个算法最差是O(N )
    *
    * 还要更好的写法：
    * 如果一个数大于右边的这个数，那么峰值一定在左边
    * 否则：峰值一定在左边
    *
    * */
    public class Solution {
        public int findPeakElement(int[] nums) {
            return search(nums, 0, nums.length - 1);
        }
        public int search(int[] nums, int l, int r) {
            if (l == r) return l;
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) return search(nums, l, mid);
            return search(nums, mid + 1, r);
        }
    }



    public static void main(String[] args) {
        int arr []= {1,2};
        System.out.println(new LC_162().findPeakElement(arr));
    }
}
