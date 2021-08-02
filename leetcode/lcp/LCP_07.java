package leetcode.lcp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Edwin Xu
 * @date 7/1/2021 1:57 PM.
 * <p>
 * LCP 07. 传递信息
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * <p>
 * 输出：3
 * <p>
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 * <p>
 * 输出：0
 * <p>
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 */

public class LCP_07 {


    public int numWays(int n, int[][] relation, int k) {
        if (relation == null || relation.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(n*2);
        for (int[] re : relation) {
            map.putIfAbsent(re[0], new ArrayList<>());
            map.get(re[0]).add(re[1]);
        }

        dfs(n, map, k, 0);

        return cnt;
    }

    private int cnt = 0;

    private void dfs(int n, Map<Integer, List<Integer>> map, int k, int cur) {
        if (k<0){
            return;
        }
        if (k == 0) {
            if (cur == n - 1) {
                cnt++;
            }
            return;
        }
        List<Integer> list = map.get(cur);
        if (list != null) {
            for (Integer from : list) {
                dfs(n, map, k - 1, from);
            }
        }
    }



    /**
     * 除了DFS、BFS外，还可以使用动态规划DP
     * 对于传信息的关系 [\textit{src},\textit{dst}][src,dst]，如果第 ii 轮传递到编号 \textit{src}src 的玩家，则第 i+1i+1 轮可以从编号 \textit{src}src 的玩家传递到编号 \textit{dst}dst 的玩家。因此在计算 \textit{dp}[i+1][\textit{dst}]dp[i+1][dst] 时，需要考虑可以传递到编号 \textit{dst}dst 的所有玩家。由此可以得到动态规划的状态转移方程，其中 0 \le i < k0≤i<k：
     *
     * \textit{dp}[i+1][\textit{dst}]=\sum_{[\textit{src},\textit{dst}] \in \textit{relation}} \textit{dp}[i][\textit{src}]
     * dp[i+1][dst]=
     * [src,dst]∈relation
     * ∑
     * ​
     *  dp[i][src]
     *
     * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi/solution/chuan-di-xin-xi-by-leetcode-solution/
     * */
    public int numWaysDP(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }













    public static void main(String[] args) {
        int n = 3;
        int[][] relation = new int[][]{
                {2,0},{0,1},{1,2},{1,0},{2,1},{0,2}
        };
        int k = 3;

        LCP_07 lcp07 = new LCP_07();
        System.out.println(lcp07.numWays(n, relation, k));
    }

}
