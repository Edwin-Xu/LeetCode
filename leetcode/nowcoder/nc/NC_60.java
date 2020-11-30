package leetcode.nowcoder.nc;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Edwin Xu on 9/19/2020 12:46 PM
 * 判断一棵二叉树是否为搜索二叉树和完全二叉树
 * <p>
 * 题目描述
 * 给定一棵二叉树，已经其中没有重复值的节点，请判断该二叉树是否为搜索二叉树和完全二叉树。
 * 示例1
 * 输入
 * {2,1,3}
 * 输出
 * [true,true]
 *
 *
 *
 *
 *
 * 分为两种：
 *  - 判断是否是搜索二叉树
 *  - 判断是不是完全二叉树
 *
 */
public class NC_60 {
    public boolean[] judgeIt(TreeNode root) {
        boolean[] res = new boolean[2];
        res[0] = isBST(root);
        res[1] = wan(root);
        return res;
    }

    boolean isBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.val > root.val) return false;
        if (root.right != null && root.right.val < root.val) return false;
        return isBST(root.left) && isBST(root.right);
    }


    int pre = Integer.MIN_VALUE;
    private boolean sou(TreeNode root) {
        if (root == null) return true;
        if (!sou(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return sou(root.right);
    }

    boolean isCompleteBinaryTree(TreeNode root) {
        /*
         * 层序判断
         * 对于每一层：
         *  1. 判断是否还有子节点
         *  2. 判断是够有空节点
         *  3. 判断空节点是不是在最后
         * */

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int layerCnt = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.getFirst();

                queue.add(node.left);
                queue.add(node.right);
            }

            layerCnt <<= 1;


        }
        return false;
    }

    private boolean wan(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            list.add(n);
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

        }
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) != list.get(i - 1) * 2) { // 这样不是慢二叉树的判断？
                return false;
            }
        }
        return true;
    }


}
