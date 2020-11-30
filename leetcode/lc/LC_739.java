package leetcode.lc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Edwin Xu on 8/2/2020 1:34 AM
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 *
 */
public class LC_739 {
    //暴力
    public int[] dailyTemperatures_(int[] T) {
        int res[] = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int j=i+1;
            for (;j<T.length;j++){
                if (T[j]>T[i])break;
            }
            if (j==T.length)res[i]=0;
            else res[i]=j-i;

        }
        return res;
    }


    //    方法二：单调栈
    /*
    * 一个单调递减栈：存下标
    * 栈空：放进去
    * 栈不空：当前元素cur比较栈顶元素top：
    *       cur>top: res[top] = cur-top;
    *       else: cur入栈
    * */
    public int[] dailyTemperatures_stack(int[] T) {
        int res[] = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (s.isEmpty())s.push(i);
            while (!s.isEmpty() && T[s.peek()]<T[i]){
                res[s.peek()]=i-s.pop();
            }
            s.push(i);
        }
        return res;
    }






//    方法二：单调栈
        public int[] dailyTemperatures_officialSolution(int[] T) {
            int length = T.length;
            int[] ans = new int[length];
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < length; i++) {
                int temperature = T[i];
                while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                    int prevIndex = stack.pop();
                    ans[prevIndex] = i - prevIndex;
                }
                stack.push(i);
            }
            return ans;
        }

//方法三：从后往前，利用已经找到的结果
//    最优解
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        //从后面开始查找
        for (int i = res.length - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < res.length) {
                if (T[j] > T[i]) {
                    //如果找到就停止while循环
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    //如果没找到，并且res[j]==0。说明第j个元素后面没有
                    //比第j个元素大的值，因为这一步是第i个元素大于第j个元素的值，
                    //那么很明显这后面就更没有大于第i个元素的值。直接终止while循环。
                    break;
                } else {
                    //如果没找到，并且res[j]！=0说明第j个元素后面有比第j个元素大的值，
                    //然后我们让j往后挪res[j]个单位，找到那个值，再和第i个元素比较
                    j += res[j];
                }
            }
        }
        return res;
    }

}