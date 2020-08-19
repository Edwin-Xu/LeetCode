package leetcode.lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 6/20/2020 2:00 PM
 *1104. 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 *
 *
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，
 * 该路径是由途经的节点标号所组成的。
 *
 */
public class LC_1104 {
    /*
    * 按堆的排序的话有一种逻辑关系
    * 这里奇数行的排序反了，把它纠正过来
    * 然后就变成 ‘找父亲的过程’
    *
    * 按堆的顺序：
    * 孩子是I，父亲是 floor(I/2)
    * */
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new LinkedList<>();
        if(label<=0)return res;
        findPath(res,label);
        res.add(label);
        return res;
    }

    /*
    * x
    * */

    private void findPath(List<Integer> list,int label){
        if (label==1)return;
        int layer = log(label)+1; //第几行

        int father;//父亲
        if ((layer&1)==0){
            int nth = (1<<layer)-label;//第几个
            //偶数行:调换顺序之后就可以直接找出父亲。
            int value = (1<<layer-1)-1+nth;//按从左到右应该的值
            father = (int)Math.floor(value/2);
        }else{
            //奇数行
            father =  (int)Math.floor(label/2);
            father = (1<<layer-2)-1+(1<<layer-1)-father;//反序后正确的值
        }
        findPath(list,father);
        list.add(father);
    }

    /*
    * 求2为对数*/
    private int log(int n){
        for (int i = 31; i >0 ; i--) {
            if (((n>>>i)&1)==1)return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        LC_1104 l = new LC_1104();
//        System.out.println(l.log(7));
        List<Integer> res =  l.pathInZigZagTree(26);
        System.out.println(res);
    }


    /*
    * 总结为了一个公式：
    *
    * label(N) = {
    *   3*2^(N-1)-1, N>1
    *   1,N=1
    * }
    * 那么现在只要知道当前的位置N，以及当前的值label就行求出下一个位置的值X。将X作为下一个位置的label继续求解直到完毕。
    *
    * */

    public List<Integer> pathInZigZagTree_best_solutioin(int label) {
        ArrayList<Integer> integers = new ArrayList<>();//0.初始化存放结果的变量
        int a = (int) (Math.log(label) / Math.log(2));//2.计算label所在的层
        while (label > 1) {//5.循环直到遇到特殊情况1
            integers.add(label);//3.将label的结果添加到数组中
            label = (int) (3 * Math.pow(2, --a) - label / 2 - 1);//4.计算下一个label的值
        }
        integers.add(1);//6.添加特殊情况 1
        Collections.reverse(integers); //7.翻转数组
        return integers;//1.返回结果
    }

}
