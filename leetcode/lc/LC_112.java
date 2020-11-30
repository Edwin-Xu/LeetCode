package leetcode.lc;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Edwin Xu on 5/18/2020 12:38 AM
 *
 * 路径和：
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *
 *
 *--------------------------------------------------------------------------
 * 路径和·2：
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class LC_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)return false;
        else if ( root.left==null && root.right==null &&root.val==sum)return true;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

//---------------------------------------
    /*关键是怎么把路径存起来
    * */
    private List<List<Integer>>  list= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null)return list;
        List<Integer> rootList = new ArrayList<>();
        traPath(root,sum,rootList);
        return list;
    }
    private void traPath(TreeNode n,int sum,List<Integer> parent){
        if (n!=null && n.left==null&&n.right==null){
            //到达叶节点，判断sum
            if (sum==n.val){
                parent.add(n.val);
                list.add(parent);
            }
        }
        if (n.left!=null){
            List<Integer> left = new ArrayList<>(parent);
            left.add(n.val);
            traPath(n.left,sum-n.val,left);
        }
        if (n.right!=null){
            List<Integer> right = new ArrayList<>(parent);
            right.add(n.val);
            traPath(n.right,sum-n.val,right);
        }
    }


    /*递归+回溯*/
    public List<List<Integer>> pathSum_(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        path(root, sum, ans, tmp);
        return ans;
    }
    private void path(TreeNode root, int sum, List<List<Integer>> ans, ArrayList<Integer> tmp) {
        if (root == null)return;
        tmp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            ans.add(new ArrayList<>(tmp));
        }
        path(root.left, sum - root.val, ans, tmp);
        path(root.right, sum - root.val, ans, tmp);
        tmp.remove(tmp.size() - 1);
    }



    public static void main(String[] args) {


        LC_112 lc = new LC_112();
        TreeNode root = ConstructTree.construct("5,4,8,11,null,13,4,7,2,null,null,5,1");
//        TreeNode root = ConstructTree.construct("-2,null,-3");

        List<List<Integer>> res = lc.pathSum(root,22);
        for (List<Integer> l: res){
            Arrays.asList(l).forEach(System.out::print);
            System.out.println();
        }
    }

}
