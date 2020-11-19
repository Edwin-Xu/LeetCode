package leetcode.lc;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 11/19/2020 10:48 AM.
 *
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

public class LC_283 {
    /**
     * 双指针：
     * p: 从前往后走
     * q: 从前往后走，跳过0
     *
     * 注意：这是覆盖了，违背了题目[移动0]的本意
     *
     */
    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        int p = 0, q = 0;
        int len = nums.length;

//        while(q<len){
//            while(q<len && nums[q]==0){
//                q++;
//            }
//            if(q<len){
//                nums[p++]=nums[q++];
//            }
//        }
//        or :
        while(q<len){
            if (nums[q]!=0){
                nums[p++] = nums[q++];
            }else{
                q++;
            }
        }
        // 8行变6行，更加清爽，更加高效-------------代码的艺术



        for(int i=p;i<len;i++){
            nums[i] = 0;
        }
    }



    /**
     * 双指针移动：
     * p:从0开始，指向已经处理好的前缀的尾部，即p及其前的都是非0，且按序
     * q:指向未处理的部分，且其左边到p都是已经处理好产生的0，右边未处理
     * */
    public void moveZeroesByMoving(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
        //上面我的解法中 两个while可以按这个改写为一个while，更加清爽
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
