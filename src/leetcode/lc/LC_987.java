package leetcode.lc;

import leetcode.util.ConstructTree;
import leetcode.util.Print;
import leetcode.util.TreeNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/18/2020 11:48 PM.
 * 987. 二叉树的垂序遍历
 * 给定二叉树，按垂序遍历返回其结点值。
 *
 * 对位于 (X, Y) 的每个结点而言，其左右子结点分别位于 (X-1, Y-1) 和 (X+1, Y-1)。
 *
 * 把一条垂线从 X = -infinity 移动到 X = +infinity ，每当该垂线与结点接触时，我们按从上到下的顺序报告结点的值（ Y 坐标递减）。
 *
 * 如果两个结点位置相同，则首先报告的结点值较小。
 *
 * 按 X 坐标顺序返回非空报告的列表。每个报告都有一个结点值列表。
 *
 * 输入：[3,9,20,null,null,15,7]
 * 输出：[[9],[3,15],[20],[7]]
 */

public class LC_987 {
    /*
 使用一个Map<X轴坐标，List> 记录对应X坐标下的list
 DFS遍历即可

 问题：
 DFS会导致一条垂线上的值顺序不对，有可能底部的在左树所以在上面。
 看来只能层序遍历了。
 不不不：如果每个节点有深度值，那么我就可以在插入时进行一次字节插入排序
 */
    public List<List<Integer>> verticalTraversal_recur(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>> res = new ArrayList<>(map.size());
        for (int i = 0; i < map.size(); i++) {
            res.add(null); //ArrayList的坑，不填充的话size=0, set就越界。
        }
        for(Map.Entry<Integer,LinkedList<Integer>> entry:map.entrySet()){
            ArrayList<Integer> list = new ArrayList<>(entry.getValue().size());
            for (int n: entry.getValue()){
                list.add(n%TreeNodeMaxVal);
            }
            res.set(entry.getKey()-min,list);
        }

        return res;
    }
    private final Map<Integer,LinkedList<Integer>> map = new HashMap<>();
    //记录最小值，用以在上面直接res.set(min-x);
    private int min = Integer.MAX_VALUE;
    private final int TreeNodeMaxVal = 10000000;// 大于10000000的用于记录深度，小于的才是val

    //x: 横坐标 ； depth：深度
    private void dfs(TreeNode root, int x,int depth){
        if(root==null)return ;
        if (x<min) min = x;
        if(!map.containsKey(x)){
            map.put(x,new LinkedList<>());
        }

        LinkedList<Integer> list = map.get(x);
        //按深度进行直接插入(已知前面是有序的，然后从后往前搜索位置插入)
        int i = list.size()-1;
//        Print.print("size:",list.size());
        for ( ;i >=0 ; i--) {
            int dep = list.get(i) / TreeNodeMaxVal;
            int val = list.get(i) %TreeNodeMaxVal;
            if ( dep < depth || (dep==depth && val > root.val )){//取出深度比较
                break;
            }
        }
        if(i<0){
            list.add(depth*TreeNodeMaxVal+root.val);
        }else{
//            System.out.println("as "+root.val);
//            Print.printList(list);
            list.add(i+1,depth*TreeNodeMaxVal+root.val);
//            Print.printList(list);
        }
        dfs(root.left,x-1,depth+1);
        dfs(root.right,x+1,depth+1);
    }


    /*
    * 层序遍历
    * 也比较麻烦，不是连续的
    * 看来就算是null也需要进行处理
    * */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root ==null) return  res;

        int leftIndex = 0; //最左边的X下标

        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.removeFirst();
                if (tmp==null){
                    q.add(null);
                    q.add(null);
                }else{
//                    if ()
                    /*
                    * 这里逐个添加
                    * */

                }
            }
        }


        return res;


    }

    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(0,1);
//        Print.printList(list);
//        list.add(0,2);
//        Print.printList(list);
//        list.add(2,3);
//        Print.printList(list);


        TreeNode root = ConstructTree.construct("3,9,20,null,null,15,7");
        List<List<Integer>> res = new LC_987().verticalTraversal_recur(root);
        for (List<Integer> l: res)
            Print.printList(l);

    }

}
