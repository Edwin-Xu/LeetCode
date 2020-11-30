package leetcode.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin Xu on 6/22/2020 11:10 PM
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个 3叉树 :
 */
public class LC_559 {
    public int maxDepth(Node root) {
        if (root==null)return 0;
        if (root.children.size()==0)return 1;
        int max = maxDepth(root.children.get(0));
        for (int i =1;i<root.children.size();i++){
            int tmp = maxDepth(root.children.get(i));
            if (tmp>max) max =tmp;
        }
        return max;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static Integer f(){
        return 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1333);
        a.add(1333);
        System.out.println(a.get(0)==a.get(1));
        System.out.println(a.get(0).equals(a.get(1)));

        //注意返回值
//        ？？？？？？？？？？？？？？
//        为什么是true

        System.out.println(LC_559.f()== LC_559.f());
/*
* 为什么？？
* 自动拆箱？？？
* 原来是是常量池的原因
*
*
* Integer a1 = 127;
Integer b1 = 127;
if(a1==b1){
    System.out.println("相等");
}else{
    System.out.println("不等");
}
 
Integer a = 128;
Integer b = 128;
if(a==b){
    System.out.println("相等");
}else{
    System.out.println("不等");
}

结果：

相等
不等
————————————————
版权声明：本文为CSDN博主「Architect_csdn」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/Architect_CSDN/article/details/80558715
* */
    }
}
