package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 9/24/2020 7:13 PM
 *
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *
 *
 */
public class Offer_36 {

    /*
    * 得到双向链表后 将其变为循环双向链表
    * */
    public Node treeToDoublyList(Node root) {
        if(root==null)return null;
        Node left =  convert(root);
        Node cur = left;
        while (cur!=null && cur.right!=null){
            cur = cur.right;
        }
        cur.right = left;
        left.left=cur;
        return left;
    }

    /*
    * 二叉树转化为双向链表
    * */
    private Node convert(Node root){
        //退出条件
        if(root==null)return null;
        if(root.left==null && root.right==null)return root;

        //转换左子树
        Node left = convert(root.left);
        Node L = left;
        //找到最右节点
        while(L!=null && L.right!=null){
            L = L.right;
        }
        if(L!=null){
            L.right = root;
            root.left = L;
        }
        //转换右子树
        Node right = convert(root.right);
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left==null?root:left;
    }


//    public Node Convert2(Node root) {
//        if(root==null)
//            return null;
//        if(root.left==null&&root.right==null)
//            return root;
//        // 1.将左子树构造成双链表，并返回链表头节点
//        Node left = Convert2(root.left);
//        Node p = left;
//        // 2.定位至左子树双链表最后一个节点
//        while(p!=null&&p.right!=null){
//            p = p.right;
//        }
//        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
//        if(left!=null){
//            p.right = root;
//            root.left = p;
//        }
//        // 4.将右子树构造成双链表，并返回链表头节点
//        Node right = Convert2(root.right);
//        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
//        if(right!=null){
//            right.left = root;
//            root.right = right;
//        }
//        return left!=null?left:root;
//    }

    public void test(){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Node n =  treeToDoublyList(root);
        while (n!=null){
            System.out.println(n.val);
            n = n.right;
        }

    }

    public static void main(String[] args) {
        new Offer_36().test();
    }



    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
