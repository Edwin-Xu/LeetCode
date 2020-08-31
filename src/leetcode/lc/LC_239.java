package leetcode.lc;

import leetcode.util.Print;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Edwin Xu on 8/19/2020 5:36 PM
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *
 *
 *
 *
 */
public class LC_239 {
    /*
    * 第一思路，使用最大堆，滑动窗口
    * 超时：堆操作太耗时了
    * */
    public int[] maxSlidingWindow_stack(int[] nums, int k) {
        Queue<Integer> maxStack = new PriorityQueue<>((x,y)->y-x);
        for (int i = 0; i <k ; i++) {
            maxStack.add(nums[i]);
        }
        int res[] = new int[nums.length-k+1];
        res[0] = maxStack.peek();
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            maxStack.remove(nums[i-k]);
            maxStack.add(nums[i]);
            res[index++] = maxStack.peek();
        }
        return res;
    }

    /*
    * 不使用堆：部分窗口需要重新计算最大值
    * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <k ; i++) {
            if (nums[i]>max)max = nums[i];
        }
        int res[] = new int[nums.length-k+1];
        res[0] = max;
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            if (nums[i-k]<max && nums[i]>=max){

            }else{
                max = nums[i-k+1];
                for(int j=i-k+2;j<=i;j++)if (nums[j]>max)max = nums[j];
            }
            res[index++] = max;
        }
        return res;
    }

    /*
    * 使用双向队列：
    * 使用堆的add、remove效率太差
    *
    * 仔细思考发现
    *
    *
我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。

存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。

算法

算法非常直截了当：

处理前 k 个元素，初始化双向队列。

遍历整个数组。在每一步 :

清理双向队列 :

  - 只保留当前滑动窗口中有的元素的索引。

  - 移除比当前元素小的所有元素，它们不可能是最大的。
将当前元素添加到双向队列中。
将 deque[0] 添加到输出中。
返回输出数组。


这个实际上是一个单调栈：
每次往栈中添加，先移除比当前都小的，因为他们不可能是最大值
1,3,-1,-3,5,3,6,7
栈1
添加3 ，移除-1： 3



    * */
    class Solution {
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        int [] nums;

        public void clean_deque(int i, int k) {
            // remove indexes of elements not from sliding window
            if (!deq.isEmpty() && deq.getFirst() == i - k)
                deq.removeFirst();

            // remove from deq indexes of all elements
            // which are smaller than current element nums[i]
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            // init deque and output
            this.nums = nums;
            int max_idx = 0;
            for (int i = 0; i < k; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                // compute max in nums[:k]
                if (nums[i] > nums[max_idx]) max_idx = i;
            }
            int [] output = new int[n - k + 1];
            output[0] = nums[max_idx];

            // build output
            for (int i  = k; i < n; i++) {
                clean_deque(i, k);
                deq.addLast(i);
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }
    }
/*
* 这个维护逻辑就是单调栈（Monotonous Stack，也可以说是单调队列）。
* 本题根据题设，是要求栈上元素只能单调递减，即[5,4,3,1]是一个有效的单调栈状态，
* 当遇到了新元素2，则不能直接压栈（否则就不单调递减了），必须先把比2小的元素（
* 即末尾的1）弹出，再压栈——[5,4,3,2]。在题目中，实际上栈中的元素总是滑动窗口元素
* 的子集（因为可能有弹出操作），所以栈顶元素必然是窗口的最大值。但是随着窗口移动，栈顶
* 需要退出窗口，所以，题解在维护单调栈的时候用的是元素下标，而非元素实际的值，就是为了
* 判断栈顶何时出栈（当窗口左端已经pass栈顶下标的时候）
*
*
* */




    /*
    * 滑动窗口
    *
    *https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
    *
    * */

    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            int [] left = new int[n];
            left[0] = nums[0];
            int [] right = new int[n];
            right[n - 1] = nums[n - 1];
            for (int i = 1; i < n; i++) {
                // from left to right
                if (i % k == 0) left[i] = nums[i];  // block_start
                else left[i] = Math.max(left[i - 1], nums[i]);

                // from right to left
                int j = n - i - 1;
                if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
                else right[j] = Math.max(right[j + 1], nums[j]);
            }

            int [] output = new int[n - k + 1];
            for (int i = 0; i < n - k + 1; i++)
                output[i] = Math.max(left[i + k - 1], right[i]);

            return output;
        }
    }



    public static void main(String[] args) {
        LC_239 lc_239 = new LC_239();
        int a[] = {1,3,-1,-3,5,3,6,7};
        int res[]= lc_239.maxSlidingWindow(a,3);
        for (int i:res    ) {
            System.out.println(i);
        }
    }
}
