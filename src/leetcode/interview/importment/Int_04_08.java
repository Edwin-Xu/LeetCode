package leetcode.interview.importment;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * Created by Edwin Xu on 6/20/2020 11:40 PM
 *
 * 面试题 04.08. 首个共同祖先
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 *
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *     3
 *    / \
 *   5   1
 *  / \ / \
 * 6  2 0  8
 *   / \
 *  7   4
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 *
 * 分析：
 * 首先：父节点一定是在二者之上
 *
 * 一种思路：深度优先遍历，找出根节点到两个节点的路径
 * 然后从路径中得出该节点
 */
public class Int_04_08 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> t1 =new LinkedList<>();
        LinkedList<TreeNode> t2 = new LinkedList<>();
        getPathOfNode(t1,root,p);
        isOk=false;
        getPathOfNode(t2,root,q);
        System.out.println(t1.size());
        System.out.println(t2.size());
        int minsize =Math.min(t1.size(),t2.size())-1;
        for (int i = 0; i <=minsize; i++) {
            if (t1.get(i)!=t2.get(i))return t1.get(i-1);
        }
        return t1.get(minsize);
    }

    private boolean isOk =false;
    private void getPathOfNode(LinkedList<TreeNode> list, TreeNode root, TreeNode target){
        if (root==null)return;
        if (isOk)return;
        System.out.println("add:"+root.val);
        list.add(root);
        if (root==target){
            isOk=true;
            return;
        }
        getPathOfNode(list,root.left,target);
        getPathOfNode(list,root.right,target);
        if (!isOk) System.out.println("pop:"+list.removeLast().val);
    }
    public static void main(String[] args) {
        TreeNode t =ConstructTree.construct("3,5,1,6,2,0,8,null,null,7,4,null,null");
        TreeNode p = t.left;
        TreeNode q = t.right;
//        LinkedList<TreeNode> linkedList = new LinkedList<>();
//        new Int_04_08().getPathOfNode(linkedList,t,tar);
//        System.out.println();
//        for (TreeNode i: linkedList){
//            System.out.println(i.val);
//        }
        new Int_04_08().lowestCommonAncestor(t,p,q);

    }





    /*
    * 更好的解法：
    * https://leetcode-cn.com/problems/first-common-ancestor-lcci/solution/di-gui-jie-fa-python-3-c-by-z1m/
    *本题为了简化题目，已经说明了所有的结点都是唯一的，p、q 不同且均存在于给定的二叉树中。因此我们有以下三种情况：



难点在于如何书写递归函数，不妨这样思考：

假设我们从跟结点开始，采用 DFS 向下遍历，如果当前结点到达叶子结点下的空结点时，返回空；如果当前结点为 p 或 q 时，返回当前结点；

这样，当我们令 left = self.lowestCommonAncestor(root.left, p, q) 时，如果在左子树中找到了 p 或 q，left 会等于 p 或 q，同理，right 也是一样；

然后我们进行判断：如果 left 为 right 都不为空，则为情况 1；如果 left 和 right 中只有一个不为空，说明这两个结点在子树中，则根节点到达子树再进行寻找。


    * class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == p || root == q || root == NULL) return root;
        TreeNode* left = lowestCommonAncestor(root -> left, p, q);
        TreeNode* right = lowestCommonAncestor(root -> right, p, q);
        if (left && right) return root;
        return left ? left : right;
    }
};

    * */
    public TreeNode lowestCommonAncestor_better(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null||root==q||root==p)return root;
        TreeNode L = lowestCommonAncestor_better(root.left,p,q);
        TreeNode R = lowestCommonAncestor_better(root.right,p,q);
        if (L!=null && R!=null)return root;
        return L==null?R:L;

    }












    /*
    * 最近公共祖先p,q
    * 在写一遍，自己分析：
    *
    * 存在三种情况：
    *   - 两个节点分别在左右子树
    *   - 两个节点互为子孙
    *   - 两个节点在同一子树但是不是子孙
    *   在递归视觉下，1和3是同一种情况
    *
    * 构建递归函数：
    *   遇到p,q的则返回
    *
    * */

    public TreeNode findNearestFather(TreeNode root,TreeNode p,TreeNode q){
        if (root == null || p == root || q==root) return root;
        TreeNode L = findNearestFather(root.left,p,q);
        TreeNode R = findNearestFather(root.right,p,q);
        if (L != null && R !=null) return root; //在左右子树，当前节点是父节点
        return L==null?R:L; //q,p为父子
    }














    }
