package leetcode.lc;

/**
 * Created by Edwin Xu on 6/20/2020 5:07 PM
 *
 * 38. 外观数列
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 *
 */
public class LC_38 {
    public String countAndSay(int n) {
        String cur = "1";
        for (int i = 1; i <n ; i++) {
            char c = cur.charAt(0);
            int count =0;
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<cur.length();j++){
                if (cur.charAt(j)!=c){
                    sb.append(String.valueOf(count)+String.valueOf(c));
                    count=1;
                    c = cur.charAt(j);
                }else{
                    count++;
                }
            }
            sb.append(String.valueOf(count)+String.valueOf(c));
            cur = sb.toString();
            System.out.println(cur);
        }
        return cur;
    }

    /*
    * 还可以使用递归的方式
    * */
    public static void main(String[] args) {
        new LC_38().countAndSay(1);
    }
}
