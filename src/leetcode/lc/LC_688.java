package leetcode.lc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 8/5/2020 11:04 PM
 * 688. “马”在棋盘上的概率
 * 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。
 * <p>
 * 现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。
 * <p>
 * 如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。
 * 现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
 * <p>
 * 求移动结束后，“马” 仍留在棋盘上的概率。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: 3, 2, 0, 0
 * 输出: 0.0625
 * 解释:
 * 输入的数据依次为 N, K, r, c
 * 第 1 步时，有且只有 2 种走法令 “马” 可以留在棋盘上（跳到（1,2）或（2,1））。对于以上的两种情况，各自在第2步均有且只有2种走法令 “马” 仍然留在棋盘上。
 * 所以 “马” 在结束后仍在棋盘上的概率为 0.0625。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 没写完
 * 正解是动态规划
 * f[r,c,step] = sum(f[ri,ci,step-1])/8
 */
public class LC_688 {
    private int total = 0;

    public double knightProbability(int N, int K, int r, int c) {
        int onboard = run(N,K,r,c);
        return onboard/total;
    }

    private int run(int N, int K, int r, int c) {
        Print.print(r,c);
        if (r < 0 || r >= N || c < 0 || c >= N) return 0;
        total+=1;
        return 1
                +run(N,K-1,r-2,c+1)
                +run(N,K-1,r-2,c-1)
                +run(N,K-1,r+2,c-1)
                +run(N,K-1,r+2,c-1)
                +run(N,K-1,r-1,c-2)
                +run(N,K-1,r-1,c+2)
                +run(N,K-1,r+1,c-2)
                +run(N,K-1,r+1,c+2);

    }

    public static void main(String[] args) {
        LC_688 l     = new LC_688();
        System.out.println(l.knightProbability(3,2,0,0));
    }
}
