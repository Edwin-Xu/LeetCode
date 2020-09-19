package leetcode.nowcoder.nc;

import leetcode.util.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Edwin Xu on 9/19/2020 12:25 AM
 * <p>
 * 题目描述
 * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 示例1
 * 输入
 * 复制
 * [[1,3],[1,2],[1,1],[3],[2],[3]]
 * 输出
 * 复制
 * [1,2]
 */
public class NC_90 {

    public int[] getMinStack(int[][] ops) {
        List<Integer> list = new ArrayList<>();
        MinStack ms = new MinStack();
        for (int[] op : ops) {
            if (op[0] == 1) {
                ms.push(op[1]);
            } else if (op[0] == 2) {
                ms.pop();
            } else {
                list.add(ms.getMin());
            }
        }

        int res[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    class MinStack {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public int getMin() {
            return s2.peek();
        }

        public void push(int n) {
            s1.push(n);
            if (s2.isEmpty()) s2.push(n);
            else s2.push(Math.min(s2.peek(), n));
        }

        public void pop() {
            s1.pop();
            s2.pop();
        }
    }

    class MinStack_Not_Sync{
        private Stack<Integer> stack;
        private Stack<Integer> helper;
        public MinStack_Not_Sync() {
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


    public static void main(String[] args) {
//        for (int i = 0; i <100 ; i++) {
//            int L = (int)(50*Math.random());
//            int R = (int)(50*Math.random())+50;
//            Print.print((L+ (R-L)/2) == (R+L)/2 );
//        }
    }
}
