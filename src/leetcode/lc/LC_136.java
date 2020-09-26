package leetcode.lc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 9/26/2020 2:42 PM
 *
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class LC_136 {
    /*
            1.sort
            2.hash
            3.XOR
*/

    public int singleNumber(int[] nums) {
        int num = 0;
        for (int n : nums) num ^= n;
        return num;
    }


    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            Print.print((i*2) ^ (i*2+1));
        }

    }
}
