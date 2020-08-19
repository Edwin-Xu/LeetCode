package leetcode.lc;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 5/19/2020 6:09 PM
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
public class LC_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null)return 0;
        if (root.left==null)return sumOfLeftLeaves(root.right);//左节点为空
        else if (root.left.left==null&& root.left.right==null)return root.left.val+sumOfLeftLeaves(root.right);//左节点不为空，判断左节点是不是叶节点
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        System.out.println(new LC_404().sumOfLeftLeaves(ConstructTree.construct("1,2,3")));
    }
}
