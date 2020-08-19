package leetcode.lc;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 5/18/2020 6:50 PM
 *
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 */
public class LC_104 {
    public int maxDepth(TreeNode root) {
        return max(root,0);
    }
    private int max(TreeNode root, int depth){
        if (root==null)return depth;
        return Math.max(max(root.left,depth+1),max(root.right,depth+1));
    }




    /*
    *
    * 树的最小深度：
    * 注意单边的这种树：
    * 如  1
    *   2
    * 3
    * 深度不是1，而是三
    * 所以递归是需要分类讨论：
    *   子节点有位空的时，只递归不是空的一边
    * */
    public int minDepth(TreeNode root) {
        return min(root,0);
    }
    private int min(TreeNode root, int depth){
        if (root==null||(root.left==null&&root.right==null))return depth+1;
        if (root.left!=null && root.right!=null){
            return Math.min(min(root.left,depth+1),min(root.right,depth+1));
        }else if (root.left==null){
            return min(root.right,depth+1);
        }
        else return min(root.left,depth+1);
    }

    public static void main(String[] args) {
        System.out.println(new LC_104().minDepth(ConstructTree.construct("1,2,null")));
    }
}
