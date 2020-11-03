package leetcode.interview.offer;

import java.util.*;

/**
 * Created by Edwin Xu on 11/2/2020 3:07 PM.
 *
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 */

public class Offer_46 {
        /*
    动态规划

    分为递归写法和迭代写法
    递归的话：从后向前
    迭代：从前往后

    dp[i]：i结尾的数字翻译种数
    dp[i] = dp[i-1] + ?dp[i-2]


    */

    /*
    这种写法的好处：不只是int，传一个String类型的大数也可以
    */
    public int translateNum_edw(int num) {
        String str = String.valueOf(num);
        int len = str.length();

        int dp [] = new int[len];
        dp[0] = 1;
        for(int i = 1 ;i <len; i++){
            //计算当前这个数和前一个构成的数
            int n = (str.charAt(i-1)-'0')*10+(str.charAt(i)-'0');
            //如果该数十位不为0,即06这种不算，且小于26
            if(n<26 && n>9){
                //dp[i-1]始终需要，另外第二位比较特殊，需要+1，如果>=2则加上dp[i-2]，否则是0
                dp[i] = dp[i-1] + ((i==1)?1: (i>1 ? dp[i-2]:0));
            }else{
                //和前面dp[i-1]一致
                dp[i] = dp[i-1];
            }
        }
        return dp[len-1];
    }




    //迭代写法2：
    public int translateNum_iter(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }




    //递归写法：
    public int translateNum(int num) {
        if(num<10)return 1;
        if(num%100 >=10 && num%100<=25)return translateNum(num/10)+translateNum(num/100);
        return translateNum(num/10);
    }
}
