package leetcode.nowcoder.nc;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/18/2020 10:09 PM
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
public class NC_62 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return high(root)!=-1;
    }

    /*
    * 如果高度差出现不平衡，返回-1
    * */
    int high(TreeNode root) {
        if(root==null)return 0;
        int L = high(root.left);
        int R = high(root.right);
        if(L==-1|| R==-1 || Math.abs(L-R)>1)return -1;
        return Math.max(L,R)+1;
    }
}
