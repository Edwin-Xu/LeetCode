package javabasis;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Edwin Xu on 4/27/2020 12:04 AM
 *
 *
 * java Queue机制
 *
 *
 * add 增加一个元索 如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * 　　remove 移除并返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
 * 　　element 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常
 * 　　offer 添加一个元素并返回true 如果队列已满，则返回false
 * 　　poll 移除并返问队列头部的元素 如果队列为空，则返回null
 * 　　peek 返回队列头部的元素 如果队列为空，则返回null
 * 　　put 添加一个元素 如果队列满，则阻塞
 * 　　take 移除并返回队列头部的元素 如果队列为空，则阻塞
 *
 *
 *************************************************
 * 6个方法：
 * 操作        空/满时返回异常      空/满时返回false
 * insert      add                 offer
 * delete      remove              pop
 * select      element             peek
 *************************************************
 *
 *
 *
 * Collection
 *    -List
 *    -Set
 *    -Queue
 *      +Deque
 *      +AbstractQueue
 *      +BlockingQueue
 *          -
 *
 *
 *
 *
 */
public class JavaQueue {



    public static void main(String[] args) {
/*
extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
 */
        Queue<Integer> myQueue = new LinkedList<>();

        myQueue.add(1);
        myQueue.offer(2);
        System.out.println(myQueue.size());
        System.out.println(myQueue.element());
        System.out.println(myQueue.peek());
        myQueue.remove();
        myQueue.poll();

    }

}
