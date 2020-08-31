package leetcode.lc;

import java.util.List;

/**
 * Created by Edwin Xu on 8/31/2020 3:24 PM
 * 841. 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 */
public class LC_841 {
    /*
    * 这个本质是一个图
    * 现在需要判断图是不是连通的
    *
    * 使用一个数组boolean[]visited判断每个房间是否访问过
    * 然后递归访问每个房间，知道所有可达的都访问完
    * 最后检查是否有房间没访问过
    * */


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[]visited = new boolean[rooms.size()];
        dfs(rooms,visited,0);
        for (boolean v:visited)if (!v)return false;
        return true;
    }
    private void dfs(List<List<Integer>> rooms,boolean[]visited ,int curRoom){
        if (visited[curRoom])return ;//访问过了
        visited[curRoom] =true;
        List<Integer> keys = rooms.get(curRoom);
        for (int i = 0; i <keys.size() ; i++) {
            dfs(rooms,visited,keys.get(i));
        }
    }

}
