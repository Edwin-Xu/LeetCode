package leetcode.interview.inte;

/**
 * Created by Edwin Xu on 6/3/2020 12:38 AM
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 分析：
 * 1. 额外开空间，一个一个放进去
 * 2. 只开必要的空间：
 *    1.遍历，遇到空格，末尾加两个空格。
 *    2.从原来的尾部开始，如果
 *          1.是空，后面补上%20
 *          2.不是空，把字符搬过去
 *
 */
public class Int_05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (char i: s.toCharArray()){
            if (i==32)sb.append("..");
        }
        int p1 = sb.length()-1;
        System.out.println(p1);
        int p2 = s.length()-1;
        while (p2>=0&&p1>=0){
            char c =sb.charAt(p2--);
            if (c==32){
                sb.setCharAt(p1--,'0');
                sb.setCharAt(p1--,'2');
                sb.setCharAt(p1--,'%');
            }else sb.setCharAt(p1--,c);
        }
        return sb.toString();

    }
    public  void f(int s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        Int_05 i = new Int_05();
        System.out.println(i.replaceSpace("a b c"));

//        int x = 0;
//        i.f(x++);
//        System.out.println(x);
//        i.f(--x);
//        System.out.println(x);
    }
}
