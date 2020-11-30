package leetcode.lc;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/30/2020 5:14 PM
 *
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 */
public class LC_110 {
    public boolean isBalanced(TreeNode root) {
        return balance(root)!=-1;
    }
    //返回高度，如果不平衡就返回-1
    public int balance(TreeNode root){
        if(root==null)return 0;
        int L = balance(root.left);
        int R = balance(root.right);
        if(L==-1 || R==-1 || Math.abs(L-R)>1)return -1;
        return 1+Math.max(L,R);
    }
}
