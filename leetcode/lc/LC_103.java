package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Edwin Xu
 * @date 12/22/2020 10:34 PM.
 *
 *
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

public class LC_103 {
    /**
     * 层序+偶数层反转
     * */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        int layer = 0;

        Queue<TreeNode> q= new LinkedList<>();
        TreeNode tmp ;
        q.add(root);
        while (q.size()>0){
            int size = q.size();
            ArrayList<Integer> layerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                tmp = q.poll();
                layerList.add(tmp.val);
                if (tmp.left!=null) {
                    q.add(tmp.left);
                }
                if (tmp.right!=null) {
                    q.add(tmp.right);
                }
            }
            layer++;
            if (layer%2 == 0){
                reverseList(layerList);
            }
            list.add(layerList);
        }
        return list;
    }

    private void reverseList(List<Integer> list){
        for (int i=0,j=list.size()-1;i<j;i++,j--){
            int tmp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,tmp);
        }
    }


    /**
     * 双端队列就不需要反转List了。
     *
     * */

}
