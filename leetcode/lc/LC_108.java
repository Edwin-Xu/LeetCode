package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/8/2020 4:27 PM.
 *
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

public class LC_108 {
    /*
递归创建
对于数组中[a,b]中，去中间位置作为根节点
*/
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0)return null;
        return constructTree(nums,0,nums.length-1);
    }
    private TreeNode constructTree(int []nums, int left,int right){
        if(left>right)return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums,left,mid-1);
        root.right = constructTree(nums,mid+1,right);
        return root;
    }
    //变种：如果给出无序数组，怎么办？
    //先排序
}
