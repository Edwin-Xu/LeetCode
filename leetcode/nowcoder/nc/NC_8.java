package leetcode.nowcoder.nc;

import leetcode.util.TreeNode;

import java.util.ArrayList;

/**
 * Created by Edwin Xu on 8/24/2020 5:28 PM
 * 给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
 */
public class NC_8 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        if(root==null)return new ArrayList<>();
        //add to path
        path.add(root.val);
        if(root.left==null && root.right==null && sum==root.val){
            //leaf node
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(path);
            res.add(tmp);
        }
        pathSum(root.left,sum-root.val);
        pathSum(root.right,sum-root.val);
        path.remove(path.size()-1);//回溯，删除
        return res;
    }
}
