package leetcode.interview.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Edwin Xu on 9/27/2020 11:14 PM
 *
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Offer_61 {

    //排序+遍历
    public boolean isStraight_edwinxu(int[] nums) {
        Arrays.sort(nums);//排个序

        int zeroNum = 0; //0的个数，即大小王的个数，大小王可以充当任意数
        for(int n:nums){
            if(n==0)zeroNum++;
            else break;
        }
        //对<i,i+1>进行判断
        for(int i=zeroNum;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]>1){//如果不连续
                if(zeroNum>0){ //还有大小王
                    zeroNum--;
                    nums[i]++;//使用一种大小王 填充一个数(将nums[i]+1)
                    i--;
                    continue;
                }
                else return false;//没有0了，false
            }else if(nums[i+1]==nums[i])return false;//两个相同的，false
        }
        return true;
    }

    //排序+遍历 写法2
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }




    //方法2：max - min < 5
    public boolean isStraight_(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }


}
