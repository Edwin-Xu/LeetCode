package company.qunaer;

import leetcode.util.Print;

import java.util.Scanner;

/*
* 每周二是去哪儿网集体过需求Final Review的时候，针对机票的报价排序，运营
* 总监小天和产品总监老冯产生了一些不同意见，小天认为报价顺序应该是按照 a、f、
* d、e、z的顺序来做报价列表排序，老冯认为应该按照f、a、e、d、z的顺序来做列表排
* 序，两人争执不下，技术总监这时站了出来，认为他们其实大多数意见是一致的，只有少
* 数不一致，可以先把意见一致的排序作为一期做上去，有争议的后续再来做，那么如果一
* 期本着把小天和老冯报价顺序意见一致的报价先做上去，那么最多可以做上去多少个报价的排序。



本题本质： 最长公共子序列(不要求连续)

考虑最泛化的情况：
    - 不要求连续
    - 两个序列不要求长度相同
    - 每个序列中可以有重复

动态规划可解答

对于序列A、B：
使用dp[i][j]表示A的前i和B的前j个序列的最长公共序列。

dp[i][j]看dp[i][j-1]:
    对于B[j]，是否出现在A[i]中：从后往前到达最后一个匹配的子序列中。
    看来还需要记录 dp[i][j]匹配中A的最后一个匹配小标，以及已经匹配的个数

LC_1143即是本类型题


 * */
public class Main2 {

    public int maxPublicSubSequence(char[] A, char [] B){
        int dp[][][] = new int[A.length][B.length][2];
        for (int i = 0; i < A.length; i++) {
            char char_a = A[i];
            for (int j = 0; j <B.length ; j++) {

            }
        }


        return 0;

    }

    public static void main(String[] args) {
        new Main2();
    }
}

/*

a b c d e f g
b d a c f g e

* */