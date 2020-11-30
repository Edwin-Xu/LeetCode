package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Edwin Xu on 9/23/2020 11:37 PM
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 */
public class LC_617 {
    /*
递归： 合并到第一个
对于两个对应的节点A、B：
    - 如果两个都为空：返回
    - 如果一个为空：返回
    - 如果都不为空：节点B值加到A
        - 看左节点：
            - 都为空：返回
            - 一个为空：如果是B的左


卧槽，居然直接写出来了，第一次就通过。
*/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;

        if (t1.left == null) t1.left = t2.left;
        else mergeTrees(t1.left, t2.left);

        if (t1.right == null) t1.right = t2.right;
        else mergeTrees(t1.right, t2.right);

        return t1;
    }


    /*
     * 官方题解-递归
     *
     * 思路更加简单
     * */
    public TreeNode mergeTrees_offical(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1; //有一个为空，就返回
        TreeNode merged = new TreeNode(t1.val + t2.val); // 新节点 或者原节点改动
        merged.left = mergeTrees_offical(t1.left, t2.left); //合并左子节点
        merged.right = mergeTrees_offical(t1.right, t2.right); //合并后的右子节点
        return merged;
    }

    /*
    * public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null) return t2;
        if(t2== null)return t1;
        t1.val +=t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
    * */


    /*
     * 官方-迭代  BFS
     * */
    public TreeNode mergeTrees_offical_iteration(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }


}
