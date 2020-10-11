package leetcode.lc;

import leetcode.util.Print;
import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/10/2020 9:45 PM.
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

public class LC_95 {

    /*
    * 我的总体思路OK
    * 有些小问题还没有解决好
    *
    * */

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return buildTree(1, n);
    }

    private List<TreeNode> buildTree(int left, int right) {
        List<TreeNode> res = new LinkedList<>();
        if (left > right) {
            res.add(null); //这里也是必要的
            return res;
        }
        if (left == right) {
            res.add(new TreeNode(left));
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = buildTree(left, i - 1);
            List<TreeNode> rightList = buildTree(i + 1, right);
            // 这里是组合，不是对齐
            // int max = Math.max(leftList.size(),rightList.size());
            // for(int j = 0;j<max;j++){
            //     TreeNode root = new TreeNode(i);
            //     root.left = j<leftList.size()?leftList.get(j):null;
            //     root.right = j<rightList.size()?rightList.get(j):null;
            //     res.add(root);
            // }
            for (TreeNode L : leftList) {
                for (TreeNode R : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = L;
                    root.right = R;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_95 lc_95 = new LC_95();
        List<TreeNode> res = lc_95.generateTrees(3);
        Print.print(res.size());
        for (TreeNode root : res) {
            Print.layerTraversal(root);
            System.out.println();
        }
    }
}

/*
[[1,null,2,null,3,null,4],[1,null,2,null,4,3],[1,null,3,2,4],[1,null,4,2,null,null,3],[1,null,4,3,null,2],[2,1,3,null,null,null,4],[2,null,4,3],[3,1,4,null,2],[3,2,null,1],[4,1,null,null,2,null,3],[4,1,null,null,3,2],[4,2,null,1,3],[4,3,null,1,null,null,2],[4,3,null,2,null,1]]
[[1,null,2,null,3,null,4],[1,null,2,null,4,3],[1,null,3,2,4],[1,null,4,2,null,null,3],[1,null,4,3,null,2],[2,1,3,null,null,null,4],[2,1,4,null,null,3],[3,1,4,null,2],[3,2,4,1],[4,1,null,null,2,null,3],[4,1,null,null,3,2],[4,2,null,1,3],[4,3,null,1,null,null,2],[4,3,null,2,null,1]]



*
* */