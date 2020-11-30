package leetcode.lc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Edwin Xu on 4/4/2020 3:15 PM
 *
 * Trapping Rain Water
 *
 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，
 下雨之后能接多少雨水。

 */

public class LC_42 {
    /*
    * 我的解法：
    *  * 从第一个柱子开始，寻找第一个比它高的，即可组成一个槽,
       * 如果没有更高的，就找到后面最高的，这时也可以组成一个槽
    *
    * */
    public int trap_edwinxu(int[] height) {
        int len = height.length;
        int rainCount = 0;//雨量
        for (int i=0;i<len-1;i++){
            if (height[i+1]>height[i])continue;//如果这个柱子比下一个低，跳过。
            int highter = height[i];//后面更高的柱子高度
            int highterIndex = i;//后面更高的柱子索引
            int max = height[i+1];//后面的最高柱子
            int maxIndex = i+1;
            boolean hasHighter = false;//后面是否存在比当前柱子更高的柱子
            for (int j=i+1;j<len;j++){
                if (height[j]>=highter){//找到不低于当前柱子的柱子
                    highterIndex = j;
                    hasHighter = true;
                    break;
                }
                if (height[j]>max){//计算后面最高的
                    max = height[j];
                    maxIndex = j;
                }
            }
            if (!hasHighter) {//如果后面没有更高的柱子，就是用后面的最高柱子
                highterIndex = maxIndex;
                highter = max;
            }
            for (int j=i+1;j<highterIndex;j++){//计算这个槽可以几类的雨量
                rainCount+=highter-height[j];
            }
            i=highterIndex-1;//跳到这个槽的右边柱子
        }
        return rainCount;
    }


    /*
    * 动态规划
    *
    * 动态规划是真的可以。
    *
    * 对于每一个柱子：找出其左边最大的L，右边最大的R。
    * 然后遍历柱子，每一个柱子装的水 = min(L,R)-高度
    * */
    public int trap_dp(int[] height) {
        if (height==null || height.length==0)return 0;
        int len = height.length;
        //对于每一个柱子
        int leftMax [] = new int[len];
        int rightMax [] = new int[len];

        leftMax[0] = height[0];
        for (int i = 1; i <len ; i++) {
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        rightMax[len-1] = height[len-1];
        for (int i = len-2; i >=0 ; i--) {
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        int res = 0;
        for (int i = 0; i <len ; i++) {
            res+=Math.min(leftMax[i],rightMax[i])-height[i];
        }

        return res;
    }

   /*
    * 栈
    * */
    public int trap_stack(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height; //长乘宽
            }
            stack.push(current++);
        }
        return ans;
    }



    public static void main(String[] args) {
        int [] a = {1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new LC_42().trap_edwinxu(a));
    }
}
