package leetcode.interview.offer;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 9/28/2020 9:48 PM
 * <p>
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * <p>
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Offer_34 {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        dfs(root, sum, new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            //到达叶节点
            if (sum == 0) {
                res.add(new LinkedList<>(list));
            }
        } else {//分支节点
            dfs(root.left, sum, list);
            dfs(root.right, sum, list);
        }
        list.removeLast();//需要回溯
    }


}
