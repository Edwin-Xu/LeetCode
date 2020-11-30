package leetcode.lc;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 11/22/2020 8:11 PM.
 *
 *
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

public class LC_242 {
    /**
     * 最简单的：HashMap
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * 效率很差
    * */
    public boolean isAnagramByMap(String s, String t) {
        if (s==null || t==null) {
            return false;
        }
        if (s.length()!=t.length()) {
            return false;
        }
        return compareMaps(getCharCountMap(s),getCharCountMap(t));
    }
    private HashMap<Character,Integer> getCharCountMap(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,0);
            }
        }
        return map;
    }
    private boolean compareMaps(HashMap<Character,Integer> map1, HashMap<Character,Integer> map2){
        if (map1== null || map2==null){
            return false;
        }
        if (map1.size()!=map2.size()){
            return false;
        }
        for (Map.Entry<Character,Integer> entry: map1.entrySet()){
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }




    /**
    * 优化： 直接使用数组
     * 时间复杂度：O(N)
     * 更加直接简单
    * */
    public boolean isAnagramByArr(String s, String t) {
        if (s==null || t==null) {
            return false;
        }
        if (s.length()!=t.length()) {
            return false;
        }
        int[] countArr1 = new int[26];
        int[] countArr2 = new int[26];
        for (int i = 0; i <s.length() ; i++) {
            countArr1[s.charAt(i)-'a']++;
            countArr2[t.charAt(i)-'a']++;
        }
        for (int i = 0; i <countArr1.length ; i++) {
            if (countArr1[i]!=countArr2[i]){
                return false;
            }
        }
        return true;
    }


    /**
     * 排序:
     * 时间复杂度: O(NlogN)
     * */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        Arrays.sort(chs1);
        Arrays.sort(chs2);
        for (int i = 0; i <chs1.length ; i++) {
            if (chs1[i]!=chs2[i]){
                return false;
            }
        }
        return true;
    }

}








