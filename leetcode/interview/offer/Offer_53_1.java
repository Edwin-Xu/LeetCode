package leetcode.interview.offer;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 8/29/2020 11:11 AM
 *
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 */
public class Offer_53_1 {
    public int search(int[] nums, int target) {
         /*
        二分查找:找第一个target，然后从数组中向两边找
        */
        int res = 0;
        int l =0 , r = nums.length-1;
        if(r==-1)return 0;
        int mid =0;
        while(l<=r){
            mid = (l+r)/2;
            Print.print(l,r,mid);

            if(nums[mid] ==target)break;
            else if(nums[mid] <target){
                 l=mid+1;
            }else{
                r=mid-1;
            }
        }

        Print.print("mid",mid);
        if(nums[mid]!=target)return res;
        for(int i=mid;i>=0;i--){
            if(nums[i]==target)res++;
            else break;
        }
        for(int i=mid+1;i<nums.length;i++){
            if(nums[i]==target)res++;
            else break;
        }
        return res;
    }



    /*
    * 其他解法
    * */
    class Solution {
        public int search(int[] nums, int target) {
            return helper(nums, target) - helper(nums, target - 1);
        }
        int helper(int[] nums, int tar) {
            int i = 0, j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if(nums[m] <= tar) i = m + 1;
                else j = m - 1;
            }
            return i;
        }
    }

    public static void main(String[] args) {
        int arr [] ={1,4};
        Offer_53_1  offer_53_1=new Offer_53_1();
        System.out.println(offer_53_1.search(arr,4));
    }
}
