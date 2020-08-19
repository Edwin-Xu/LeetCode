package leetcode.interview.offer;

import leetcode.util.Print;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Edwin Xu on 7/5/2020 1:43 PM
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_31 {
    private Stack<Integer> stack = new Stack<>();
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        stack.clear();
//        int p = 0, q=0;
//        while (q<popped.length){
//            while (!stack.isEmpty() && q<popped.length&& stack.peek()==popped[q]){
//                q++;
//                stack.pop();
//            }
//
//            while (pushed[p]!=popped[q]){
//                stack.push(pushed[p++]);
//                if (p==pushed.length)return false;
//            }
//            q++;
//            p++;
//        }
        /*
        * 搞复杂了，就他妈这么一个简单的题
        *
        * 看下面：
        * 遍历pushed，每次添加，连续判断是否和poped中前面的一样，一样就弹出
        *
        * 最后如果是正确的序列的话，所有元素都会被弹出。
        * */



        for (int i = 0,j=0; i <pushed.length && j <popped.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek()== popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int b[] = {4,3,5,2,1};
        System.out.println(new Offer_31().validateStackSequences(a,b));


    }
}
