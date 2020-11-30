package leetcode.lc;

import company.qyff.Main;

import java.util.*;

/**
 * Created by Edwin Xu on 11/6/2020 12:03 AM.
 *
 * 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */

public class LC_414 {
    // 排序:O(NlogN)  2MS
    public int thirdMax_sort(int[] nums) {
        Arrays.sort(nums);
        Set<Integer>set = new HashSet<>();
        for(int i = nums.length-1;i>=0;i--){
            set.add(nums[i]);
            if(set.size()==3){
                return nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int n: set){
            max = Math.max(n,max);
        }
        return max;
    }

    //堆：O(N)
    //堆长度为3
    //最小堆
    public static int thirdMax_heap(int[] nums) {
        if (nums==null || nums.length==0)return 0;
        int len = nums.length;
        if (len<3){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }

        PriorityQueue<Integer> queue =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <len ; i++) {
            if (!set.contains(nums[i])){
                if (queue.size()<3 ){
                    queue.add(nums[i]);
                    set.add(nums[i]);
                }else if (nums[i]>queue.peek()){
                    set.remove(queue.poll());
                    queue.add(nums[i]);
                    set.add(nums[i]);
                }
            }
        }
        if (queue.size()<3){
            while (queue.size()>1)queue.poll();
        }
        return queue.poll();
    }


    /*
    * 更好的解法：
    * 维护三个变量即可
    * */
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num : nums) {
            if(num>first){
                third = second;
                second = first;
                first = num;
            }else if(num>second&&num<first){
                third = second;
                second = num;
            }else if(num<second&&num>third){
                third = num;
            }
        }
        return third!=Long.MIN_VALUE ? new Long(third).intValue() : new Long(first).intValue();
    }




    public static void main(String[] args) {
        int []arr = new int[]{
                3,2,1
        };
        System.out.println(thirdMax_heap(arr));  ;
    }


}
