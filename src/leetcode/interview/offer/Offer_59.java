package leetcode.interview.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Edwin Xu on 7/8/2020 9:37 PM
 *
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 *
 *
 *
 *
 * 为了解决上述问题，我们只需记住当前最大值出队后，队列里的下一个最大值即可。
 *
 * 具体方法是使用一个双端队列 dequedeque，在每次入队时，如果 dequedeque 队尾元素小于即将入队的元素 valuevalue，则将小于 valuevalue 的元素全部出队后，再将 valuevalue 入队；否则直接入队
 *
 * 作者：z1m
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/ru-he-jie-jue-o1-fu-za-du-de-api-she-ji-ti-by-z1m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *
 *
 *
 *
 * 维护一个辅助队列——双端队列:用户存储当前最大值。
 * 依次把元素放入主队列，对于辅助队列，把辅助队列队尾小于当前值的都弹出，再把当前值加入。
 *
 */
public class Offer_59 {

    public static void main(String[] args) {
        Queue<Integer> l = new LinkedBlockingQueue<>();
        l.add(1);
        l.add(2);
        System.out.println(l.poll());
        System.out.println(l.size());
    }


class MaxQueue {

    LinkedList<Integer> l = new LinkedList<>();
    LinkedList<Integer> max = new LinkedList<>();

    public MaxQueue() {
    }
    public int max_value() {
        if(max.size()==0)return -1;
        return max.getFirst();
    }
    public void push_back(int value) {
        l.add(value);
        while (max.size()>0 && value>=max.peek()){
            max.pop();
        }
        max.push(value);
    }

    public int pop_front() {
        if (l.size()==0)return -1;
        if (max.peek()==l.peek())max.pop();
        return  l.removeFirst();
    }



}
}

/*
*
* 1 2 2 3 1 5 4
* 1 2 2 3 3 5
*
*
* */