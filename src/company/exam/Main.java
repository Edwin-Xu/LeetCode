package company.exam;

/*
模拟Queue

问题：测试用例最后没有换行


 */

import java.util.LinkedList;
import java.util.Scanner;

class MyQueue{
    private LinkedList<Integer> list= new LinkedList<>();
    public void push(int a){
        list.add(a);
    }
    public void top(){
        if (list.size()==0){
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(0));
        }
    }
    public void pop(){
        if (list.size()==0) System.out.println(-1);
        else list.removeFirst();
    }
    public void size(){
        System.out.println(list.size());
    }
    public void clear(){
        list.clear();
    }
}

public class Main {
    private Scanner sc ;
    private int T;
    private int Q;
    private MyQueue myQueue ;
    private String ord;
    private String o;
    private int num;


    public  Main(){
        sc = new Scanner(System.in);
        myQueue = new MyQueue();
        T = Integer.valueOf(sc.nextLine());
        for(int i=0;i<T;i++){
            Q =  Integer.valueOf(sc.nextLine());
            for (int j=0;j<Q;j++){
                ord= sc.nextLine();
                o=ord.substring(0,2);
                if (o.equals("PU")){
                    num = Integer.valueOf( ord.split(" ")[1]);
                    myQueue.push(num);
                }else if (o.equals("TO"))myQueue.top();
                else if (o.equals("PO"))myQueue.pop();
                else if (o.equals("SI"))myQueue.size();
                else if (o.equals("CL"))myQueue.clear();
                else System.out.println("wrong");
            }
        }

        sc.close();
    }

    public static void main(String[] args) {
        new Main();
    }
}

/*
2
7
PUSH 1
PUSH 2
TOP
POP
TOP
POP
POP
5
PUSH 1
PUSH 2
SIZE
POP
SIZE

 */