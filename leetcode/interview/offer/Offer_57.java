package leetcode.interview.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 9/27/2020 10:43 PM
 *
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 */
public class Offer_57 {

    /*
  使用hashmap可以实现普通的两数之和。

  但是这里是有序的数组：
  使用两个指针i,j：
   从0开始向后遍历：
   计算和sum：
      sum<target：j++
      sum>target: i++
      ??? 不是连续数组！！！不能这样？
      可以的？？
      还是不行的。
      int i=0,j=1;
      int res [] = new int[2];
      int sum = 0;
      while(i<j&&j<nums.length){
          sum= nums[j]+nums[i];
          if(sum==target){
              res[0] = nums[i];
              res[1] = nums[j];
              return res;
          }
          else if(sum<target){
              j++;
          }else{
              i++;
          }
      }
      return res;


        可以使用双指针，上面的思路有问题而已。
      双指针需要从两边向中间紧缩：紧缩没问题，不会丢失解

  */
    public int[] twoSum_edwinxu(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int [] res = new int[2];
        for(int n:nums){
            if(map.containsKey(target-n)){
                res[0] = n;
                res[1] = target-n;
            }else{
                map.put(n,0);
            }
        }
        return res;
    }

    /*
    * 双指针：
    * */

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }




}
