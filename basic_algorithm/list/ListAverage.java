package basic_algorithm.list;

import leetcode.util.ListNode;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 12/4/2020 3:11 PM.
 *
 *
 * int型链表，qui平均值
 * - 迭代：easy
 * - 递归：
 */

public class ListAverage {
    /**
     * @param n 链表节点总数
     *
     * 这种方法需要提前知道链表节点个数。
     */
    public static double avg(ListNode head,int n){
        if (head==null){
            return 0;
        }
        return (avg(head.next,n-1)*(n-1) + head.val)/n;
    }



    /**
     * 方法2： 利用全局变量，不需要知道节点个数
     * */
    public static int count = 0;
    public static double avg = 0;
    public static void avg2(ListNode head){
        if (head!=null){
            avg2(head.next);
            avg = (avg*count + head.val)/(++count);
        }
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println(avg(listNode,5));


        avg2(listNode);
        System.out.println(ListAverage.avg);
    }


}
