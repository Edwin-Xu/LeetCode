package leetcode.interview.importment;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 5/21/2020 9:54 PM
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 分析：
 * 前序拿到根节点，在中序中找到该节点左边的元素和右边的元素，递归下去
 */

public class Offer_07 {
    private int[] preorder;
    private Map<Integer, Integer> map;//用于记录中序中节点对应的索引。
    private int preIndex = 0; //前序数组中从头开始遍历

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return cur(0, preorder.length);
    }

    private TreeNode cur(int inorderBegin, int inorderEnd) {
        if (preIndex >= preorder.length) return null;
        int rootVal = preorder[preIndex];
        System.out.println("preorder[ " + preIndex + " ]:" + rootVal + "，子元素：[ " + inorderBegin + " , " + inorderEnd + " ]");
        TreeNode root = new TreeNode(rootVal);
        if (inorderBegin + 1 >= inorderEnd) return root;
        int index = map.get(rootVal);
        if (index == inorderBegin) {
            preIndex++;
            root.right = cur(inorderBegin + 1, inorderEnd);
        } else if (index == inorderEnd - 1) {
            preIndex++;
            root.left = cur(inorderBegin, inorderEnd - 1);
        } else {
            preIndex++;
            root.left = cur(inorderBegin, index);
            preIndex++;
            root.right = cur(index + 1, inorderEnd);
        }
        return root;
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 2, 4};
        int b[] = {1, 2, 3, 4};
        TreeNode root = new Offer_07().buildTree(a, b);
        System.out.println();
        ConstructTree.layerTraversal(root);
    }







    /*
     *
     * 上面的实现过于复杂，重新写一下
     *
     * build()参数：子树中序遍历的左右index，子树中序的左index
     * 需要中序的左index主要用于计算子树的大小。
     * */

    private Map<Integer, Integer> inmap = new HashMap<>();

    public TreeNode buildTree_better(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            inmap.put(preorder[i], i);
        }
        return build(preorder,0,preorder.length,0);

    }
    //前序数组，子树前序的左右下标，中序的左下标
    private TreeNode build(int pre[],int preL,int preR,int inL){
        if (preL>preR)return null;
        TreeNode root = new TreeNode(pre[preL]);
        int index = inmap.get(root.val);
        int leftTreeSize = index-inL; //求得子树的大小
        root.left = build(pre,preL+1,preL+leftTreeSize,inL); //构建左右孩子
        root.right = build(pre,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);
        return root;
    }


    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = inmap.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}

















