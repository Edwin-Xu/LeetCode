package leetcode.lc;

import java.util.Stack;

/**
 * Created by Edwin Xu on 5/12/2020 11:18 AM
 *
 * 设计一个支持 push ，pop ，top 操作，并能在*常数*时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 */

//方式1：辅助栈+同步
// 辅助栈和数据栈同步，且相应位置存放其下元素中最小值
public class LC_155 {
    private Stack<Integer> stack;
    private Stack<Integer> helper;
    public LC_155() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (helper.isEmpty())helper.push(x);
        else helper.push(x>helper.peek()?helper.peek():x);
    }

    public void pop() {
        helper.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return helper.peek();
    }

    public static void main(String[] args) {
//        Integer x = new Integer(12);
//        Integer y = new Integer(12);
//        int z = 12;
//        System.out.println(x==y);
//        System.out.println(x==z);

//        System.out.println(Integer.toBinaryString(536870912));
//        System.out.println(Integer.toBinaryString(536870912).length());

        MinStack_SingleStack ms = new MinStack_SingleStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());

//        System.out.println(Long.toBinaryString(1L));
//        System.out.println(Long.toBinaryString(-1L<<32  |1));
//        System.out.println(Long.toBinaryString(-(1L<<32)));


//        int x = -2;
//        System.out.println(Integer.toBinaryString(x));
//        int y =-2;
//        System.out.println(Integer.toBinaryString(y));
//
//        long z = ((long)x<<32);
//        System.out.println(Long.toBinaryString(z));
//        System.out.println(z);
//
//        System.out.println(Long.toBinaryString(((long)y)&4294967295L));
//        long m = z| ((long)y)&4294967295L;
//        System.out.println(z+"+"+(((long)y)&4294967295L)+"="+m);
//        System.out.println(Long.toBinaryString(m));
//        System.out.println(z);

//        System.out.println(Long.valueOf("0000000000000000000000000000000011111111111111111111111111111111",2));

    }
}


/*
方式2：辅助栈+不同步
辅助栈和数据栈维持相同大小--空间开销
如何减少空间开销？？？
可以重减少辅助栈中重复值入手：
例：
插入1,2,3，辅助栈中存放的全部是1，造成了空间浪费：

现在考虑插入时，辅助栈只存放小于当前最小值的。
辅助栈的出栈怎么办？
举例：
1  1
2  0
1
0
3
只有当两个栈栈顶相同的时候辅助栈才出栈，数据栈3出栈时辅助栈0不出栈，0出栈时它才出栈
问题来了：数据栈1出栈时把辅助栈的1带出栈了，造成不匹配。
原因就是插入时的重复值问题，入栈时和最小值相同才行，才能在出栈时不被破坏。

于是改变原来的策略：当前元素<=最小值时辅助栈插入，只有大于时不插入。
上面的例子：
1  1
2  1
1  0
0
3
操作：
数据栈3出栈，辅助栈不出栈，最小值还是0
数据栈0出栈，辅助栈0也出栈，最小值是1
数据栈1出栈，辅助栈1出栈，最小值是1
数据栈2出栈，辅助栈1不出栈，最小值是1
数据栈1出栈，辅助栈1也出栈，两个栈皆空
可见算法是可以工作的。

减少了空间，必然由于各种判断增加时间
 */

class MinStack{
    private Stack<Integer> stack;
    private Stack<Integer> helper;
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (helper.isEmpty())helper.push(x);
        else if(x<=helper.peek()){
            helper.push(x);
        }
    }

    public void pop() {
        int tmp= stack.pop();
        if (helper.peek()==tmp) helper.pop();
    }

    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return helper.peek();
    }
}


/*
方法3：
如何不使用辅助栈？？
从数据上入手：
默认数据是int型
栈使用long型
|--32--|--32--|
 当前值  最小值
拿到一个值，左移32位，比较最小值，把当前最小值存在0-32位

前32位和后32不应该使用+-这种操作，他们不应该发生运算
按道理不对啊
int左移32位，右32位位0
在加一个32位数，并不影响右32位啊

*/

class MinStack_SingleStack{
    private Stack<Long> stack;
    public MinStack_SingleStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty())stack.push(((long)x)<<32 |x);
        else {
            long min = stack.peek()>>32;
            stack.push(x<min?(long)(x<<32 | x):((long)x<<32 | min));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return (int)(stack.peek()&(1L<<32)>>32);
    }
    public int getMin() {
        return (int)(stack.peek()*1);
    }



}