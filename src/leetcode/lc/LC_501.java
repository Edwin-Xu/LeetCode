package leetcode.lc;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin Xu on 9/24/2020 1:01 PM
 *
 * BST求众数
 * 众数可能有多个
 *
 */
public class LC_501 {

    public int[] findMode(TreeNode root) {
        preOrder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int max = 0; // 最大的数量
    private int cnt = 0; //num的个数
    private int pre = Integer.MAX_VALUE; //存储当前遍历之前的一个数
    private List<Integer> list = new ArrayList<>();

    //前序遍历
    private void preOrder(TreeNode root) {
        if (root == null) return;
        preOrder(root.left);

        if (root.val == pre) {
            cnt++; //当前值和前一个相同，数量++
        } else { //切换到另一个数，数量置为1，pre设为当前的值
            cnt = 1;
            pre = root.val;
        }

        if (cnt > max) {//现在pre的数量超过了max
            list.clear(); //list中的都不是众数，去掉
            list.add(pre); //加入新的众数
            max = cnt; //更新最大数量
        } else if (cnt == max) { //这是一个相同的众数，加入
            list.add(pre);
        }

        preOrder(root.right);
    }

    public static void main(String[] args) {
        LC_501 l = new LC_501();
        TreeNode root = ConstructTree.construct("2,2,2,1,2,2,3");
        l.preOrder(root);


    }
}
