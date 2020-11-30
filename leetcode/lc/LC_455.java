package leetcode.lc;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Edwin Xu on 6/24/2020 8:06 PM
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 注意：
 *
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 *
 * 示例 1:
 *
 * 输入: [1,2,3], [1,1]
 *
 * 输出: 1
 *
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 *
 * 输入: [1,2], [1,2,3]
 *
 * 输出: 2
 *
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 分析：类似0-1背包问题：
 * 价值就是满足的孩子数
 * 重量就是孩子的满足阈值
 *
 * 贪心算法：
 *  这里可能得不到最优解
 *
 *
 * 动态规划：
 *  对每个孩子，决定是否分配饼干，分配那一块
 *  自顶向下分析：现在还剩最后一个孩子，检查还剩下的饼干，没有饼干则不分配了，如果还有饼干：
 *      遍历这些饼干，尝试分配给孩子：
 *          对于每一块饼干：如果孩子需求大于饼干则跳过，否则分配
 *          在这些尝试分配的饼干中，找到最适合的进行实际分配,最适合就是指的最小
 *
 *          -- 这不就是贪心算法：最小即最优
 *
 *          不不不，需要判断是否分配：需要权衡，不是直接把小的分配掉
 *
 *
 *
 * 这题应该可以使用贪心：每次选择最小的饼干给最小的需求，最后结果一定是最优的。
 *  操作上可以是：对两个数组进行排序，然后从头遍历饼干，依次满足学生。
 *  ---其实这种写法就叫做：双指针
 */
public class LC_455 {
    public int findContentChildren(int[] g, int[] s) {
        return dynamicSolution(g,s,g.length-1);
    }

    private int dynamicSolution(int[]g,int[] s,int index){
        if (index<0)return 0;
        int require = g[index];
        int min= 0;
        int minIndex = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i]<require)continue;
            if (s[i]<min){
                min = s[i];
                minIndex = i;
            }
        }
        if (minIndex>=0){
            s[minIndex]=-1;
            return Math.max( dynamicSolution(g,s,index-1)+1,0);
        }
        return dynamicSolution(g,s,index-1);
    }


    /*
    * 都先按从小到大排序，然后一一满足
    * 这样是最优解吗？关键是是否会影响前后的
    *
    * 是可以的：
    * */
    private int sortSolution(int[] g,int[]s){
        List<Integer> L1 = new LinkedList<>();
        for (int i:g)L1.add(i);
        List<Integer> L2 = new LinkedList<>();
        for (int i:s)L2.add(i);
        Collections.sort(L1);
        Collections.sort(L2);

        int ctn = 0;
        while (L1.size()>0 && L2.size()>0){
            int l1 = L1.get(0);
            int l2 = L2.get(0);
            while (l2<l1 && L2.size()>0){
                ((LinkedList<Integer>) L2).removeFirst();
                l2 = L2.get(0);
            }
            if (L2.size()>0){
                ctn++;
                ((LinkedList<Integer>) L1).removeFirst();
                ((LinkedList<Integer>) L2).removeFirst();
            }
        }

        return ctn;
    }
    /*
    * 上面的解法中实现过于复杂，可以优化
    * 首先两次排序，可以使用快排： O(N*log(N))
    * 然后一次遍历
    * */
    class Solution {
        public int findContentChildren(int[] g, int[] s)
        {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0;
            int j = 0;
            int count = 0;
            while (i < g.length && j < s.length)
            {
                if(s[j] >= g[i])
                {
                    count++;
                    i++;
                }
                j++;
            }
            return count;
        }
    }


    public static void main(String[] args) {
        LC_455 lc_455 = new LC_455();
        int [] g = {1,2};
        int []s = {1,2,3};
        System.out.println(lc_455.sortSolution(g,s));
    }

}
