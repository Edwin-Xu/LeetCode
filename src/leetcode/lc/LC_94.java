package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Edwin Xu on 4/9/2020 12:09 AM
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_94 {

    //这是前序遍历
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> ints = new LinkedList<>();
        Queue<TreeNode> q= new LinkedBlockingQueue<>();
        TreeNode tmp = null;
        q.add(root);
        while (q.size()>0){
            tmp = q.poll();
            ints.add(tmp.val);
            if (tmp.left!=null)q.add(tmp.left);
            if (tmp.right!=null)q.add(tmp.right);
        }
        return ints;
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root==null)return new
//    }



}
