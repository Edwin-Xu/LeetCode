package leetcode.interview.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 8/20/2020 4:30 PM
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 */
public class Offer_50 {
    /*
    * 我的解法：
    * 借助于HashMap
    * 遍历加入map： char,integer 即<字符，最后出现的下标>
    *  第二次遍历，如果发现当前下标=value ，即后面没有重复字符
    *
    *  天才
    *
    *  不对啊，遍历到最后一个时，就出现问题了
    *
    *  借助map效率有点差
    * */
    public char firstUniqChar_hahsmap(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i),i); //不能直接覆盖，避免最后一个不好判断
            //如果出现过了，就设为0
            char c = s.charAt(i);
            if (map.containsKey(c))map.put(c,-1);
            else map.put(c,i);
        }
        for (int i = 0; i < s.length(); i++) { //这里可以直接遍历hashmap，也许更高效
            if ( map.get(s.charAt(i))==i)return s.charAt(i);
        }
        return 0;
    }

    /*
    * 有序hashmap
    * */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

}
