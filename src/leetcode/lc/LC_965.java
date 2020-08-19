package leetcode.lc;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 6/20/2020 1:06 PM
 *
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 */
public class LC_965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root==null)return true;
        return isut(root.left,root.val)&&isut(root.right,root.val);
    }
    private boolean isut(TreeNode node,int value){
        if (node==null)return true;
        if (node.val!=value)return false;
        return isut(node.left,value)&&isut(node.right,value);
    }
}
