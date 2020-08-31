package leetcode.lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 567. 字符串的排列
 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

 换句话说，第一个字符串的排列之一是第二个字符串的子串。

 示例1:

 输入: s1 = "ab" s2 = "eidbaooo"
 输出: True
 解释: s2 包含 s1 的排列之一 ("ba").

 */

public class LC_567 {
    /*
    * 这个全部找出排列会超时！！！
    * */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length() )return false;
        char[] chars = s1.toCharArray();
        return prem(chars,0,chars.length-1,s2);
    }
    private boolean prem(char[] chars, int start, int end,String s2) {
        if (start==end){
            String s =  String.valueOf(chars);
            if (s2.contains(s))return true;
        }
        for (int i= start;i<=end;i++){
            swap(chars,i,start);
            boolean tmp = prem(chars,start+1,end,s2);
            if (tmp)return true;
            swap(chars,i,start);
        }
        return false;
    }
    private void swap(char [] chars, int i,int j){
        char tmp =chars[i];
        chars[i] =chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        LC_567 lc_567 = new LC_567();
        boolean res =   lc_567.checkInclusion("ab","sdsdabsdsddsd");
        System.out.println(res);
    }


}
