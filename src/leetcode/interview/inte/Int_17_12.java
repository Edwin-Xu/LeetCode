package leetcode.interview.inte;

import leetcode.util.ConstructTree;
import leetcode.util.Print;
import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/12/2020 2:02 PM.
 * <p>
 * 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 */

public class Int_17_12 {
    /*
   递归
   中序遍历
   记录前一个pre，然后把前一个的right指向当前节点，更新pre

   注意最后一个节点需要处理，不然出现环。
   不对，不是最后一个节点的问题

   为什么一些用例会出现死循环
   */
    public TreeNode convertBiNode(TreeNode root) {
        inOrder(root);
        return res;
    }

    TreeNode pre = null;
    TreeNode res = null;

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);

        if (pre != null) {
            //pre.left = null; >如果在这里置左节点null，会出现问题
            pre.right = root;
        } else {
            res = root;
        }
        pre = root;

        root.left = null; // >但是放在这里就不会出现问题

        inOrder(root.right);
    }

    public static void main(String[] args) {
        Int_17_12 int_17_12 = new Int_17_12();


        TreeNode root = ConstructTree.construct("4,2,5,1,3,null,6");
        Print.layerTraversal(root);
        System.out.println();
        Print.layerTraversal(int_17_12.convertBiNode(root));
    }

}
