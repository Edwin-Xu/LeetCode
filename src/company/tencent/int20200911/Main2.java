package company.tencent.int20200911;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 9/11/2020 10:33 PM
 */
public class Main2{
    private int res = 0;
    public int sumNumbers(TreeNode root){
        getSum(root,0);
        return res;

    }
    private void getSum(TreeNode root, int sum){
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null){
            //到达叶节点
            res += (sum*10+root.val);
        }
        else{
            getSum(root.left,sum*10+root.val);
            getSum(root.right,sum*10+root.val);
        }
    }


    public static void main(String[] args) {
        TreeNode root = ConstructTree.construct("1,2,3");
        System.out.println(new Main2().sumNumbers(root));
    }


}

