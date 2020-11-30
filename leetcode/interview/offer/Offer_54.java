package leetcode.interview.offer;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/27/2020 10:55 PM
 *
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 */
public class Offer_54 {

    public int kthLargest(TreeNode root, int k) {
        inOrder(root,k);
        return val;
    }
    int cnt=0; //计数
    int val = 0;//返回值
    public void inOrder(TreeNode root, int k){//中序
        if(root==null || cnt>k)return;
        inOrder(root.right,k); //先递归右边

        cnt++;
        if(cnt==k){
            val = root.val;
            return;
        }

        inOrder(root.left,k); //再递归左边
    }
}
