package leetcode.nowcoder.nc;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/11/2020 11:15 PM
 */
public class NC_81 {
    int cnt = 0;
    TreeNode res = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
        pre(pRoot, k);
        return res;
    }

    private void pre(TreeNode root, int k) {
        if (root == null) return;
        if (cnt++ == k) {
            res = root;
            return;
        } else if (cnt > k) return;
        else {
            pre(root.left, k);
            pre(root.right, k);
        }
    }


    public static void main(String[] args) {
//        int a = 1;
//        a += a+100/2+1+(2/a);
//        System.out.println(a);


        NC_81 nc_81 = new NC_81();
        TreeNode res = nc_81.KthNode(ConstructTree.construct("1,2,3"), 2);
        if (res != null) System.out.println(res.val);
    }


}
