package leetcode.lc;

import leetcode.util.Print;
import leetcode.util.TreeNode;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 11/16/2020 3:49 PM
 *
 *
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 *
 * ---------------
 * analysis:
 *  first, traverse the tree inorder.
 *  then use two pointer:first and last to find the target.
 *
 *  Time: O(N)
 *  Storage: O(N)
 */

public class LC_653 {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        int left = 0, right = list.size()-1;
        while (left<right){
            int sum = list.get(left)+list.get(right) ;
            if (sum<k){
                left++;
            }else if (sum>k){
                right--;
            }else {
                return true;
            }
        }
        return false;
    }

    private void inorderTraversal(TreeNode root,ArrayList<Integer> list){
        if (root!=null){
            inorderTraversal(root.left,list);
            list.add(root.val);
            inorderTraversal(root.right,list);
        }
    }



    /**
     * Method Two: HashSet
     * */
    public boolean findTargetByHashSet(TreeNode root, int k) {
        Set < Integer > set = new HashSet<>();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

}
