package leetcode.lc;

//没有人永远年轻，但是永远有人年轻


import java.util.*;

/**
 * Created by Edwin Xu on 10/24/2020 11:16 PM.
 *
 * 1024. 视频拼接
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * 输出：3
 * 解释：
 * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
 * 然后，按下面的方案重制比赛片段：
 * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
 * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * 示例 2：
 *
 * 输入：clips = [[0,1],[1,2]], T = 5
 * 输出：-1
 * 解释：
 * 我们无法只用 [0,1] 和 [1,2] 覆盖 [0,5] 的整个过程。
 * 示例 3：
 *
 * 输入：clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], T = 9
 * 输出：3
 * 解释：
 * 我们选取片段 [0,4], [4,7] 和 [6,9] 。
 * 示例 4：
 *
 * 输入：clips = [[0,4],[2,8]], T = 5
 * 输出：2
 * 解释：
 * 注意，你可能录制超过比赛结束时间的视频。
 */

public class LC_1024 {
    /*
每次找出一段，方案：
    目标线段起点在i,现在找出起点在i及i之前的线段，加入目标线段


*/
    public int videoStitching(int[][] clips, int T) {
        //map统计每一个起点可以达到的最远处
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] clip : clips) {
            Integer n = map.get(clip[0]);
            map.put(clip[0], Math.max(clip[1], n == null ? -1 : n));
        }
        int res = 0;

        int pre = -1;
        int cur = 0;
        while (cur < T) {
            //从pre+1~cur找能到达最远的一条

            int maxIndex = -1; //最大值的下标
            int max = -1; //最大值
            // 这里遍历是一个缺点，对于空的地方，不需要遍历。
            //优化：如果使用链表最不存在这种情况了。算了不写了
            //如果要写的话也不难
            for (int i = pre + 1; i <= cur; i++) { // 从pre+1~cur
                if (map.get(i) == null) continue; // 为空跳过
                // 如果比max大，而且比cur大(如果比cur小就没必要了)，更新最大值
                if (max < map.get(i) && map.get(i) > cur) {
                    max = map.get(i);
                    maxIndex = i;
                }
            }
            if (max == -1) return -1;//如果max=-1，表示没有更远的，脱节了，返回-1
            pre = cur;//pre更新为cur
            cur = max;//cur更新到能达到的最远位置
            res++; //得到一段
        }
        return res;
    }

    /*
    * 上面这种思路就是贪心，
    * 另一种形式 如下
    * */
    public int videoStitching_(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }



    /*
    * 动态规划
    *
    * 比较容易想到的方法是动态规划，我们令 \textit{dp}[i]dp[i] 表示将区间 [0,i)[0,i) 覆盖所需的最少子区间的数量。由于我们希望子区间的数目尽可能少，因此可以将所有 \textit{dp}[i]dp[i] 的初始值设为一个大整数，并将 \textit{dp}[0]dp[0]（即空区间）的初始值设为 00。

我们可以枚举所有的子区间来依次计算出所有的 \textit{dp}dp 值。我们首先枚举 ii，同时对于任意一个子区间 [a_j,b_j)[a
j
​
 ,b
j
​
 )，若其满足 a_j < i \leq b_ja
j
​
 <i≤b
j
​
 ，那么它就可以覆盖区间 [0, i)[0,i) 的后半部分，而前半部分则可以用 \textit{dp}[a_j]dp[a
j
​
 ] 对应的最优方法进行覆盖，因此我们可以用 dp[a_j] + 1dp[a
j
​
 ]+1 来更新 \textit{dp}[i]dp[i]。状态转移方程如下：

\textit{dp}[i] = \min \{ \textit{dp}[a_j] \} + 1 \quad (a_j < i \leq b_j)
dp[i]=min{dp[a
j
​
 ]}+1(a
j
​
 <i≤b
j
​
 )

最终的答案即为 \textit{dp}[T]dp[T]。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/video-stitching/solution/shi-pin-pin-jie-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */

    public int videoStitching_dp(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

}
