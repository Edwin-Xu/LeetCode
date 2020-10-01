package leetcode.interview.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 9/30/2020 7:38 PM
 *
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 */
public class Offer_56_2 {
    //HashMap
    public int singleNumber_hash(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.merge(n, 1, (a, b) -> {
                return a + 1;
            });
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                return e.getKey();
            }
        }
        return 0;
    }


    //位运算
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
