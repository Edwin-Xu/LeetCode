package leetcode.util;

/**
 * Created by Edwin Xu on 5/16/2020 11:39 AM
 */
public class ListNode {
    public int val;
    public    ListNode next;
    public ListNode(int x) { val = x; }
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