package leetcode.lc;

import java.util.ArrayList;

/**
 * Created by Edwin Xu on 5/18/2020 12:57 AM
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）
 * ，并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * 分析：
 * 如果有0：  X 0 Y 那就要比较0、X、Y的大小
 * 如果没有0或者对于两个0之间的数组： 那就看负数：
 *      负数个数为偶数：返回全部积
 *      负数个数为奇数：有一个负数不参与乘积，找出这个负数——绝对值最小的负数
 *
 * 所以解体步骤:
 * 1. 以0划分小数组
 *      1.1 如果没有0，那小数组就是原数组
 * 2. 对每个小数组找出最大成绩：小数组最大乘积必然>0
 * 3. 返回小数组乘积最大值
 *
 *
 * 不对：负数的时候，不能根据最大负数分割为两部分，必须使用每一个负数分割。
 * 这个实现太复杂了！！！！！！！！
 *
 *
 *
 *
 * 动态规划：
 *
 *
 *
 */
public class LC_152 {
    private int [] nums;
    public int maxProduct_failed(int[] nums) {
        this.nums = nums;
        int len = nums.length;
        int zeroNum=0;
        for (int n: nums)if (n==0)zeroNum++;
        if (zeroNum==0)return maxProductWithoutZero(0,len);//len取不到
        //有0、有负数：以0划分，求子数组的值。
        ArrayList<Integer> list = new ArrayList<>();
        int firstZeroIndex = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i]==0){
//                System.out.println(firstZeroIndex+"   "+i);
                list.add(maxProductWithoutZero(firstZeroIndex,i));
                firstZeroIndex = i+1;
            }
        }
        list.add(maxProductWithoutZero(firstZeroIndex,len));
//        Arrays.asList(list).forEach(System.out::print);
        int res =0;
        for (int n:list)if (n>res)res = n;
        return res;
    }
    //处理没有0，但是有负数的子数组：负数个数：奇数:按最大值划分，偶数，全乘积
    private int maxProductWithoutZero(int begin,int end){
        if (begin==end)return Integer.MIN_VALUE;
        int maxNeg = Integer.MIN_VALUE;
        int maxNegIndex = begin;
        int cnt = 0;
        for (int i = begin; i < end; i++) {
            if (nums[i]<0){
                cnt++;
                if (nums[i]>maxNeg){
                    maxNeg=nums[i];
                    maxNegIndex = i;
                }
            }
        }
        if ((cnt&1)==0)return getSum(begin,end);
        int left = getSum(begin,maxNegIndex);
        int right = getSum(maxNegIndex+1,end);
        left =  left>right?left:right;
        return left>nums[maxNegIndex]?left:nums[maxNegIndex];
    }
    private int getSum(int begin,int end){
        if (begin==end) return Integer.MIN_VALUE;
        int res = 1;
        for (int i=begin;i<end;i++)res*=nums[i];
        return res;
    }




    /*
    * 动态规划策略:
    * 顺序乘，评估乘之前和之后的大小并实时更新
    * 由于有负数，后面可能会变正数，需要记录。
    *
    * 例子：
    * [2,3,-2,4]
    * 当前值：2 6 6  6
    * 最小值：2 2 -12 -48
    *
    * [2,-2,-2,-3,4,-5]
    * 2 2  8  8   8   120
    * 2 -4 8 -24  -24  120
    *
    *
    * */
    public int maxProduct(int[] nums){
        int max = nums[0];
        int min = max;
        int tmp;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<0){
                tmp = max;
                max =Math.max(nums[i], max*nums[i]);
                min = Math.min(nums[i], tmp * nums[i]);
            }else{
                max = Math.max(nums[i],nums[i]*max);
                min = Math.min(nums[i],nums[i]*min);
            }
//            System.out.println(max+"  "+min);
        }
        return max;
    }
















/*
* 最大子序和：最大的连续子数组和
* 动态规划
*
* 本题类似
*
* 差异之处：成绩和加法不同，一个负号会导致最大值变为最小值
* 由于最小值摇身一变可以变为最大值，所以把最小值也存起来
*
*
* */
    public int myMaxProduct(int[] nums) {
        int len = nums.length;
        if (len==0)return -1;

        int mul_max=nums[0];
        int max = mul_max;
        int mul_min = max;
        for (int i = 1; i < len; i++) {
            int x = mul_max;
            mul_max = Math.max(Math.max(mul_max*nums[i],nums[i]), mul_min*nums[i]);
            if (mul_max>max)max = mul_max;
            mul_min =Math.min(Math.min(mul_min*nums[i],nums[i]),x*nums[i]);
        }
        return max;
    }



    public static void main(String[] args) {
//        int [] arr = {-1,2,3,-2,4};
        int [] arr = {-1,-2,-9,-6};
//        System.out.println(new LC_152().maxProduct(arr));
        System.out.println(new LC_152().myMaxProduct(arr));
    }
}
