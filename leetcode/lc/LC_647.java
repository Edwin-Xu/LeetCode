package leetcode.lc;

import leetcode.util.Print;

import java.util.Arrays;

/**
 * Created by Edwin Xu on 8/19/2020 3:49 PM
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 *
 *
 * 分析：
 * 思路1：中心扩展，即对每位字符，都向两边扩展
 * 比较暴力，O(N2)
 * 奇偶数：1.分开计算，2.通过添加分隔符全部转换为奇数
 * aaa: a.a.a
 */
public class LC_647 {
    public int countSubstrings(String s) {
        //填充构造奇数位数串
        char [] chars = new char[s.length()*2-1];
        int i = 0;
        for (; i < s.length()-1; i++) {
            chars[i*2] = s.charAt(i);
            chars[i*2+1] = 0;
        }
        chars[i*2] = s.charAt(i);
        Arrays.asList(chars).forEach(System.out::print);
        int res = s.length();
        for (int j = 0; j < chars.length; j++) {
            //对每一个从中心扩展
            int L = j-1;
            int R = j+1;
            while (L>=0 && R<chars.length && chars[L]==chars[R]){
                if(chars[L]!=0) res++;
                L--;
                R++;
            }
        }
        return res;
    }

    /*
    * 改进版
    * 一样的思路，只不过是从逻辑上填充，构造奇数位数的串
    * 如果填充了*，从*扩展，本质上就是从*左右两边开始扩展
    * 上面是物理构造了一个填充后的奇数位数字符串，把物理转换Wie逻辑的即可
    * */
    public int countSubstrings_better(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2;
            int r = i / 2 + i % 2;  //如果是填充位*，i应当是奇数，i%2=1,即从*左右两个开始扩展
            Print.print(i,l,r);
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }


    /*
    * 马拉车算法
    * */
    public int countSubstrings_manacher(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }


    public static void main(String[] args) {
        LC_647 l  = new LC_647();
        int res = l.countSubstrings("abc");
        System.out.println(res);
        l.countSubstrings_better("abc");
    }
}
