package leetcode.nowcoder.nc;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/11/2020 11:15 PM
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
 * 中，按结点数值大小顺序第三小结点的值为4。
 *
 *
 * 利用前序遍历
 */
public class NC_81 {
    int cnt = 0;
    TreeNode res = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
        pre(pRoot, k);
        return res;
    }

    private void pre(TreeNode root, int k) {
        if (root == null) return;
        if (cnt>k)return;
        pre(root.left, k);
        cnt++;

//        System.out.println(cnt+" "+root.val);
        if (cnt==k){
            res = root;
        }

        pre(root.right, k);
    }


    public static void main(String[] args) {
        NC_81 nc_81 = new NC_81();
        TreeNode res = nc_81.KthNode(ConstructTree.construct("2,1,3"), 2);
        if (res != null) System.out.println(res.val);
    }


}
