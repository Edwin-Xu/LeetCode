package leetcode.lc;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 5/18/2020 7:15 PM
 *
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上
 * 写出翻转二叉树这道题，这太糟糕了。
 *
 *
 *
 * analysis:
 * 思路1：层序遍历-->同层的镜像切换-->构建树
 *
 * 思路2：递归？？
 *
 *
 */
public class LC_226 {
    private  TreeNode root;
    public TreeNode invertTree(TreeNode root) {
        this.root =root;
        if (root==null || (root.left==null && root.right==null))return root;
        else if (root.left==null){
            root.left = root.right;
            root.right=null;
        }
        else if (root.right==null){
            root.right= root.left;
            root.left=null;
        }
        else{
            int t = root.left.val;
            root.left.val = root.right.val;
            root.right.val =t;
            invert(root.left,root.right);
        }
        return root;
    }
    private void invert(TreeNode t1,TreeNode t2){
        System.out.print("转换"+t1.val+" "+t2.val+"子节点前 : ");
        LC_226.tra(root);
        System.out.println();

        /*
        * 这里不交换t1\t2本身--因为交换不了
        * 所以交换子节点
        * */
        if (t1.left==null && t2.right!=null){
            t1.left= t2.right;
            t2.right  =null;
        }
         if (t1.left!=null && t2.right==null){
            t2.right=t1.left;
            t1.left=null;
        }
        if (t1.left!=null && t2.right!=null){
            TreeNode tmp = t1.left;
            t1.left = t2.right;
            t2.right = tmp;

            //把子节点换回来。
            tmp = t1.left.left;
            t1.left.left = t2.right.left;
            t2.right.left = tmp;

            tmp = t1.left.right;
            t1.left.right = t2.right.right;
            t2.right.right = tmp;

            invert(t1.left,t2.right);
        }



        if (t1.right==null && t2.left!=null){
            t1.right= t2.left;
            t2.left  =null;
        }
        if (t1.right!=null && t2.left==null){
            t2.left=t1.right;
            t1.right=null;
        }
        if (t1.right!=null && t2.left!=null){
            TreeNode tmp = t1.right;
            t1.right= t2.left;
            t2.left = tmp;

            //子节点的子节点不要交换，不然就错位了
            tmp = t2.left.left;
            t2.left.left = t1.right.left;
            t1.right.left = tmp;

            tmp = t2.left.right;
            t2.left.right = t1.right.right;
            t1.right.right = tmp;

            invert(t1.right,t2.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new LC_226().invertTree(ConstructTree.construct("2,3,null,1,null"));
        LC_226.tra(root);
    }

    private static void tra(TreeNode t){
        if (t!=null){
            System.out.print(t.val);
            tra(t.left);
            tra(t.right);
        }

    }

}
