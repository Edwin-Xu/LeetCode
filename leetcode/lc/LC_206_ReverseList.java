package leetcode.lc;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 6/28/2020 8:23 PM
 */
public class LC_206_ReverseList {
    //先使用头插法:7行代码
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head!=null){
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head =tmp;
        }
        return dummy.next;
    }
//1 2 3
    //递归
    public ListNode reverse(ListNode head){
        if (head==null||head.next==null)return head;
        ListNode next = head.next;
        head.next=null;
        ListNode newHead = reverse(next);
        next.next=head;
        return newHead;
    }
    /*
    * 递归版本稍微复杂一些，其关键在于反向工作。假设列表的其余部分已经被反转，现在我该如何反转它前面的部分？

假设列表为：

n_{1}\rightarrow ... \rightarrow n_{k-1} \rightarrow n_{k} \rightarrow n_{k+1} \rightarrow ... \rightarrow n_{m} \rightarrow \varnothing
n
1
​
 →...→n
k−1
​
 →n
k
​
 →n
k+1
​
 →...→n
m
​
 →∅

若从节点 n_{k+1}n
k+1
​
  到 n_{m}n
m
​
  已经被反转，而我们正处于 n_{k}n
k
​
 。

n_{1}\rightarrow ... \rightarrow n_{k-1} \rightarrow n_{k} \rightarrow n_{k+1} \leftarrow ... \leftarrow n_{m}
n
1
​
 →...→n
k−1
​
 →n
k
​
 →n
k+1
​
 ←...←n
m
​


我们希望 n_{k+1}n
k+1
​
  的下一个节点指向 n_{k}n
k
​
 。

所以，n_{k}n
k
​
 .next.next = n_{k}n
k
​
 。

要小心的是 n_{1}n
1
​
  的下一个必须指向 Ø 。如果你忽略了这一点，你的链表中可能会产生循环。如果使用大小为 2 的链表测试代码，则可能会捕获此错误。
    * */
    public ListNode reverseList_officesolution(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode res = new LC_206_ReverseList().reverse(head);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
