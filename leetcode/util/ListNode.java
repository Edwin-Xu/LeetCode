package leetcode.util;

/**
 * Created by Edwin Xu on 5/16/2020 11:39 AM
 */
public class ListNode {
    public int val;
    public    ListNode next;
    public ListNode(int x) { val = x; }

    /*
    * "1,2,3"
    * */
    public static ListNode getList(String s){
        String [] arr = s.split(",");
        ListNode head = new ListNode(Integer.valueOf(arr[0]));
        ListNode cur = head;
        for (int i = 1; i <arr.length ; i++) {
            cur.next = new ListNode(Integer.valueOf(arr[i]));
            cur = cur.next;
        }
        return head;
    }

    public static void printList(String msg, ListNode head){
        System.out.print(msg+" : ");
        ListNode cur =head;
        while (cur!=null){
            System.out.print(cur.val +" ");
            cur = cur.next;
        }
        System.out.println();
    }
}


/*
         同类     同包     不同包子类   不同包非子类
private   Y       NNN
default   Y        Y       NN
protected Y     Y      Y   N
public   Y YYY

注意
a.b
a
不是同包

 */