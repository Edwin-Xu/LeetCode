package leetcode.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Edwin Xu on 9/23/2020 2:02 PM
 *
 * 1207. 独一无二的出现次数
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 */
public class LC_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>(arr.length,1);
        for(int a: arr)map.merge(a,1,Integer::sum);
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            // System.out.println(e.getKey()+" "+ e.getValue());
            if(set.contains(e.getValue()))return false;
            set.add(e.getValue());
        }
        return true;
    }
}
