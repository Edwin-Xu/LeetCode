package leetcode.nowcoder.nc;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 8/30/2020 1:54 PM
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class NC_72 {
    public void Mirror(TreeNode root) {
        if(root==null)return;
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
