package leetcode.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Edwin Xu on 8/4/2020 4:07 PM
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */


/*
* 不要使用s.toCharArray()
* 里面采用的是从新开辟空间，复制字符的方式。时间和空间复杂度都是O(N)
*
* */
public class LC_3 {
    public int lengthOfLongestSubstring_mine(String s) {
        /*
        * 采用双指针结合set集合
        *  左指针指向左边一个，向右滑动，同时加入set中：
        *    如果右指针指向出现过的字符：计算当前长度，左指针胡奥东到第一个不和当前元素相同的地方，同时移除set中元素
        *    否则继续有滑动
        * */
        if (s.length()==0)return 0;
        if (s.length()<2)return 1;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left=0;
        int right=1;
        set.add(s.charAt(left));
        while (left<right && right<s.length()){
            System.out.println(left+"-"+right);
            if (set.contains(s.charAt(right))){
                //已经访问过了
                max = Math.max(max,right++-left);//求最大值，
                //考虑到left最多可能走到当前right的位置，right往右边移动一位，保持差为1
                while (left<right && set.contains(s.charAt(right-1))){
                   set.remove(s.charAt(left++));//移除，直到不包含这个重复位
                }
                set.add(s.charAt(right-1));//上面把这个重复位去掉了，这里再加上。
            }else{
                set.add(s.charAt(right++));
            }
        }
        max = Math.max(max,right-left);
        return max;
    }
    /*
    * 举例：pwwkew
    * L=0 R=1
    * R++ --> R=2 发现重复，此时set=p,w  max = 2
    * L++ set移除，直到不包含重复字符w
    * 此时L=2,R=3
    * 重新循环：
    * R++ --》R=5发现再次重复 -----max=5-2=3
    *
    * R++ 越界，结束
    * 结果3
    * */



//    更容易理解的做法
    /*
    *
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        occ = set()
        n = len(s)
        right, ans = 0, 0
        for left in range(n):
            while right < n and s[right] not in occ:
                occ.add(s[right])
                right += 1
            if len(occ) > ans:
                ans = len(occ)
            occ.remove(s[left])
        return ans


        嗯这个算法思路: 还是利用双指针/滑动窗口+Set
        从左往右遍历--Left
            从Left往右直到重复：Right
            然后从Set移除Left，循环
            （和我的区别在于移除时：我是Left不断往右移除，直到把这个重复的去掉）
    * */


    /*
    * 思考：HashSet基于HashMap，是否可以利用HashMap
    * 再思考：第二层循环是Left不断往右移动，直到Set中去除这个重复的字符，那么是否可以不循环，利用已经存在的数据
    * 这时利用HashMap的value来存储就好办了
    * */
/*
* 标签：滑动窗口
暴力解法时间复杂度较高，会达到 O(n^2)O(n 2 )，故而采取滑动窗口的方法降低时间复杂度
定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
我们定义不重复子串的开始位置为 start，结束位置为 end
随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
无论是否更新 start，都会更新其 map 数据结构和结果 ans。
时间复杂度：O(n)O(n)
* */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC_3 lc_3 = new LC_3();
        System.out.println(lc_3.lengthOfLongestSubstring("pwwkew"));
    }
}
