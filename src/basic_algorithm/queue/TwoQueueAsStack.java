package basic_algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Edwin Xu on 4/27/2020 12:21 PM
 *
 * 如何使用两个队列实现一个栈
 *
 *
 * analysis:
 * 假设有队列 q1,q2
 * 初始想法是利用 q2把q1反向，形成后来的在队尾，但是由于队列的方向是固定的，
 * 不论你怎么摆弄，都不可能反向：一个队列出去的，也必定先进入另一个队列——顺序始终不变
 *
 * 现在考虑：不反向，push进去的顺序不要管，只需要关系pop、peek
 * 具体实现：push时只向一个队列添加，维持一个队列为空
 *         需要pop时，把当前队列的前size-1个元素放到另一个空队列，本队列清空
 *         peek时，返把所有元素放到另一个队列，同时返回最后一个，本队列清空
 *
 */
public class TwoQueueAsStack {
    private Queue<Integer> q1 ;
    private Queue<Integer> q2 ;
    private Queue<Integer> cur;
    private Queue<Integer> empty;

    public TwoQueueAsStack(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    //调整队列，使cur指向q1\q2中用于存放元素的队列，empty指向空队列
    private void adjust(){
        cur  =q1.size()==0?q2:q1;
        empty=q1.size()==0?q1:q2;
    }

    public void push(int a){
        adjust();
        cur.offer(a);
    }
    public boolean pop(){
        adjust();
        if (cur.size()==0)return false; //为空
        while (cur.size()!=1){
            empty.offer(cur.poll());
        }
        cur.poll();
        return true;
    }
    public int peek(){
        adjust();
        if (cur.size()==0){
            System.out.println("empty");//为空
            return -1;
        }
        while (cur.size()!=1){
            empty.offer(cur.poll());
        }
        int res = cur.poll();
        empty.offer(res);
        return res;
    }
    public int size(){
        return Math.max(q1.size(),q2.size());
    }

    public static void main(String[] args) {
        TwoQueueAsStack tqa =  new TwoQueueAsStack();
        tqa.push(1);
        tqa.push(2);
        tqa.push(3);
        System.out.println(tqa.size());
        System.out.println(tqa.peek());
        tqa.pop();
        tqa.pop();
        System.out.println(tqa.peek());
        System.out.println(tqa.size());
    }
}
