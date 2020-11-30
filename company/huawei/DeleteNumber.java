package company.huawei;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 4/15/2020 12:11 AM
 *
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 *
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 *
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 *
 *
 *
 * 使用循环链表：
 */
public class DeleteNumber {

    class Node{
        int val;
        Node next;
        Node(int v){
            val =v;
        }
    }

    private Scanner sc ;

    public DeleteNumber(){
        sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();

            Node a = new Node(0);
            Node head =a;
            for (int i=1;i<n-1;i++){
                a.next = new Node(i);
                a= a.next;
            }
            a.next = new Node(n-1);
            a.next.next=head;

            Node t = head.next;

            while (n>1){
                t.next=t.next.next;
                t=t.next.next;
                n--;
            }
            System.out.println(t.val);
        }
        sc.close();

    }

    public static void main(String[] args) {
        new DeleteNumber();
    }
}
