package leetcode.interview.offer;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 6/20/2020 12:55 PM
 *
 * 剑指 Offer 55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class Offer_55 {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
