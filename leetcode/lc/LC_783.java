package leetcode.lc;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/25/2020 11:11 AM
 */
public class LC_783 {

    /*
    这是 猿辅导 二面 面试题

    之前是使用 ：pre = Long.MIN_VALUE/2
    但是他说如果 第一个就是Long.MIN_VALUE/2
    于是我使用一个isFirst标志位


    //面试体验不好，面试官也是无语，对不上号，都没给反问，挂了

    */
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return (int)min;
    }

    private long min = Long.MAX_VALUE;
    private long pre = Long.MIN_VALUE/2;
    //boolean isFirst = true;

    public void inOrder(TreeNode root){
        if(root == null)return;
        inOrder(root.left);

        if(root.val-pre < min ){
            min = root.val - pre;
        }
        pre = root.val;
        //isFirst = false;

        inOrder(root.right);

    }


    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(b);

        System.out.println(10-a);
        System.out.println(10-(-2147483648));
        System.out.println(10+a);
    }
}
