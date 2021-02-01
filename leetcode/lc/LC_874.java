package leetcode.lc;

import leetcode.util.Print;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 1/12/2021 1:57 PM.
 * <p>
 * 874. 模拟行走机器人
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * <p>
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * <p>
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 示例 2：
 * <p>
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * <p>
 * <p>
 * <p>
 *
 * ----------------------------------
 * 怎么存储【障碍】：(x,y)，这里取个巧, Set<Long>:x+Integer.MAX + y
 *
 *
 * 这里每一步都是1-9个单位长度，可以一步一步走，也可以通过判断的方式每次只需要走一次就行
 *
 *
 *
 *
 */

public class LC_874 {

    /**
     * 障碍点的map
     * 目的：快速确定某个方向是否有障碍。
     */
    // <x,y>
    Map<Integer, List<Integer>> xyMap = new HashMap<>();
    // <y,x>
    Map<Integer, List<Integer>> yxMap = new HashMap<>();


    public void initMap(int[][] obstacles) {
        for (int[] obst : obstacles) {
            if (!xyMap.containsKey(obst[0])) {
                xyMap.put(obst[0], new ArrayList<>());
            }
            xyMap.get(obst[0]).add(obst[1]);

            if (!yxMap.containsKey(obst[1])) {
                yxMap.put(obst[1], new ArrayList<>());
            }
            yxMap.get(obst[1]).add(obst[0]);
        }
    }


    public void move(int stepLen) {
        // 向北
        if (direction == 0) {
            int min = Integer.MAX_VALUE;
            if (xyMap.get(x)!=null){
                for (int yPoint : xyMap.get(x)) {
                    if (yPoint > y) {
                        min = yPoint - 1;
                        break;
                    }
                }
                if (min == Integer.MAX_VALUE || min > y + stepLen) {
                    y += stepLen;
                } else {
                    y = min - 1;
                }
            }else{
                y += stepLen;
            }

        }
    }

    /**
     * 方向：北东南西：0123
     * */
    private int direction = 0;
    private int x = 0, y = 0;

    public int robotSimByJumping(int[] commands, int[][] obstacles) {
        if (commands == null || obstacles == null) {
            return -1;
        }
        //初始化
        initMap(obstacles);

        for (int command : commands) {
            if (command < -2 || command > 9) {
                continue;
            }
            if (command == -2) {
                direction = (direction - 1 + 4) % 4;
                // +4 是为了防止出现负数。
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                move(command);
            }
        }
        System.out.println(x+" "+y);
        return x*x + y*y;
    }




    public static void main(String[] args) {
        LC_874 lc_874 = new LC_874();
        int[] commands = new int[]{-1,-2,-1,-1,-1,-1,-2};
        int[][] obstacles = new int[][]{
                {2,4}
        };

        int res = lc_874.robotSim(commands,obstacles);
        System.out.println(res);

    }








    /**
     * 通过判断的方式好复杂，还是一步一步走吧
     *
     * */
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || obstacles == null) {
            return -1;
        }
        // < x, set(y) >
        Map<Integer, Set<Integer>> obstacleMap = new HashMap<>();
        for (int [] obst: obstacles){
            if (!obstacleMap.containsKey(obst[0])){
                obstacleMap.put(obst[0],new HashSet<>());
            }
            obstacleMap.get(obst[0]).add(obst[1]);
        }

        int direction = 0;
        int x = 0, y = 0;

        for (int command : commands) {
            System.out.println(direction);
            if (command < -2 || command > 9) {
                continue;
            }
            if (command == -2) {
                direction = (direction - 1 + 4) % 4;
                // +4 是为了防止出现负数。
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                // North
                if (direction==0){
                    int max = y+command;
                    while (y<max && (!obstacleMap.containsKey(x) || !obstacleMap.get(x).contains(y+1))){
                        y++;
                    }
                }
                // East
                else if (direction==1){
                    int max = x+command;
                    while (x<max && (!obstacleMap.containsKey(x+1) || !obstacleMap.get(x+1).contains(y))){
                        x++;
                    }
                }
                // South
                else if (direction==2){
                    int min = y-command;
                    while (y>min && (!obstacleMap.containsKey(x) || !obstacleMap.get(x).contains(y-1))){
                        y--;
                    }
                }
                // West
                else{
                    int min = x-command;
                    while (x>min && (!obstacleMap.containsKey(x-1) || !obstacleMap.get(x-1).contains(y))){
                        x--;
                    }
                }

            }
        }
        return x*x + y*y;
    }







/**
 * 官方解法和上面我的思路是一致的，但是代码更加好。
 * 上面的不知道还有什么问题。
 * */
    public int robotSimByOfficial(int[] commands, int[][] obstacles) {
        // 下标0123还是表示在北东南西方向上，对于X轴的每次的位移
        int[] dx = new int[]{0, 1, 0, -1};
        // 同理
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        // 把二维信息压缩为一维
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd: commands) {
            // 改变方向
            if (cmd == -2)  //left
                di = (di + 3) % 4;
            else if (cmd == -1)  //right
                di = (di + 1) % 4;
            // move
            else {
                // 这里还是枚举的思路，其实并不好，如果每次都是9步，那么时间复杂度高
                for (int k = 0; k < cmd; ++k) {
                    // 新的坐标
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }

        return ans;
    }


}
