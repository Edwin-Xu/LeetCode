package leetcode.interview.inte;

import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/27/2020 12:37 PM
 *
 * 面试题 04.12. 求和路径
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 */
public class Int_04_12 {
    //使用一个List存储路径上的数，一个数pathSum存储路径上的和
    //当pathSum=sum时：cnt++
    //当pathSum<sum继续递归
    //当pathSum>sum时，去掉list的第一个节点直到pathSum<sum

    //不对啊，节点值可正可负
    //所以： 对于每一个节点N：
    //   从N开始向下dfs遍历，遇到和为sum就cnt++;

    //下面的写法还可以优化：pathSum不必要存在，直接使用sum，每次减去节点值，当sum=0时才++

    public int pathSum(TreeNode root, int sum) {
        traversal(root,sum);
        return cnt;
    }
    private int cnt = 0;
    //DFS遍历一个节点
    private void dfs(TreeNode root, int pathSum, int sum){
        if(root==null)return ;
        pathSum+=root.val;
        if(pathSum==sum){
            cnt++;
        }
        dfs(root.left,pathSum,sum);
        dfs(root.right,pathSum,sum);
    }
    //前序遍历所有节点
    private void traversal(TreeNode root,int sum){
        if(root==null)return;
        dfs(root,0,sum);
        traversal(root.left,sum);
        traversal(root.right,sum);
    }

}
