package leetcode.lc;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 12/20/2020 10:52 PM.
 *
 * 1081. 不同字符的最小子序列
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入："cdadabcc"
 * 输出："adbc"
 * 示例 2：
 *
 * 输入："abcd"
 * 输出："abcd"
 * 示例 3：
 *
 * 输入："ecbacba"
 * 输出："eacb"
 * 示例 4：
 *
 * 输入："leetcode"
 * 输出："letcod"
 */

public class LC_1081 {
    /**
     从前往后，一个一个删，对于字符c，如果前面出现过了c，那么
     现在需要选择删除一个，通过字典序比较决定选择哪个删除。
     */
    public String smallestSubsequence(String s) {
        if(s==null){
            return "";
        }
        char[] chs = s.toCharArray();
        int len = s.length();
        Map<Character,Integer> map = new HashMap<>(len/2);
        for(int i = 0;i<len;i++){
            char c = chs[i];
            // 包含c，说明之前遇到过c，设为c0, 现在需要选择一个删除
            if(map.containsKey(c)){
                /*
                * 不管删除那个，c0之前的是不会变的。
                * 取决于c0后的第一个字符 x
                * 如果ascii上：c0>=x => 删掉c0，否则删掉c
                *
                *
                * ----------?????----------
                * 出现问题了，这种局部最优的解法不会导致全局最优
                * eg: bcabc
                *
                * */
                System.out.println(c+" 重复了");
                int c0Index = map.get(c);

                int index = c0Index+1;
                char x = chs[index];
                while (x==0){
                    x = chs[++index];
                }
                if (x<=c){
                    chs[c0Index] = 0;
                    map.put(c,i);
                    System.out.println("del 前一个" );
                }else{
                    chs[i] = 0;
                    System.out.println("del 后一个" );
                }
                System.out.println(String.valueOf(chs,0,i+1));

            }else{
                //没有遇到过c,加入map
                map.put(c,i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: chs){
            if (ch!=0){
                sb.append(ch);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LC_1081 lc_1081 = new LC_1081();
        System.out.println(lc_1081.smallestSubsequence("bcabc"));
    }
}
