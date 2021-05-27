package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 5/17/2021 11:57 AM.
 * <p>
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 */

public class LC_993 {
    /**
     * 层序遍历
     *
     * 在每一层中，用set判断是不是同时存在xy。
     * 为了去掉同一个父亲的情况，需要在加入队列的时候进行判断
     *
     * 时间复杂度on，空间复杂度on，有点大，
     * 优点：可以提前结束
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            // 这里for循环一定不能使用q.size()，这个是不断改变的。
            int size =q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.removeFirst();
                set.add(tmp.val);
                int cnt = 0;
                if (tmp.left != null) {
                    q.add(tmp.left);
                    cnt++;
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                    cnt++;
                }

                // 判断是不是同一个父亲
                if (cnt == 2 && ((x == tmp.left.val && y == tmp.right.val) || (y == tmp.left.val && x == tmp.right.val))) {
                    return false;
                }
            }
            // 在同一层，且不是同一个父亲
            if (set.contains(x) && set.contains(y)){
                return true;
            }
        }
        return false;
    }
}
