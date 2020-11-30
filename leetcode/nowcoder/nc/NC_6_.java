package leetcode.nowcoder.nc;

import leetcode.util.ConstructTree;
import leetcode.util.Print;
import leetcode.util.TreeNode;

import java.util.ArrayList;

/**
 * Created by Edwin Xu on 8/24/2020 1:29 PM
 *
 * 给定一个二叉树，请计算节点值之和最大的路径的节点值之和是多少。
 * 这个路径的开始节点和结束节点可以是二叉树中的任意节点
 *
 * 例如：
 * 给出以下的二叉树，
 *    1
 *   2 3
 * 返回的结果为6
 *
 *
 * 分析：
 * 这个感觉有点难
 * 首先：
 * 对于一颗树
 * 最大路径可能：
 *  - 在左子树中
 *  - 在右子树
 *  - 经过根节点
 *
 *
 * 也是 LeetCode124. 二叉树中的最大路径和
 *https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-ikaruga/
 *
 */
public class NC_6_ {
    /*
    * 还是没写出来，这是标准解法
    * */
    public int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }

    public int getMax(TreeNode root){
        if(root == null) {
            System.out.println("节点为空");
            return 0; //节点为空，返回0
        }
        System.out.println("当前节点："+root.val);
        int leftMax = Math.max(0,getMax(root.left));
        Print.print("左边子节点：",leftMax);
        int rightMax = Math.max(0,getMax(root.right));
        Print.print("右边子节点：",rightMax);
        res = Math.max(res,Math.max(root.val+Math.max(leftMax,rightMax),root.val+leftMax+rightMax));
        Print.print("res：",res);
        System.out.println();
        return Math.max(leftMax,rightMax) + root.val;
    }

    public static void main(String[] args) {
        NC_6_ nc_6_ = new NC_6_();
        TreeNode root = ConstructTree.construct("1,2,3,4,5,6,7");
        nc_6_.getMax(root);


        ArrayList<Integer> arrayList=new ArrayList<>(   );
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.remove(1);
        arrayList.remove((Object)1);
        arrayList.remove(new Integer(1)); //会移除所有的值


    }


/*
*
* 二叉树 abc，a 是根结点（递归中的 root），bc 是左右子结点（代表其递归后的最优解）。
最大的路径，可能的路径情况：


    a
   / \
  b   c
b + a + c。
b + a + a 的父结点。
a + c + a 的父结点。
其中情况 1，表示如果不联络父结点的情况，或本身是根结点的情况。
这种情况是没法递归的，但是结果有可能是全局最大路径和。
情况 2 和 3，递归时计算 a+b 和 a+c，选择一个更优的方案返回，也就是上面说的递归后的最优解啦。

另外结点有可能是负值，最大和肯定就要想办法舍弃负值（max(0, x)）（max(0,x)）。
但是上面 3 种情况，无论哪种，a 作为联络点，都不能够舍弃。

代码中使用 val 来记录全局最大路径和。
ret 是情况 2 和 3。
lmr 是情况 1。

所要做的就是递归，递归时记录好全局最大和，返回联络最大和。

int maxPathSum(TreeNode* root, int &val)
{
	if (root == nullptr) return 0;
	int left = maxPathSum(root->left, val);
	int right = maxPathSum(root->right, val);
	int lmr = root->val + max(0, left) + max(0, right);
	int ret = root->val + max(0, max(left, right));
	val = max(val, max(lmr, ret));
	return ret;
}

int maxPathSum(TreeNode* root)
{
	int val = INT_MIN;
	maxPathSum(root, val);
	return val;
}


* */
}
