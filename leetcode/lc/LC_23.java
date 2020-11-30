package leetcode.lc;

import leetcode.util.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Edwin Xu on 6/20/2020 4:18 PM
 *
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 *
 * 分析，23题做了两个链表合并的，这里可以两两合并。
 *
 */
public class LC_23 {
    /*
    * 合并两个链表
    * 时间复杂度：O(M+N)
    * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1!=null && l2!=null){
            if (l1.val>l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1==null?l2:l1;
        return res.next;
    }

    /*
    * 这里顺序合并：
    * 这个时间复杂度为O(K(M+N))
    * 不对：
    * 链表不断增长，是K2(M+N )
    *

    * */
    public ListNode mergeKLists_1(ListNode[] lists) {
        if (lists.length==0)return null;
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeTwoLists(res,lists[i]);
        }
        return res;
    }



    /*
    *     *
     * 顺序合并不好
     * 归并合并改进：
     * 分为两两，两两合并之后和其他的两两结果合并
     *
     * 时间复杂度：O(K*log(K)*(M+N))
     *
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length);

    }
    public ListNode merge(ListNode[] lists,int L ,int R){
        if (L==R)return lists[R];
        if (L>R)return null;
        int mid = (L+R)>>>1;
        return mergeTwoLists(merge(lists,L,mid),merge(lists,mid,R));
    }


    /*
    *
    *
    * 方法三：使用优先队列合并
思路

这个方法和前两种方法的思路有所不同，我们需要维护当前每个链表没有被合并的
元素的最前面一个，kk 个链表就最多有 kk 个满足这样条件的元素，每次在这些元
素里面选取 val 属性最小的元素合并到答案中。在选取最小元素的时候，我们可以用
优先队列来优化这个过程。

代码

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/



//    优先级队列是小根堆
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }
}




    public static void main(String[] args) {
    }
}
