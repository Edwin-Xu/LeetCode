package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 9/28/2020 1:35 PM
 *
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class Offer_66 {
    // O(N^2)
    public int[] constructArr_edwinxu(int[] a) {
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            int sum = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) sum *= a[j];
            }
            arr[i] = sum;
        }
        return arr;
    }

    //前缀积+后缀积
    public int[] constructArr_pre_post_mul(int[] a) {
        int len = a.length;
        int res[] = new int[len];
        if (len == 0) return res;

        //前缀积:preMul[i] = 0~i-1的积
        int preMul[] = new int[len];
        preMul[0] = a[0];
        for (int i = 1; i < len; i++) {
            preMul[i] = preMul[i - 1] * a[i];
        }
        //后缀积:postMul[i] = i+1~n-1的积
        int postMul[] = new int[len];
        postMul[len - 1] = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            postMul[i] = postMul[i + 1] * a[i];
        }

        //返回结果
        res[0] = postMul[1];
        for (int i = 1; i < len - 1; i++) {
            res[i] = preMul[i - 1] * postMul[i + 1];//前后缀之积
        }
        res[len - 1] = preMul[len - 2];

        return res;
    }



    //优化：上面前缀积和后缀积是 对称的，可以浓缩为一个数组
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
