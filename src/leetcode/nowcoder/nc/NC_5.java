package leetcode.nowcoder.nc;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 8/24/2020 1:19 PM
 * <p>
 * 题目描述
 * 给定一个仅包含数字\ 0-9 0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是1\to 2\to 31→2→3,那么这条路径就用\ 123 123 来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 * 例如：
 * <p>
 * 这颗二叉树一共有两条路径，
 * 根节点到叶子节点的路径 1\to 21→2 用数字\ 12 12 代替
 * 根节点到叶子节点的路径 1\to 31→3 用数字\ 13 13 代替
 * 所以答案为\ 12+13=25 12+13=25
 * <p>
 * 输入
 * {1,#,5}
 * 输出
 * 15
 */
public class NC_5 {
    /*
     * 前序遍历
     * 回溯
     * */
    private int cur = 0;
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root != null) { //当前节点不为空
            cur = cur * 10 + root.val; //当前路径上的值加上去
            if (root.left == null && root.right == null) {
                sum += cur; //如果是叶节点，加到最终结果
            } else {//不是叶节点则继续遍历
                sumNumbers(root.left);
                sumNumbers(root.right);
            }
            cur /= 10; //回溯
            return sum;//返回
        } else {//当前节点为空，返回0
            return 0;
        }
    }

    /*
    *
    * 另一种写法：
    * int sumNumbers(TreeNode* root) {
        // write code here
        if(!root) return 0;
        int sum = 0;
        return preOrder(root, sum);
    }

    int preOrder(TreeNode *root, int sum) {
        if (!root) return 0;
        sum = 10 * sum + root->val;
        if (!root->left && !root->right) return sum;
        return preOrder(root->left, sum) + preOrder(root->right, sum);
    }
    * */

}
