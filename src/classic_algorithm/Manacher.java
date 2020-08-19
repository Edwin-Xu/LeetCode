package classic_algorithm;

/**
 * manacher's algorithm
 * 马拉车算法
 * 寻找字符串的最长回文子串
 * 线性时间复杂度：O(N)
 *
 * 给出
 *
 */
public class Manacher {


    public static void main(String[] args) {
        int a =0,b=1,c=2;
        a+=b+=c;  // a += (b+=c)
        System.out.println(a+" "+b+" "+c);
    }
}
