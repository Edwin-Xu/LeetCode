package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/11/2020 2:01 PM.
 *
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 */

public class LC_572 {
    /*
    * 我的解法： 暴力双DFS判断
    *
    * */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null)return t==null;
        boolean isSub = sub(s,t);
        if(isSub)return isSub;
        return  isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    //根据节点值判断
    private boolean sub(TreeNode s, TreeNode t){
        if(s==null && t==null)return true;
        if(s==null || t==null)return false;
        if(s.val!=t.val)return false;
        return sub(s.left,t.left) && sub(s.right,t.right);
    }




    /*
    * 解法2：转化为中序序列+KMP判断
    * 这个方法需要我们先了解一个「小套路」：一棵子树上的点在 DFS 序列（即先序遍历）中是连续的。了解了这个「小套路」之后，我们可以确定解决这个问题的方向就是：把 ss 和 tt 先转换成 DFS 序，然后看 tt 的 DFS 序是否是 ss 的 DFS 序的「子串」。

这样做正确吗？ 假设 ss 由两个点组成，11 是根，22 是 11 的左孩子；tt 也由两个点组成，11 是根，22 是 11 的右孩子。这样一来 ss 和 tt 的 DFS 序相同，可是 tt 并不是 ss 的某一棵子树。由此可见「ss 的 DFS 序包含 tt 的 DFS 序」是「tt 是 ss 子树」的 必要不充分条件，所以单纯这样做是不正确的。

为了解决这个问题，我们可以引入两个空值 lNull 和 rNull，当一个节点的左孩子或者右孩子为空的时候，就插入这两个空值，这样 DFS 序列就唯一对应一棵树。处理完之后，就可以通过判断 「ss 的 DFS 序包含 tt 的 DFS 序」来判断答案。

    * */
    List<Integer> sOrder = new ArrayList<Integer>();
    List<Integer> tOrder = new ArrayList<Integer>();
    int maxElement, lNull, rNull;

    public boolean isSubtree_dfs_kmp(TreeNode s, TreeNode t) {
        maxElement = Integer.MIN_VALUE;
        getMaxElement(s);
        getMaxElement(t);
        lNull = maxElement + 1;
        rNull = maxElement + 2;

        getDfsOrder(s, sOrder);
        getDfsOrder(t, tOrder);

        return kmp();
    }

    public void getMaxElement(TreeNode t) {
        if (t == null) {
            return;
        }
        maxElement = Math.max(maxElement, t.val);
        getMaxElement(t.left);
        getMaxElement(t.right);
    }

    public void getDfsOrder(TreeNode t, List<Integer> tar) {
        if (t == null) {
            return;
        }
        tar.add(t.val);
        if (t.left != null) {
            getDfsOrder(t.left, tar);
        } else {
            tar.add(lNull);
        }
        if (t.right != null) {
            getDfsOrder(t.right, tar);
        } else {
            tar.add(rNull);
        }
    }

    public boolean kmp() {
        int sLen = sOrder.size(), tLen = tOrder.size();
        int[] fail = new int[tOrder.size()];
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < tLen; ++i) {
            while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) {
                j = fail[j];
            }
            if (tOrder.get(i).equals(tOrder.get(j + 1))) {
                ++j;
            }
            fail[i] = j;
        }
        for (int i = 0, j = -1; i < sLen; ++i) {
            while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) {
                j = fail[j];
            }
            if (sOrder.get(i).equals(tOrder.get(j + 1))) {
                ++j;
            }
            if (j == tLen - 1) {
                return true;
            }
        }
        return false;
    }

}
