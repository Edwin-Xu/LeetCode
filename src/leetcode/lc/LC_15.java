package leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 7/9/2020 1:42 PM
 *
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 *
 *
 * 用朴素的三重循环去找：太多的重复结果，去重很复杂。
 *
 * 如果在循环中，要求：
 *  循环2值>循环1值
 *  循环3值>循环2值
 * 这样找出来的a<=b<=c, (b,c,a)等重复元素被去掉了
 *
 *
 *
 * 排序+双指针
 *
 *
 */
public class LC_15 {
//    public List<List<Integer>> threeSum(int[] nums) {
//        int len = nums.length;
//        Arrays.sort(nums);
//        List<List<Integer>> res =new ArrayList<>();
//        for (int i = 0;i<len;i++){
//            for (int j=i+1;j<len;j++){
//                for (int k = j+1;k<len;k++){
//                    if (nums[i]<=nums[j]&&nums[j]<=nums[k]&& nums[i]+nums[j]+nums[k]==0){
//                        ArrayList<Integer> a = new ArrayList<>();
//                        a.add(nums[i]);
//                        a.add(nums[j]);
//                        a.add(nums[k]);
//                        res.add(a);
//                    }
//                }
//            }
//        }
//        return res;
//
//    }


    /*
    * 很好的答案
    *
    * */
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况

            //这里就是两数之和了
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }

    //把上面这个答案的思路写下：
    /*
    * f(itn nums[]){
    *   1.排序
    *   2.遍历外循环：内部退化为双指针的twosum
    *       3. 双指针：
    *       int target = -num[i];//两数之和--目标
    *       while(l<r){
    *           int sum = num[l]+num[r];
    *           if sum>target: r-- //不满足，大了，右指针左移
    *           if sum < target : l++; //不满足，小了，左指针右移
    *           if sum==target: //找到一对，还需要继续找。需要注意不要和当前值重复，于是左右指针需要移动到和原来位置不同的元素处
    *               res.add()
    *               while(num[l]!=num[l+1])l++;
    *               while(num[r]!=num[r-1])r--;
    *       }
    * }
    *
    * 可见：思路很清晰
    * 外循环 O(N)
    * 双指针也是O(N)
    * */





}
