package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/12/2020 10:40 PM.
 *
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 */

public class LC_230 {
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    int res = 0;
    int cnt = 0;

    private void inOrder(TreeNode root, int k) {
        if (root == null) return;

        if (cnt >= k) {
            return;
        }

        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            res = root.val;
            return;
        }
        inOrder(root.right, k);

    }
}
