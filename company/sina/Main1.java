package company.sina;


/*
* 将一个树变换
* 树：对于一个节点：有右节点必有左节点
* 规则：
* - 最左节点X变为根节点
* - X父节点变为右节点
* - X兄弟节点变为左节点
* */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Main1 {
    public Main1(){
        Scanner scanner = new Scanner(System.in);
        TreeNode root = construct(scanner.nextLine());
        scanner.close();

        TreeNode newRoot = transform(root);
        layerTraversal(newRoot);

    }

    private TreeNode transform(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null && root.left!=null){
            stack.push(root);
            root = root.left;
        }

        TreeNode res = root;
        while (!stack.isEmpty()){
            TreeNode father = stack.pop();
            father.left =null;
            TreeNode right = father.right;
            father.right = null;

            root.left = right;
            root.right = father;
            root = father;
        }
        return res;
    }

    public  TreeNode construct(String inp){
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
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public  TreeNode(int x) { val = x; }
    }
    public void layerTraversal(TreeNode root) {
        Queue<TreeNode> q= new LinkedBlockingQueue<>();
        TreeNode tmp ;
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (q.size()>0){
            tmp = q.poll();
            sb.append(tmp.val);
            sb.append(",");
            if (tmp.left!=null)q.add(tmp.left);
            if (tmp.right!=null)q.add(tmp.right);
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        new Main1();
    }
}

/*
1,2,3,4,5,6,7


* */