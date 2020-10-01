package leetcode.lc;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/30/2020 12:26 PM
 *
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 *
 *
 * 例如,
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 */
public class LC_701 {
    //BST的插入
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)return new TreeNode(val);//空树插入

        TreeNode cur = root;
        while(cur!=null){
            if(cur.val>val){//插入点在左边
                if(cur.left==null){//左子树为空，到达插入点
                    cur.left = new TreeNode(val);
                    break;
                }else{//没有到达插入点
                    cur = cur.left;
                }
            }
            else { //插入右边
                if(cur.right==null){//右边为空，到达插入点
                    cur.right = new TreeNode(val);
                    break;
                }else{//还没有到达插入点
                    cur = cur.right;
                }
            }
        }
        return root;
    }



    //递归写法：
    public TreeNode insertIntoBST_recur(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST_recur(root.left, val);
        } else {
            root.right = insertIntoBST_recur(root.right, val);
        }
        return root;
    }
}
