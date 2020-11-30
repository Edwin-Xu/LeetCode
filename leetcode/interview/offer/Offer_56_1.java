package leetcode.interview.offer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 9/30/2020 7:34 PM
 * <p>
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class Offer_56_1 {
    //先来个HashMap的：
    public int[] singleNumbers_edwinxu(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.merge(n, 1, (a, b) -> {
                return a + 1;
            });
        }
        int res[] = new int[2];
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                if (res[0] == 0) res[0] = e.getKey();
                else res[1] = e.getKey();
            }
        }
        return res;
    }


    /*
    ------------------------------------------------------------------------------
    分组异或：
    分为两组：
        - 两个不同的数A、B分别在其中一组
        - 相同的数在一组
    怎么分组？
    X = 所有数异或= AB异或
    取X二进制任意为1的位：
     === 该位上AB一个为1一个为0，而相同的数都为1或者0 ===
     所以：可以按该为分组。
        对于一个数C，C的该为=1，分到1组，为0分到2组。


    */
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }


    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(3);
        BigDecimal c = a.divide(b,RoundingMode.CEILING); //舍去模式
        System.out.println(c.toPlainString());

    }
}
