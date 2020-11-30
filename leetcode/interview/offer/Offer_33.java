package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 9/30/2020 7:56 PM
 * <p>
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 */
public class Offer_33 {
    //基本一次过，牛逼
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    /*
    对于i~j之间：
        取最后一个元素X作为根节点
        i~j-1是子节点：
            尝试将i~j-1划分为两堆。
            - 划分满足：前半部分<X，后半部分>X. 递归判断前后部分
            - 如果不满足 前<X<后，返回false
    */
    private boolean verify(int[] arr, int i, int j) {
        if (i >= j) return true;
        int root = arr[j];//根节点
        int midIndex = i; //后半部分第一个
        for (; midIndex < j; midIndex++) {
            if (arr[midIndex] > root) break;
        }
        //如果后半部分还有<根节点的，返回false
        for (int k = midIndex; k < j; k++) {
            if (arr[k] <= root) return false;
        }

        //分组是合法的。
        //递归判断子序列是否合法
        return verify(arr, i, midIndex - 1) && verify(arr, midIndex, j - 1);
    }


 /*
 其他写法：
     public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }


 */
}
