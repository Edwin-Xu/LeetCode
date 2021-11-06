package leetcode.lc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.Consumer;

/**
 *  给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。
 *
 * 实现 SummaryRanges 类：
 *
 * SummaryRanges() 使用一个空数据流初始化对象。
 * void addNum(int val) 向数据流中加入整数 val 。
 * int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author taoxu.xu
 * @date 10/9/2021 8:08 PM
 */
public class LC_352 {
    class SummaryRanges {

        private PriorityQueue<Integer> queue = new PriorityQueue<>();
        private Set<Integer> set = new HashSet<>();
        public SummaryRanges() {

        }

        public void addNum(int val) {
            if (!set.contains(val)){
                queue.add(val);
                set.add(val);
            }
        }

        public int[][] getIntervals() {
            if (queue.isEmpty()){
                return new int[0][0];
            }else if (queue.size() == 1){
                Integer peek = queue.peek();
                return new int[][]{
                        {peek, peek}
                };
            }else{
                PriorityQueue<Integer> queueTmp = new PriorityQueue<>();
                LinkedList<int[]> list = new LinkedList<>();

                while (!queue.isEmpty()){
                    int start = queue.poll();
                    int end = start;
                    queueTmp.add(end);
                    while (!queue.isEmpty()){
                        if (queue.peek() == end+1){
                            end = queue.poll();
                            queueTmp.add(end);
                        }else{
                            break;
                        }
                    }
                    list.add(new int[]{start, end});
                }
                int[][] res = new int[list.size()][2];
                Iterator<int[]> iterator = list.iterator();
                int index = 0;
                while (iterator.hasNext()){
                    res[index++] = iterator.next();
                }
                queue = queueTmp;
                return res;
            }
        }
    }
}
