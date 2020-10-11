package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 10/12/2020 12:12 AM.
 *
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 *
 *
 * 示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

public class LC_202 {

/*
一次过，效率不高
外循环20次就100% 了

这种方式并不规范

需要真正去检测循环！！！

set用来检测循环？？
*/
    public boolean isHappy(int n) {
        for (int i = 0; i < 20; i++) {
            if (n == 1) return true;
            int sum = 0;
            int m = n;
            for (int j = 0; j < 10; j++) {
                int r = m % 10;
                sum += (r * r);
                m /= 10;
            }
            n = sum;
        }
        return false;
    }
    /*
    * 其他方式
    * https://leetcode-cn.com/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/
    * */
}
