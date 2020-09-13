package leetcode.nowcoder.nc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 9/8/2020 4:45 PM
 * 两数之和
 * <p>
 * <p>
 * 题目描述
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {2, 7, 11, 15},目标值为9
 * 输出 index1=1, index2=2
 */
public class NC_61 {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res[] = new int[2];
        int a = 0, b = 0;
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            if (map.containsKey(target - cur)) {
                a = i + 1;
                b = map.get(target - cur) + 1;
                break;
            } else {
                map.put(cur, i);
            }
        }
        res[0] = Math.min(a, b);
        res[1] = Math.max(a, b);
        return res;

    }
}
