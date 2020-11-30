package leetcode.nowcoder.nc;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Edwin Xu on 8/31/2020 10:37 PM
 * 求给定的二叉树的前序遍历。
 */
public class NC_1 {
    public ArrayList<Integer> preorderTraversal_ (TreeNode root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        f(list,root);
        return list;
    }
    private void f(ArrayList<Integer> list,TreeNode root){
        if(root!=null){
            list.add(root.val);
            f(list,root.left);
            f(list,root.right);
        }
    }



    /*
    下面尝试迭代解法

    前序遍历，
    当前节点CUR指向根节点
    先把CUR打印，右节点入栈，CUR指向左节点
    */


    public ArrayList<Integer> preorderTraversal (TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root; //当前节点
        while(cur!=null){
            list.add(cur.val); //遍历当前节点
            if(cur.right!=null)stack.add(cur.right); //右节点入栈
            cur = cur.left; //当前节点左移到左节点
            if(cur==null){//左节点为空
                if(stack.isEmpty())break; //cur为空，而且栈里面都空了，结束
                cur = stack.pop(); //否则就从栈里面弹出一个，cur指向它继续
            }
        }
        return list;
    }
}
