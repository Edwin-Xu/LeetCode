package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 9/27/2020 11:40 PM
 *
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 */
public class Offer_39 {
    //摩尔投票法
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==res){
                cnt++;
            }else{
                cnt--;
                if(cnt==0){
                    res = nums[i];
                    cnt=1;
                }
            }
        }
        return res;
    }

    //还有更好的写法：
    //https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/

}
