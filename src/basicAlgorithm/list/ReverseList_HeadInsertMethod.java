package basicAlgorithm.list;

import leetcode.util.ConstructTree;
import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 6/3/2020 9:34 AM
 */
public class ReverseList_HeadInsertMethod {

    /*
    * 头插法：
    * 使用一个额外的节点
    * */
    public ListNode headInsert(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode tmp ;
        while (head!=null){
            tmp = head.next;
            head.next = dummy.next;
            head.next = dummy;
            head =tmp;
        }
        return dummy;
    }


    /*
    * 头插法：不使用额外节点
    * */
    public ListNode reverse(ListNode head){
        if (head==null)return head;
        ListNode head_tmp = head;
        ListNode next = head.next;
        while (next!=null){
            ListNode t = next.next;
            next.next = head;
            head = next;
            next = t;
        }
        head_tmp.next = null; //切断原来头结点的next
        return head;
    }



    public ListNode reverse_review(ListNode head){
        if (head ==null)return head;

        ListNode next = head.next;
        ListNode head_ = head;
        ListNode tmp;
        while (next!=null){
            tmp = next.next;//下一个节点
            next.next = head;
            head = next;
            next = tmp;
        }
        head_.next = null;
        return head;
    }



    public ListNode review(ListNode head){
        if (head ==null )return head;
        ListNode next = head.next;
        ListNode head_c = head;
        while (next!=null){
            ListNode tmp = next.next;
            next.next = head;
            head = next;
            next = tmp;
        }
        head_c.next = null;
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode h = new ReverseList_HeadInsertMethod().reverse(head);
        while (h!=null){
            System.out.println(h.val);
            h = h.next;
        }


//        ListNode h = new ReverseList_HeadInsertMethod().headInsert(head);
//        while (h!=null){
//            System.out.println(h.val);
//            h = h.next;
//        }

    }

}
