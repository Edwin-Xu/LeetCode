package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/11/2020 12:09 AM.
 * <p>
 * 669. 修剪二叉搜索树
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 1
 * / \
 * 0   2
 * <p>
 * L = 1
 * R = 2
 * <p>
 * 输出:
 * 1
 * \
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * 3
 * / \
 * 0   4
 * \
 * 2
 * /
 * 1
 * <p>
 * L = 1
 * R = 3
 * <p>
 * 输出:
 * 3
 * /
 * 2
 * /
 * 1
 */



public class LC_669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null; //不符合条件

        int val = root.val;
        if (val < low) { //root.val < low 直接看右子树
            return trimBST(root.right, low, high);
        } else if (val > high) {  //root.val > low 直接看左子树
            return trimBST(root.left, low, high);
        } else { //L<= root.val <= R
            //如果左子树不为空 而且左子节点在区间外
            if (root.left != null && root.left.val < low) {
                root.left = root.left.right;//左子节点的右节点上升为左子节点(右子树会更大，需要再次判断)
                //继续递归
                trimBST(root, low, high);
            } else {
                //否则：递归左子树(因为只有左子树才可能跟小)
                trimBST(root.left, low, high);
            }

            //和上面左边的情况类似
            if (root.right != null && root.right.val > high) {
                root.right = root.right.left;
                trimBST(root, low, high);
            } else {
                trimBST(root.right, low, high);
            }

            return root;
        }
    }


    /*
    * 上面自己写的 没问题，逻辑相对比较复杂
    *
    * 简化版：
    *
    * */

    public TreeNode trimBST_offical(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

}
