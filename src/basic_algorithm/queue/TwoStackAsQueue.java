package basic_algorithm.queue;

import java.util.Stack;

/**
 * Created by Edwin Xu on 4/27/2020 2:44 PM
 *
 * 两个栈如何实现一个队列？
 *
 *
 */
public class TwoStackAsQueue {
    private Stack<Integer> s1 ;
    private Stack<Integer> s2 ;

    public TwoStackAsQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();//临时用
    }

    /*
    push的时候：直接push到s1
     */
    public void push(int a){
        s1.push(a);
    }

    //把除栈底外全部移到另一个栈，移除栈底，在把元素移回来
    public boolean pop(){
        if (s1.size()==0){
            System.out.println("Empty");
            return false;
        }
        while (s1.size()!=1){
            s2.push(s1.pop());
        }
        s1.pop();
        while (s2.size()!=0){
            s1.push(s2.pop());
        }
        return true;
    }


    public int peek(){
        if (s1.size()==0){
            System.out.println("Empty");
            return -1;
        }
        while (s1.size()!=1){
            s2.push(s1.pop());
        }
        int res =  s1.peek();
        while (s2.size()!=0){
            s1.push(s2.pop());
        }
        return res;
    }

    public int size(){
        return s1.size();
    }

    public static void main(String[] args) {
        TwoStackAsQueue tsa = new TwoStackAsQueue();
        tsa.push(1);
        tsa.push(2);
        tsa.push(3);
        System.out.println(tsa.size());
        System.out.println(tsa.peek());
        tsa.pop();
        tsa.pop();
        System.out.println(tsa.size());
        System.out.println(tsa.peek());
        /*
        output:
            3
            1
            1
            3
         */
    }
}
