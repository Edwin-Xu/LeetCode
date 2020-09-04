package datastructure.tree;

import leetcode.util.Print;
import leetcode.util.TreeNode;

/**
 * Created by Edwin Xu on 7/5/2020 5:26 PM
 */
public class BST {
    private TreeNode root;

    public BST(){}
    public BST(int [] arr){
        for (int a: arr)insert(a);
    }

    public void insert(int newNode){
        if (root==null)root = new TreeNode(newNode);
        else{
            insert(root,new TreeNode(newNode));
        }
    }

    private void insert(TreeNode root,TreeNode newNode){
        if (newNode.val< root.val){
            if (root.left==null)root.left = newNode;
            else insert(root.left,newNode);
        }else if(newNode.val> root.val){
            if (root.right==null)root.right = newNode;
            else insert(root.right,newNode);
        }else{
            root = newNode;
        }
    }

    /*
    * 删除节点N分3种情况：
    * 1.N是叶节点：直接删除
    * 2.N只有左节点或者右节点：子节点上移替换被删节点
    * 3.N有左右子节点：把右子树最左节点(或者左子树最右节点)拿到被删节点处
    * （N比左子树大，比右子树小，只能是左子树最右节点--最大，或者是右子树最左节点--最小）
    * */
    public void delete(int deleteNode){

    }

    private void del(TreeNode root){
        if (root==null)return;
        if (root.left!=null && root.right!=null){
            //找右子树最左节点X， X=null ,root=X即可
        } else if (root.left==null && root.right!=null){
            root = root.right;
        }else  if (root.right==null && root.left!=null){
            root = root.left;
        }else {
            root =null;
        }
    }


    public TreeNode getRoot() {
        return root;
    }

    public static void main(String[] args) {
        int a [] = {5,4,6,2,7,3,1};
        BST bst = new BST(a);
        Print.layerTraversal(bst.getRoot());
    }
}
