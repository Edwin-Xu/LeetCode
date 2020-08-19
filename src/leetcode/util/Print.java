package leetcode.util;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Edwin Xu on 6/19/2020 8:43 PM
 */
public class Print {
    public static void print(Object...objects){
        for (Object o:objects){
            System.out.print(o);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void treeInOrderPrint(TreeNode t){
        if(t==null)return;
        System.out.println(t.val);
        treeInOrderPrint(t.left);
        treeInOrderPrint(t.right);
    }
    public static <T> void printArr(T[] objects){
        for (T o:objects){
            System.out.print(o+" ");
        }
    }

    public static void layerTraversal(TreeNode root) {
        Queue<TreeNode> q= new LinkedBlockingQueue<>();
        TreeNode tmp ;
        q.add(root);
        while (q.size()>0){
            tmp = q.poll();
            System.out.print(tmp.val+" ");
            if (tmp.left!=null)q.add(tmp.left);
            if (tmp.right!=null)q.add(tmp.right);
        }
    }
}
