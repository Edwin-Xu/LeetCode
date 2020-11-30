package company.tencent.exam20200906;





import java.util.Scanner;
public class Main1 {
    public Main1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode headA = new ListNode(scanner.nextInt());
        ListNode cur = headA;
        for (int i = 0; i < n-1; i++) {
            cur.next = new ListNode(scanner.nextInt());
            cur = cur.next;
        }


        int m = scanner.nextInt();
        ListNode headB = new ListNode(scanner.nextInt());
        cur = headB;
        for (int i = 0; i < m-1; i++) {
            cur.next = new ListNode(scanner.nextInt());
            cur = cur.next;
        }


        StringBuilder sb = new StringBuilder();

        while (headA!=null && headB!=null){
            if (headA.val==headA.val){
                sb.append(headB.val);
                sb.append(" ");
                headA=headA.next;
                headB= headB.next;
            }else if (headA.val<headB.val){
                headB = headB.next;
            }else{
                headA = headA.next;
            }
        }

        if (sb.length()>0)sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());



    }
    public static void main(String[] args) {
        new Main1();
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

/*
*
AC:


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main1 {
    public Main1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(scanner.nextInt(),0);
        }

        StringBuilder sb = new StringBuilder();

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int tmp = scanner.nextInt();
            if (map.containsKey(tmp)){
                sb.append(tmp);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());



    }
    public static void main(String[] args) {

        new Main1();
    }
}

* */