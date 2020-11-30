package leetcode.nowcoder.nc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 8/25/2020 11:22 PM
 * 题目描述
 * 实现函数 int sqrt(int x).
 * 计算并返回x的平方根
 */
public class NC_32 {
    public int sqrt(int x) {
        // write code here
        //遍历、二分、迭代法
        if (x == 0 || x == 1) return x;
        int l = 1, h = x / 2;
        while (l < h) {
            int mid = (l + h) / 2;

            long mul = mid * mid;
            long m2 = (mid + 1) * (mid + 1);
            if (mul <= x && m2 > x) {
                return mid;
            } else if (mul < x) {
                l = mid;
            } else {
                h = mid;
            }
        }
        return l;
    }

    //上面还是超时

    //使用牛顿迭代法

    public int sqrt2(int m) {
        //f(x) = x2-m
        //经过 (x,x2-m)一点
        //该点斜率2x
        //切线f(y) = 2x*y+x2-2x-m
        //切线零点：(m+2x-x2)/2x
        //新的x得到

        double x = m;
        for (int i = 0; i < 100; i++) {
//            x = (m + x * 2 + 0.0) / (2 * x);
            x = x - ((x*x -m)/(2*x));
        }
        return (int) x;
    }


    public static void main(String[] args) {
        NC_32 n = new NC_32();
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * 1000000);
            Print.print(x, n.sqrt2(x), Math.sqrt(x));
        }

    }
}
