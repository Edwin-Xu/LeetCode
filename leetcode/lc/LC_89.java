package leetcode.lc;


import leetcode.util.Print;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author EdwinXu
 * <p>
 * 89. 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * <p>
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * <p>
 * 格雷编码序列必须以 0 开头。
 */
public class LC_89 {

    /**
     * 这种方法不好，且有问题
     */
    public List<Integer> grayCodeEDW(int n) {
        int cap = 1 << n;
        System.out.println(cap);
        List<Integer> res = new ArrayList<>(cap);
        // 用来验证唯一性
        Set<Integer> set = new HashSet<>(cap);
        res.add(0);
        set.add(0);
        for (int i = 0; i < cap - 1; i++) {
            // 取前一个数
            int prev = res.get(i);

            // 然后从低位到高位，一位一位地改，直到找到第一个不是未出现的为止
            for (int j = 0; j < n; j++) {
                // 当前这个数，先取prev
                int now = prev;

                // 如果prev的第j位是0
                if ((prev & (1 << j)) == 0) {
                    // 把第j位变为1
                    now |= (1 << j);
                } else {
                    // 第j位是1：变为0
                    now >>= (j + 1);
                    now <<= (j + 1);
                    now |= ((1 << j) - 1);
                }
                if (!set.contains(now)) {
                    set.add(now);
                    res.add(now);
                    break;
                }
            }
        }
        return res;
    }


    /**
     * 镜像反射法
     * <p>
     * <p>
     * 设 nn 阶格雷码集合为 G(n)G(n)，则 G(n+1)G(n+1) 阶格雷码为：
     * 给 G(n)G(n) 阶格雷码每个元素二进制形式前面添加 00，得到 G'(n)G
     * ′
     * (n)；
     * 设 G(n)G(n) 集合倒序（镜像）为 R(n)R(n)，给 R(n)R(n) 每个元素二进制形式前面添加 11，得到 R'(n)R
     * ′
     * (n)；
     * G(n+1) = G'(n) ∪ R'(n)G(n+1)=G
     * ′
     * (n)∪R
     * ′
     * (n) 拼接两个集合即可得到下一阶格雷码。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> grayCodeByMirro(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }


    /**
     * https://leetcode-cn.com/problems/gray-code/solution/c5xing-dai-ma-xiang-xi-jie-xi-dui-xin-sh-xrkw/
     * 原理法
     * 格雷编码如何形成：
     * 公式为 i ^ (i >> 1)
     * <p>
     * 磁盘如果不用格雷编码的话，假设它发生误差，比如最上端的 000 与 111，它所产生的误差是难以接受的，因为数值相差较大。假设我们使用的是格雷编码对磁盘进行读取，因为最多只会有一位数字的误差，所以它可以有效地提高数据的正确性！
     */

    public List<Integer> grayCode(int n) {
        int cap = 1 << n;
        List<Integer> res = new ArrayList<Integer>(cap);
        for (int i = 0; i < cap; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }


    public static void main(String[] args) {
        LC_89 lc89 = new LC_89();
        List<Integer> list = lc89.grayCode(3);
        Print.printList(list);


        System.out.println(getBin(6^(6>>1)));
        System.out.println(getBin(7^(7>>1)));


    }


    public static String getBin(int n) {
        String s = "";
        for (int i = 31; i >= 0; i--) {
            s += ((n >> i) & 1);
        }
        return s;
    }

}
