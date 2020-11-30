package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by Edwin Xu on 5/17/2020 11:11 PM
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 分析：借助于层次序
 */
public class LC_101 {
//    傻逼解法：利用层序遍历，一层一层的回文检验，  请先想一想在写
    public boolean isSymmetric1(TreeNode root) {
        if (root==null)return true;
        LinkedList<TreeNode> s = new LinkedList<>();
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        s.add(root);
        s.add(dummy);
        TreeNode tmp;

        ArrayList<Integer> list = new ArrayList<>();
        while (!s.isEmpty()){
            tmp =  s.pop();
            if (tmp==dummy){
                if (list.isEmpty())return false;
                for (int k=0,m=list.size()-1;k<=m;k++,m--){
                    if (list.get(k)!=list.get(m))return false;
                }
                list.clear();
               if(!s.isEmpty())s.add(dummy);
            }else {
                if (tmp==null){
                    list.add(-100);
                }else {
                    list.add( tmp.val);
                    s.add(tmp.left);
                    s.add(tmp.right);
                }
            }
        }
        return true;
    }


    /*递归解决*/
    public boolean isSymmetric2(TreeNode root){
        return isMirror(root,root);
    }
    private boolean isMirror(TreeNode t1,TreeNode t2){
        if (t1==null&&t2==null)return true;
        else if (t1==null||t2==null)return false;
        else return t1.val==t2.val&& isMirror(t1.right,t2.left) && isMirror(t1.left,t2.right);
    }


    /*迭代解法*/
    public boolean isSymmetric(TreeNode root){
        if (root==null)return true;
        LinkedList<TreeNode> s = new LinkedList<>();
        s.add(root.left);
        s.add(root.right);
        TreeNode t1,t2;
        while (!s.isEmpty()){
            t1 = s.pop();
            t2 = s.pop();
            if(t1==null&&t2==null){}
            else if(t1==null||t2==null)return false;
            else {
                if (t1.val!=t2.val)return false;
                s.add(t1.right);
                s.add(t2.left);
                s.add(t1.left);
                s.add(t2.right);
            }

        }
        return true;
    }


    public boolean isSymmetric_standard(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(2);

        System.out.println( new LC_101().isSymmetric(root) );
    }

}
