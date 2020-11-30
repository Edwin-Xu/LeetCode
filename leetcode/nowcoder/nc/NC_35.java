package leetcode.nowcoder.nc;

/**
 * Created by Edwin Xu on 8/28/2020 10:18 AM
 *
 * 题目描述
 * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换**一个字符**的代价，
 * 请输出将str1编辑成str2的最小代价。
 * 示例1
 * 输入
 * "abc","adc",5,3,2
 * 输出
 * 2
 */
public class NC_35 {
    /**
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */

    /*
    * 早有耳闻，最小编辑代价，动态规划经典。今日相见，果然名不虚传！
    *
    * 这是编辑距离的改编
    *
    * 字符串长度可以不一样。
    *
    * 对某一位，有三种操作：
    * 1. 替换：改变某位的一个字符有2种选择：
    *    1. 删后
    *    2. 替换
    * 2. 可以直接删除，删除后后面的字符串向前一位可能正好对其
    * 3. 可以直接增加，可能导致后面的对其，
    *
    * 为了便于操作，使用StringBuilder
    * */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        StringBuilder sb = new StringBuilder(str1);





        return 0;
    }



}
