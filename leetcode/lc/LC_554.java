package leetcode.lc;

import leetcode.util.Print;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 5/2/2021 2:43 PM.
 * <p>
 * <p>
 * 554. 砖墙
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 * <p>
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * <p>
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 */

public class LC_554 {
    /*
     *1.先对每一层求前缀和，然后存储到一个set中，有墙高H个set
     *2.求得墙宽W
     *3.从1遍历到墙宽W：i，遍历H个set，求出set中存在i的个数，在遍历中找到最小的i
     *4.如果没有找到最小的i，则是墙高
     *
     * 复杂度高
     */
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return 0;
        int H = wall.size();
        List<Set<Integer>> list = new ArrayList<>(H);

        // 存储总共有哪些墙缝，即排除垂直下来没有缝隙的
        SortedSet<Integer> SET = new TreeSet<>();

        int W = -1;
        for (List<Integer> layer : wall) {
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for (int weight : layer) {
                sum += weight;
                set.add(sum);
                SET.add(sum);
            }
            if (W == -1) W = sum;
            list.add(set);
        }
        int res = H;
        Iterator<Integer> iterator = SET.iterator();
        while (iterator.hasNext()){
            int tmp = 0;
            int a = iterator.next();
            // 不要遍历最后一项
            if (!iterator.hasNext()){
                break;
            }
            // 求出该垂线经过的砖块
            for (Set<Integer> set : list) {
                if (!set.contains(a)) {
                    tmp++;
                }
            }
            // 取最小
            res = Math.min(res, tmp);
        }

        return res;
    }




    /*
    * 官方
    *
    * 一次遍历 + 哈希表计数：

    统计每块转结尾坐标位置，并计数，（忽略每一层的最后一块砖）
    以某个位置结尾数量最多的砖块数记为endCountMax
    则：答案即为wall.size() - endCountMax
    * */
    public int leastBricksByOfficial(List<List<Integer>> wall) {
        HashMap<Integer, Integer> endCountMap = new HashMap<>(); // Map：砖块结尾位置 -> 数量
        int endCountMax = 0; // 以某个位置结尾数量最多的砖块的数量
        for (List<Integer> bricks : wall) {
            int end = 0; // 结尾位置，以坐标原点为基准
            for (int i = 0; i < bricks.size() - 1; i++) { // 忽略每一层的最后一块转
                int brick = bricks.get(i);
                end += brick;
                endCountMap.put(end, endCountMap.getOrDefault(end, 0) + 1);
                endCountMax = Math.max(endCountMax, endCountMap.get(end));
            }
        }
        return wall.size() - endCountMax;
    }

    public static void main(String[] args) {
        LC_554 lc554 = new LC_554();

        List<List<Integer>>  wall = new ArrayList<>();
        wall.add(lc554.getList(1,2,2,1));
        wall.add(lc554.getList(3,1,2));
        wall.add(lc554.getList(1,3,2));
        wall.add(lc554.getList(2,4));
        wall.add(lc554.getList(3,1,2));
        wall.add(lc554.getList(1,3,1,1));
        lc554.leastBricks(wall);
    }

    public List<Integer> getList(Integer ... ints){
        ArrayList<Integer> list = new ArrayList<>(ints.length);
        for (Integer anInt : ints) {
            list.add(anInt);
        }
        return list;
    }
}

/*
=++==+
===+==
=+++==
==++++
===+==
=+++=+

*/
