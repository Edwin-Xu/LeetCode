package leetcode.lc;

import leetcode.util.Print;
import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 6/20/2020 1:17 PM
 *
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 */
public class LC_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    private TreeNode construct(int nums[],int start,int end){
        if (start>end)return null;
        if (start==end)return new TreeNode(nums[start]);
        int maxIndex  =getMaxIndexOfArr(nums,start,end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums,start,maxIndex-1);
        root.right = construct(nums,maxIndex+1,end);
        return root;
    }

    public int getMaxIndexOfArr(int [] nums,int start,int end){
        int maxIndex =start;
        int max = nums[start];
        for (int i = start+1; i <= end; i++) {
            if (nums[i]>max){
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        LC_654 l = new LC_654();
        int [] a = {3,2,1,6,0,5};
        TreeNode t = l.constructMaximumBinaryTree(a);
        Print.treeInOrderPrint(t);
    }


}
