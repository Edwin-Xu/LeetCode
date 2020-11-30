package leetcode.interview.offer;

import leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * Created by Edwin Xu on 6/29/2020 6:58 PM
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 * (约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B==null)return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        TreeNode tmp;
        while (!queue.isEmpty()){
            tmp = queue.removeFirst();
            if (isSub(tmp,B))return true;
            if (tmp.left!=null) queue.add(tmp.left);
            if (tmp.right!=null) queue.add(tmp.right);
        }
        return false;
    }

    private boolean isSub(TreeNode a,TreeNode b){
        if (b==null)return true;
        else if (a!=null && a.val==b.val){
            return isSub(a.left,b.left) && isSub(a.right,b.right);
        }else return false;
    }


    /*
    * 有更好的写法
    * */









    //更好的写法
    public boolean isSubStructure_(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }





    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        a.left = new TreeNode(1);

        TreeNode b = new TreeNode(0);
        b.left = new TreeNode(1);


        System.out.println(new Offer_26().isSubStructure(a,b));
    }

}
