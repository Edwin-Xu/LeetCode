package leetcode.lc;


import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 5/13/2020 5:04 PM
 *
 * 层序遍历
 */

public class LC_102 {

    /*
    * 增加需求：
    *       3
           / \
          9  20
            /  \
           15   7
        返回其层次遍历结果：
        [
          [3],
          [9,20],
          [15,7]
        ]

    如何控制层数？？？
    利用两个队列，交替使用，于是就能把层次区分开来。
    * */
//    双队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();//结构

        LinkedList<TreeNode> q1 = new LinkedList<>();//Q1
        LinkedList<TreeNode> q2 = new LinkedList<>();//Q2
        LinkedList<TreeNode> cur,empty;//引用，分别指向当前使用的队列和空队列
        TreeNode tmp;
        if (root!=null)q1.add(root); //先把root加入Q1
        while (!q1.isEmpty() || !q2.isEmpty()){//至少一个队列不为空
            List<Integer> level = new LinkedList<>();
            if (q1.isEmpty()){ //使cur指向正在使用的队列，empty指向即将用于存储的空队列
                cur = q2;
                empty = q1;
            }else{
                cur = q1;
                empty= q2;
            }
            while (!cur.isEmpty()){//当前队列不为空，取出所有元素，把元素的非null子节点放到empty队列
                tmp = cur.pop();
                level.add(tmp.val);
                if (tmp.left!=null)empty.add(tmp.left);
                if (tmp.right!=null)empty.add(tmp.right);
            }
            res.add(level);
        }
        return res;
    }

    /*
    * 单队列+分界节点*/
    public List<List<Integer>> levelOrder_boundary(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();//辅助队列
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);//分界节点

        List<List<Integer>> res = new LinkedList<>();//result
        List<Integer> level =new LinkedList<>();//层元素数组
        TreeNode tmp;//临时节点

        if (root==null)return res;
        q.add(root);
        q.add(dummy);//第一层和第二层之间的分界节点
        while (!q.isEmpty()){
            tmp = q.pop();
            if (tmp==dummy){//遇到分界节点，表示已经遍历完一层了
                res.add(level);
                level = new LinkedList<>();//下一层的存放数组
                if(!q.isEmpty()) q.add(dummy);//dummy只有在队列不为空的情况下入队，保证程序正常退出
            }else{//非分界节点
                level.add(tmp.val);
                if (tmp.left!=null)q.add(tmp.left);
                if (tmp.right!=null)q.add(tmp.right);
            }
        }
        return res;
    }


    //递归实现
    /*
    * 前面两种层序遍历都是*迭代实现*，其实也可以递归实现
递归实现的话由于不是一层一层的遍历的，那么怎么控制层数？？？
我们可以添加一个参数*level*，代表当前的层数，这样就可以把元素添加到对应的层中的list中了。
*/

    private List<List<Integer>> res = new LinkedList<>();//result
    public  List<List<Integer>> levelOrder_recur(TreeNode root){
        if (root==null)return res;
        helper(root,0);
        return res;
    }
    private void helper(TreeNode node,int level){
        if (res.size()==level)res.add(new LinkedList<>());//添加某层的List
        res.get(level).add(node.val);//获取level层，并添加元素
        if (node.left!=null)helper(node.left,level+1);//递归下去
        if (node.right!=null)helper(node.right,level+1);
    }


}
