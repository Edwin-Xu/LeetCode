package leetcode.nowcoder.offer;

import leetcode.util.TreeLinkNode;

/**
 * Created by Edwin Xu on 6/22/2020 7:28 PM
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 */


public class Offer_NextNodeOfInorder {

    public TreeLinkNode getNext(TreeLinkNode n) {

        /*
         * - 如果有右子树：那就是又子树的最左节点
         * - 如果没有右子树：
         *       向上找祖先，如果它是该祖先的左子孙，则是，如果找不到，那本身就是最后一个节点，下一个是null
         *
         * */

        if (n == null) return null;
        if (n.right != null) {//有右子树：找右子树最左节点
            TreeLinkNode left = n.right;
            while (left.left != null) left = left.left;
            return left;
        } else {//没有右子树，找为其左子孙的第一个祖先。
            TreeLinkNode father = n;
            while (father != null) {
                if (father.next != null && father.next.left == father) return father.next;
                father = father.next;
            }
            return null;//找不到，那它本身就是最后一个，下一个是null
        }

    }


    public static void main(String[] args) {
        int x = 1;
        int y = 1;

        int a = 1, b = 1, sum;

        for (int i = 2; i <= 45; i++) {
            y = (x + y) % 1000000007;
            x = (y - x);
            System.out.print(y);

            System.out.print(" ");
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
            System.out.println(sum);

        }


    }
}


/*
 *
 *              public protected default private
 * 本类           Y     Y       YYNN       YNNN
 * 包内不同类      Y     Y
 * 不同包子类   Y       Y
 * 不同包非子类  Y       N
 *
 * */