package datastructure.tree;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Edwin Xu on 4/11/2020 11:12 PM
 *
 * 二叉树的几种遍历
 * 前序 中序 后序
 * 迭代 递归
 */


public class BinaryTreeTraversals {
//https://www.cnblogs.com/bjwu/p/9284534.html
    //层序-迭代 ： 利用队列
    public void layerTraversal_iter(TreeNode root) {
        Queue<TreeNode> q= new LinkedBlockingQueue<>();
        TreeNode tmp ;
        q.add(root);
        while (q.size()>0){
            tmp = q.poll();
            System.out.print(tmp.val+" ");
            if (tmp.left!=null)q.add(tmp.left);
            if (tmp.right!=null)q.add(tmp.right);
        }
    }

    //层序-迭代 ： 利用数组
    public void layerTraversal_iter_arr(TreeNode root){
        TreeNode []treeNodes= new TreeNode[100];//缺点，显示声明大小，浪费?不足
        int in=0,out=0;
        treeNodes[in++]=root;
        while (in>out){
            if (treeNodes[out]!=null){
                System.out.print(treeNodes[out].val+" ");
                treeNodes[in++]=treeNodes[out].left;
                treeNodes[in++]=treeNodes[out].right;
            }
            out++;
        }
    }

    //中序-递归
    public void inorderTraversal_rec(TreeNode root) {
        if (root==null)return;
        inorderTraversal_rec(root.left);
        System.out.print(root.val+" ");
        inorderTraversal_rec(root.right);
    }
    //前序-递归
    public void prefixTraversal_rec(TreeNode root) {
        if (root==null)return;
        System.out.print(root.val+" ");
        prefixTraversal_rec(root.left);
        prefixTraversal_rec(root.right);
    }
    //后序-递归
    public void postfixTraversal_rec(TreeNode root) {
        if (root==null)return;
        postfixTraversal_rec(root.left);
        postfixTraversal_rec(root.right);
        System.out.print(root.val+" ");
    }

    //后序-迭代
    /*
    * 从根节点开始依次迭代，弹出栈顶元素输出到输出列表中，然后依次压入它的所有孩子节点，按照从上到下、从左至右的顺序依次压入栈中。

    因为深度优先搜索后序遍历的顺序是从下到上、从左至右，所以需要将输出列表逆序输出。
    */
    public void postorderTraversal_iter(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            if (root == null) return ;
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                System.out.print(node.val+" ");
                if (node.left != null) stack.add(node.left);
                if (node.right != null) stack.add(node.right);
            }
    }




    /*
    * 增加需求：
    *       3
           / \
          9  20
            /  \
           15   7
        返回其层次遍历结果：
        [
          [3],
          [9,20],
          [15,7]
        ]

    如何控制层数？？？
    利用两个队列，交替使用，于是就能把层次区分开来。
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();//结构

        LinkedList<TreeNode> q1 = new LinkedList<>();//Q1
        LinkedList<TreeNode> q2 = new LinkedList<>();//Q2
        LinkedList<TreeNode> cur,empty;//引用，分别指向当前使用的队列和空队列
        TreeNode tmp;
        if (root!=null)q1.add(root); //先把root加入Q1
        while (!q1.isEmpty() || !q2.isEmpty()){//至少一个队列不为空
            List<Integer> level = new LinkedList<>();
            if (q1.isEmpty()){ //使cur指向正在使用的队列，empty指向即将用于存储的空队列
                cur = q2;
                empty = q1;
            }else{
                cur = q1;
                empty= q2;
            }
            while (!cur.isEmpty()){//当前队列不为空，取出所有元素，把元素的非null子节点放到empty队列
                tmp = cur.pop();
                level.add(tmp.val);
                if (tmp.left!=null)empty.add(tmp.left);
                if (tmp.right!=null)empty.add(tmp.right);
            }
            res.add(level);
        }
        return res;
    }

    public List<List<Integer>> levelOrder_boundary(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();//辅助队列
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);//分界节点

        List<List<Integer>> res = new LinkedList<>();//result
        List<Integer> level =new LinkedList<>();//层元素数组
        TreeNode tmp;//临时节点

        if (root==null)return res;
        q.add(root);
        q.add(dummy);//第一层和第二层之间的分界节点
        while (!q.isEmpty()){
            tmp = q.pop();
            if (tmp==dummy){//遇到分界节点，表示已经遍历完一层了
                res.add(level);
                level = new LinkedList<>();//下一层的存放数组
                if(!q.isEmpty()) q.add(dummy);//dummy只有在队列不为空的情况下入队，保证程序正常退出
            }else{//非分界节点
                level.add(tmp.val);
                if (tmp.left!=null)q.add(tmp.left);
                if (tmp.right!=null)q.add(tmp.right);
            }
        }
        return res;
    }







    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);


        BinaryTreeTraversals btt = new BinaryTreeTraversals();
        System.out.println("层序-迭代-队列：");
        btt.layerTraversal_iter(root);
        System.out.println("\n层序-迭代-数组：");
        btt.layerTraversal_iter_arr(root);
        System.out.println("\n中序-递归：");
        btt.inorderTraversal_rec(root);
        System.out.println("\n前序-递归：");
        btt.prefixTraversal_rec(root);
        System.out.println("\n后序-递归：");
        btt.postfixTraversal_rec(root);
        System.out.println("\n后序-迭代：");
        btt.postorderTraversal_iter(root);

    }
}
