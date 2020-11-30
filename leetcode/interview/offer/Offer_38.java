package leetcode.interview.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 8/28/2020 11:59 PM
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 */
public class Offer_38 {
    private  HashSet<String> set = new HashSet<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();

        prem(chars,0,chars.length-1);
        String[] res = new String[set.size()];
        int index = 0;
        for (String str:set)res[index++]=str;
        return res;
    }

    private void prem(char[] chars, int start, int end) {
        if (start==end){
            set.add( String.valueOf(chars));
            return;
        }
        for (int i= start;i<=end;i++){
            swap(chars,i,start);
            prem(chars,start+1,end);
            swap(chars,i,start);
        }
    }
    private void swap(char [] chars, int i,int j){
        char tmp =chars[i];
        chars[i] =chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        Offer_38 offer_38 = new Offer_38();
        for (String s: offer_38.permutation("abc")) System.out.println(s);
    }



    class Solution {
        List<String> res = new LinkedList<>();
        char[] c;
        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }
        void dfs(int x) {
            if(x == c.length - 1) {
                res.add(String.valueOf(c)); // 添加排列方案
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for(int i = x; i < c.length; i++) {
                if(set.contains(c[i])) continue; // 重复，因此剪枝
                set.add(c[i]);
                swap(i, x); // 交换，将 c[i] 固定在第 x 位
                dfs(x + 1); // 开启固定第 x + 1 位字符
                swap(i, x); // 恢复交换
            }
        }
        void swap(int a, int b) {
            char tmp = c[a];
            c[a] = c[b];
            c[b] = tmp;
        }
    }

}
