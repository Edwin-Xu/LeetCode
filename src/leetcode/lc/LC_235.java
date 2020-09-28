package leetcode.lc;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/27/2020 12:59 PM
 * <p>
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class LC_235 {
    /*
当做普通树：
*/
    public TreeNode lowestCommonAncestor_edwinxu(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root; //如果root是其中一个，直接返回

        //递归找出左右的节点
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);

        //如果左右都不是null，则表示当前节点是父节点
        if (L != null && R != null) return root;
        //否则，父节点在其中一个子树中
        return L == null ? R : L;
    }

    /*
    利用BST的特点：做二分
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //默认root是祖先节点
        TreeNode ancestor = root;
        while (true) {
            //如果祖先节点比PQ都大，那么祖先更新为左节点
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            }
            //如果祖先节点比PQ都小，那么祖先更新为右节点
            else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            }
            //如果祖先介于PQ之间(P<= root<= Q)，它就是最近公共父节点
            else {
                break;
            }
        }
        return ancestor;
    }
}
