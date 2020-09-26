package leetcode.lc;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

import java.util.ArrayList;

/**
 * Created by Edwin Xu on 9/26/2020 2:35 PM
 *
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 */
public class LC_109 {
    //二分，基本一次过。
    //所以需要先分析好

    public TreeNode sortedListToBST(ListNode head) {
        //把链表用数组存放起来，以便可以定位到中间节点
        //如果不使用数组的话，需要每次都使用快慢指针去定位中间节点，时间复杂度大
        ArrayList<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        return buildTree(list,0,list.size()-1);
    }

    private TreeNode buildTree(ArrayList<ListNode> list,int i,int j){
        if(i>j)return null; //返回null
        int mid = (i+j)/2;//去中间节点作为i~j内的根节点
        TreeNode root = new TreeNode(list.get(mid).val);
        root.left = buildTree(list,i,mid-1); //递归创建左子树
        root.right = buildTree(list,mid+1,j);//递归创建右子树
        return root;//返回
    }
}
