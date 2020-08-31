package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 6/26/2020 8:45 PM
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 *
 *
 * 这题深度优先、广度优先都可以，
 *
 * 另外有个地推算法，需要了解
 */
public class Offer_13 {
    /*
    dfs
    */
    private boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(0,0,m,n,k);
    }
    private int dfs(int i,int j,int m ,int n,int k){
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j])return 0;
        //数位之和>k
        int sum = 0;
        int x = i,y=j;
        for (int l = 0; l < 3; l++) {
            sum+=x%10;
            sum+=y%10;
            x /= 10;
            y /= 10;
        }
        if (sum>k)return 0;

        visited[i][j] =true;
        return 1+
                dfs(i+1,j,m,n,k)
//                +dfs(i-1,j,m,n,k) 只需要向下 向右即可
//                +dfs(i,j-1,m,n,k)
                +dfs(i,j+1,m,n,k);
    }



    public static void main(String[] args) {
        boolean[] booleans = new boolean[1];
        System.out.println(booleans[0]);

    }
}
