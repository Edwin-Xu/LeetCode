package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 11/18/2020 11:04 PM.
 *
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *
 */

public class LC_938 {
    /**
     *全遍历
     */
    public int rangeSumBSTUsingAllTraversal(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        int subTree = rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
        return (root.val > high || root.val<low)?subTree: root.val+subTree;
    }

    /**
     *优化：
     *
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        if(root.val < low){
            return rangeSumBST(root.right,low,high);
        }
        if(root.val > high){
            return rangeSumBST(root.left,low,high);
        }
        return root.val+ rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}
