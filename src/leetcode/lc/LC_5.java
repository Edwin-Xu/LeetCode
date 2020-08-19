package leetcode.lc;

/**
 * Created by Edwin Xu on 5/10/2020 1:20 AM
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 *
 *
 *
 *     x是回文-->yxy是回文
 *     反之：
 *     yxy是回文，x是回文，但是不适合找回文
 *
 *     必须是自底向上的
 *
 *
 *     思路1：
 *     遍历：找出以a[i]为中心的回文串长度，取最长的。
 *
 *
 */
public class LC_5 {
    /*
    * 思路1-中心扩展
    * 遍历：找出以a[i]为中心的回文串长度，取最长的。
    * 需要对奇数长度和偶数长度的回文串分别判断：
    *   奇数长度的回文串判断：从中间一位向两边展开，如abcbd,c向外展开即可得到最长回文子串
    *   偶数长度的回文串判断：将当前和下一个字符视为中间串，向外展开，如aabbcc,bb向外展开
    * 算法缺点：
    *   时间复杂度：最坏情况下(相同字符构成的串如aaaa),内层循环会向外判断到最近的边界，
    *   2*(1+2+3+···+n/2+···+3+2+1)
    *   = 2*[2*(((n-1)/2)*((n+1)/2)/2)+n/2]
    *   = (n^2+2n-1)/2
    *   => O(n^2)
    *
    *   时间上击败90%的用户
    * 为了避免计算偶数的回文串，可以填充特殊字符，使任意相邻两个字符不同。
    * */
    public String longestPalindrome(String s) {
        int len  = s.length();
        if(len<2)return s;
        char [] c = s.toCharArray();
        int begin = 0;//起始下标
        int max = 1;//回文串长度

        //注意：len-i-1>=max/2。表示如果余下为遍历的位数(len-i-1)不足max的一半时就
        // 断定不会有更长回文串。
        for(int i = 0;i<len&&len-i-1>=max/2;i++){
            //奇数长度回文串判断
            for(int j=1;i-j>=0 && i+j<len;j++){
                if(c[i-j]==c[i+j]){
                    if(2*j+1>max){
                        begin = i-j;
                        max = 2*j+1;
                    }
                }else break;
            }
            //偶数长度回文串判断：
            for(int j=0;i-j>=0&&i+j+1<len;j++){
                if(c[i-j]==c[i+j+1]){
                    if(2*j+2>max){
                        begin = i-j;
                        max = j*2+2;
                    }
                }else break;
            }
        }
        return s.substring(begin,max+begin);
    }

    /*
    思路2：
    中心扩展改进：
    为了避免计算偶数的回文串，可以填充特殊字符，使任意相邻两个字符不同。
    aaa--> ^a^a^a^

    结论：改进不好，为了将内循环复杂度减半，外循环加倍是不值得的
     */
    public String longestPalindrome_optimize(String s) {
        int len  = s.length();
        if(len<2)return s;
        char [] chars = s.toCharArray();
        Character [] c= new Character[2*len+1];
        for (int i = 0; i < len; i++) {
            c[i*2]='^';
            c[i*2+1]=chars[i];
        }
        c[2*len]='^';

        len = c.length;
        int begin = 0;//起始下标
        int max = 1;//回文串长度

        //注意：len-i-1>=max/2。表示如果余下为遍历的位数(len-i-1)不足max的一半时就
        // 断定不会有更长回文串。
        for(int i = 0;i<len&&len-i-1>=max/2;i++){
            for(int j=1;i-j>=0 && i+j<len;j++){
                if(c[i-j]==c[i+j]){
                    if(2*j+1>max){
                        begin = i-j;
                        max = 2*j+1;
                    }
                }else break;
            }
        }
        begin=(begin+1)/2;
        max = max/2;
        return s.substring(begin,max+begin);
    }


    /*
    * 最优解：马拉车算法
    * 本质是对中心扩展的改进
    *   中心扩展：
    *       - 没有利用已经知道的回文信息
    *       - 没有利用回文本身的对称性
    *   如何改进？
    *   例子：cabadabae
    *   第1位为中心：[c]abadabae
    *   第2位为中心：c[a]badabae
    *   第3位为中心：c[aba]dabae
    *   第4位为中心：由于我们知道以第3位为中心的信息[aba]，第4位和第2位是
    *    对称的，第二位为中心的回文没有超出[aba]，所以第4位和第2位一样。
    *   第5位为中心：c[abadaba]e
    *   第6位为中心：第5位a和第3位a关于第4位对称，且以第三位为中心的回文没有
    *     超出以第5位中心的回文，故第为6位和第4位一样
    *     这里没有按部就班地以中心扩展判断，而是利用前面的信息，节省了步骤。
    *  那么马拉车就是按这个思路
    * */
    public String longestPalindrome_manacher(String s){
        int len  = s.length();
        if(len<2)return s;
        char [] chars = s.toCharArray();
        Character [] c= new Character[2*len+1];
        for (int i = 0; i < len; i++) {
            c[i*2]='^';
            c[i*2+1]=chars[i];
        }
        c[2*len]='^';

        return "";
    }

    /*
    * 生成一个数组，是对应字符串中心的回文半径，是算法的核心。
    * @param: 奇数位数字符串
    * */
    public void palindormeRedius(String s){
        char c[] = s.toCharArray();
        int len = s.length();
        int right = 0;//回文半径最右覆盖
        int middle = 0;//最右覆盖的回文中心点
        for (int i = 0; i < len; i++) {

        }
    }



    //动态规划




    public static void main(String[] args) {
        LC_5 lc5 = new LC_5();
        System.out.println(lc5.longestPalindrome("c"));
        System.out.println(lc5.longestPalindrome("ccc"));
        System.out.println(lc5.longestPalindrome("csc"));
        System.out.println(lc5.longestPalindrome("cxsxc"));
        System.out.println(lc5.longestPalindrome("cerxfxsxfxsddfvvvvvvvvvvvvc"));

        System.out.println(lc5.longestPalindrome("cc"));

        System.out.println(lc5.longestPalindrome_optimize("cxsxc"));
        System.out.println(lc5.longestPalindrome_optimize("babad"));
        System.out.println(lc5.longestPalindrome_optimize("ab"));
        System.out.println(lc5.longestPalindrome_optimize("bb"));


    }

}
