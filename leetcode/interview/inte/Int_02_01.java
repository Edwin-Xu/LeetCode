package leetcode.interview.inte;

import leetcode.util.ListNode;

import java.util.HashMap;

/**
 * Created by Edwin Xu on 6/26/2020 8:13 PM
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * analysis:
 *  关键点：检测一个节点是否出现过
 *
 *
 *  方法1：使用HashMap来存放出现的节点
 *  （Set更快吗？）
 *
 *  使用HashSet：Set<Integer> occurred = new HashSet<Integer>();
 *
 *
 *
 *
 *
 *  本题要想O(N)必须使用额外空间，如果不使用：
 *  两重循环，遍历：从当前元素向后，把与当前相同的都移除掉，最后就一定没有重复的了
 */
public class Int_02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head==null)return head;
        HashMap<Integer,Integer> map = new HashMap<>(1024,1);
        ListNode cur = head;
        ListNode next = head.next;
        map.put(head.val,0);
        while (next!=null){
            if (map.containsKey(next.val)){
                cur.next = next.next;
            }else{
                map.put(next.val,0);
                cur = next;
            }
            next = next.next;
        }
        return head;
    }
}




















