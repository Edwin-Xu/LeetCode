package leetcode.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Edwin Xu on 5/18/2020 5:50 PM
 */
public class ConstructTree {
    /*
    * 输入层序的节点
    *[5,4,8,11,null,13,4,7,2,null,null,5,1]
    * */
    public static TreeNode construct(String inp){

        String [] nodelist= inp.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(nodelist[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cnt = 1;
        TreeNode tmp;
        while (cnt!=nodelist.length && !queue.isEmpty()){
            tmp = queue.pop();
            if (tmp!=null){
                tmp.left = nodelist[cnt].equals("null")?null:new TreeNode(Integer.valueOf(nodelist[cnt]));
                cnt++;
                tmp.right = nodelist[cnt].equals("null")?null:new TreeNode(Integer.valueOf(nodelist[cnt]));
                cnt++;
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }
        return root;
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

    public static void main(String[] args) {
        TreeNode root = ConstructTree.construct("5,4,8,11,null,13,4,7,2,null,null,5,1");
        ConstructTree.tra(root);

    }

    private static void tra(TreeNode t){
        if (t==null)return;
        System.out.println(t.val);
        tra(t.left);
        tra(t.right);
    }
}
