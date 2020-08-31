package leetcode.nowcoder.nc;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 8/28/2020 4:37 PM
 * 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 *
 *
 * 做过的，复习下
 */
public class NC_102 {
    /**
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */

    /*
    *
    * 怎么分析呢？
    *  有几种情况：
    *  1. AB是父子关系。返回父亲
    *  2. AB 处于某一个节点的子节点/子孙
    *
    * */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        if (root==null)return Integer.MIN_VALUE; //节点为空返回标志Integer.MIN_VALUE
        if (root.val==o1 || root.val==o2)return root.val; //找到一个节点
        int L = lowestCommonAncestor(root.left,o1,o2); //左边找
        int R = lowestCommonAncestor(root.right,o1,o2);//右边找

        if (L!=Integer.MIN_VALUE && R!=Integer.MIN_VALUE)return root.val;//左右都找到了，当前节点就是公共父亲
        if (L==Integer.MIN_VALUE && R!=Integer.MIN_VALUE)return R; //如果左边没找到,一定在右边
        if (L!=Integer.MIN_VALUE)return L; //如果右边没找到,一定在左边
        return Integer.MIN_VALUE;//左右都没有，找不到；
    }
}
