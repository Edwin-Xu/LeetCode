package leetcode.nowcoder.nc;

import leetcode.util.ListNode;
import leetcode.util.Print;

import java.util.ArrayList;

/**
 * Created by Edwin Xu on 9/4/2020 10:38 PM
 */
public class NC_21 {
    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        if(m<=n)return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode h = dummy;
        int cnt = 1;
        ListNode revHead = null;
        ListNode revTail = null;
        while(h!=null){
            if(cnt==m){
                revHead = h;
                break;
            }
            if(cnt==n){
                revTail = h.next;
                h.next=null;
            }
            cnt++;
            h = h.next;
        }

        ListNode revNewHead = reverse(revHead);
        revHead.next = revTail;
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        //头插法
        ListNode dummy = new ListNode(0);
        while(head!=null){
            ListNode tmp = dummy.next;
            dummy.next = head;
            head = head.next;
            dummy.next.next = tmp;

        }
        return dummy.next;
    }




    public ListNode reverse2(ListNode head,int m,int n){
        //修改头插法
        if (m>=n)return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        ListNode mHead = null;//m的前一个

        ListNode nTail=null;

        int cnt = 0;
        while(cur!=null){
//            Print.print("cur.val:",cur.val,"cnt:", cnt);

            if(cnt<m){ //找到m的前一个，作为头插法的节点
                mHead = cur;
                cur = cur.next;
                nTail = mHead.next;

            }
            else if(cnt==m){
                mHead.next = null;
            }
            else if (cnt<=n) { //开始头插
//                Print.print("插： ",cur.val);

                ListNode tmp = mHead.next;
                mHead.next = cur;
                cur = cur.next;
                mHead.next.next = tmp;

                Print.print(mHead);


            }else { //头插完毕
//                System.out.println("tail: "+ nTail.val+" "+cur.val);
                nTail.next = cur;
//                Print.print(mHead);
                break;

            }

            cnt++;


        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode res = new NC_21().reverse2(head,1,2);

        Print.print(res);



    }


    public ListNode reverseBetween_not_over(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode start = head;
        for (int i = 1; i < m; i ++ ) {
            preStart = start;
            start = start.next;
        }
        // reverse
        for (int i = 0; i < n - m; i ++ ) {
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;
        }
        return dummy.next;
    }
}
