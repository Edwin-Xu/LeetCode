package leetcode.lc;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 11/18/2020 4:23 PM.
 *
 *
 * 134. 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明:
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 *
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * 输出: 3
 *
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 */

public class LC_134 {
    /**
     * 一个一个尝试:
     *
     * 时间复杂度比较高，最坏情况下是O(N2)
     *
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i <gas.length ; i++) {
            int startIndex = canTraversal(gas,cost,i);
            if (startIndex>=0) {
                return startIndex;
            }
        }
        return -1;
    }
    /**
    * @param start 起点
    * */
    public int canTraversal(int[] gas, int[] cost, int start){
        int gasLeft = 0;
        int gasStationNum  =gas.length;
        for (int i = 0; i <gasStationNum; i++) {
            int gasStationIndex = (i+start)%gasStationNum;
            // 补充了汽油
            gasLeft += gas[gasStationIndex];
            //开到下一个加油站需要消耗油
            gasLeft -= cost[gasStationIndex];
            // 不能开到下一个加油站
            if (gasLeft<0){
                return -1;
            }
        }
        return start;
    }



    /**
     *可以使用图的思想来分析，时间复杂度 O(N)，空间复杂度 O(1)。
     *
     * 以该题为例：
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     * 下图的黑色折线图即总油量剩余值，若要满足题目的要求：跑完全程再回到起点，总油量剩余值的任意部分都需要在X轴以上，且跑到终点时：总剩余汽油量 >= 0。
     *
     * 为了让黑色折线图任意部分都在 X 轴以上，我们需要向上移动黑色折线图，直到所有点都在X轴或X轴以上。此时，处在X轴的点即为出发点。即黑色折线图的最低值的位置：index = 3。
     *
     * 链接：https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
     *
     * 太妙了，直接找最小的油量，其对应的索引就是起点。
     * */
    public int canCompleteCircuitByGraph(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }





    /**
     *  在发现了这一个性质后，算法就很清楚了：我们首先检查第 00 个加油站，并试图判断能否环绕一周；如果不能，就从第一个无法到达的加油站开始继续检查。
     *  https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode-solution/
     *
     */
    public int canCompleteCircuitByOfficialSoulution(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(new LC_134().canCompleteCircuit(gas,cost));
    }
}
