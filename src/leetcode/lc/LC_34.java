package leetcode.lc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 8/7/2020 10:27 AM
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class LC_34 {
    //一次遍历，O(N)
    public int[] searchRange1(int[] nums, int target) {
        int i=0;
        for(;i<nums.length;i++){
            if(nums[i]==target)break;
        }
        if(i==nums.length|| nums[i]!=target)return new int[]{-1,-1};
        int[] res = {i,-1};
        for(;i<nums.length;i++){
            if(nums[i]!=target)break;
        }
        res[1]=i-1;
        return res;
    }


    /*
    * 二分查找法，O(logN)
    * */
    public int[] searchRange(int[] nums, int target) {
        binS(nums,target,0,nums.length);
        if (min==Integer.MAX_VALUE)min=-1;
        return new int[]{min,max};
    }
    //返回l~r中=target的最小、最大下标
    //不想在递归中开太多的数组：使用成员变量
    private int min = Integer.MAX_VALUE;
    private int max = -1;
    private void binS(int []nums,int target,int l,int r){
        if (l>=r)return;
        if (l==r-1 ){
            if ( nums[l]==target){
                if (l<min)min= l;
                if (l>max)max = l;
            }
        }
        else{
            //判断下是不是在其中，不在直接返回，不要再遍历了
            if (target<nums[l]||target>nums[r-1])return;
            int mid = (l+r)/2;
            binS(nums,target,l,mid);
            binS(nums,target,mid,r);
        }
    }

    public static void main(String[] args) {
        LC_34 lc_34 = new LC_34();
        int arr[] = {5,7,7,8,8,10};
        System.out.println(lc_34.searchRange1(arr,8)[0]);
        System.out.println(lc_34.searchRange1(arr,8)[1]);
        System.out.println(lc_34.searchRange(arr,8)[0]);
        System.out.println(lc_34.searchRange(arr,8)[1]);
    }

}
