package leetcode.lc;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Edwin Xu on 8/2/2020 7:18 PM
 * 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class LC_295 {

    /*
    * 最基本的就是排序了
    * 插入排序比较适合： O(N)， 下面堆则是log(N)
    * */

    /*
     * 使用一个最大堆Max，一个最小堆Min
     * 保证二者个数差<=1
     * 插入一个数X时：
     *   插入到个数小的一个，数量一样插最大堆
     * */
    class MedianFinder {

        /**
         * initialize your data structure here.
         */
        private Queue<Integer> maxQ = new PriorityQueue<>((x, y) -> {
            return y-x;
        });
        private Queue<Integer> minQ = new PriorityQueue<>((x, y) -> {
            return x-y;
        });

        public MedianFinder() {

        }

        /*
         * 插入时：判断再插入
         * 或者插入max，再调整--不行???
         *
         * */
        public void addNum(int num) {
            maxQ.add(num);
            if (maxQ.size()>minQ.size()+1){
                minQ.add(maxQ.poll());
            }
            //需要调整
            if (minQ.size()>0 && maxQ.size()>0 && maxQ.peek()>minQ.peek()){
                int t = maxQ.poll();
                maxQ.add(minQ.poll());
                minQ.add(t);
            }

        }

        public double findMedian() {
            int a = maxQ.size();
            int b = minQ.size();
            if (a == b) return (maxQ.peek() + minQ.peek()) / 2.0;
            else if (a < b) return minQ.peek();
            else return maxQ.peek();
        }
    }


    /*
    *
    * 方法四：Multiset 和双指针
自平衡二进制搜索树（如AVL树）具有一些非常有趣的特性。它们将树的高度保持在对数范围内。
因此，插入新元素具有相当好的时间性能。中值总是缠绕在树根或它的一个子树上。使用与方法
 3 相同的方法解决这个问题，但是使用自平衡二叉树似乎是一个不错的选择。但是，实现这样
 一个树并不是简单的，而且容易出错。
    * */

    public static void main(String[] args) {
        /*
        *
        * ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
        *
        * */

        LC_295 lc_295 = new LC_295();
        MedianFinder medianFinder = lc_295.new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
//[null,null,-1.0,null,-1.5,null,-2.0,null,-2.5,null,-3.0]




    }



}
