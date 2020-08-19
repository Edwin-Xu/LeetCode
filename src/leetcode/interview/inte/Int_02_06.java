package leetcode.interview.inte;

import leetcode.util.ListNode;

import java.util.ArrayList;

/**
 * Created by Edwin Xu on 6/25/2020 4:30 PM
 *
 * 编写一个函数，检查输入的链表是否是回文的。
 */
public class Int_02_06 {

    /*
    * 最朴素的想法：把元素取出来称为数组，然后比较
    * */
    public boolean isPalindrome_1(ListNode head) {
        ArrayList<Integer> a = new ArrayList<>();
        while(head!=null){
            a.add(head.val);
            head = head.next;
        }
        for(int i=0,j=a.size()-1;i<j;i++,j--){
            //System.out.println(a.get(i).equals(a.get(j)));
            if(!a.get(i).equals(a.get(j)))return false;
        }
        return true;
    }

    /*
    * 链表分为两段，然后判断
    *
    *
    * 怎么分段，这里就很有意思了：
    * 使用快慢指针，当快指针走到链表尾的时候，慢指针在中间。
    *
    *
    * 找到中间后反转第二段链表，然后比较
    * */
    public boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        /*
        * 此时如果fast==null，表示链表长度为奇数。
        * 不管哪种情况，都可以直接从slow向后翻转:slow要么指向中间那个，要么指向第二段一个个
        * */
        if (fast!=null)slow= slow.next; //现在slow指向后半段第一个
//        System.out.println(slow.val);

//        翻转使用头插法：以slow为头结点的链表
        ListNode dummy = new ListNode(-1);
        ListNode tmp;
        while (slow!=null){
            tmp = slow.next;
            slow.next = dummy;
            dummy =slow;
            slow =tmp;
        }
        while (dummy.val!=-1){
            System.out.println(head.val+" "+dummy.val);
            if (head.val!=dummy.val)return false;
            head = head.next;
            dummy = dummy.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        System.out.println(new Int_02_06().isPalindrome(head));
    }
}
