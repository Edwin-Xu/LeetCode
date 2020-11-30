package company.bytedance.internal_recommendation;

/**
 * Created by Edwin Xu on 7/23/2020 6:29 PM
 */

import java.util.HashMap;
import java.util.Map;

/*
* fork的原理
* 父进程100MB，子进程大
*
* mysql主键索引和非主键索引
*   B+ 树，两种不同的索引，数据存放在哪里
*
* HTTP
*
* Session Cookie
*
* 用户通过 A服务器登录，并访问B服务器，那么B如何判断用户的登录状态
*
*
*
*
*
* */

public class Main {

        /*
        星座：相邻星
        星系：星数量相同星座
        */

    private Map<Integer, Integer> map = new HashMap<>(); //星座的星数量，星座数

    public void star(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '*') {
                    int res = dfs(i, j, arr);
                    if (map.containsKey(res)) {
                        map.put(res, map.get(res) + 1);
                    } // 如果map中已经有该星座，
                    else map.put(res, 1);
                }
            }
        }

        //得出了所有的星座
        System.out.println(map.size()); //星系数量
        int max = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int size = entry.getKey()*entry.getValue();
            if (size>max) max= size;
        }
        System.out.println(max); //最大星系的大小。

    }

    private int dfs(int i, int j, char[][] arr) {
        if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0 || arr[i][j] == ' ' || arr[i][j] == '.') return 0;
        if (arr[i][j] == '*') {
            arr[i][j] = ' ';
            return 1 + dfs(i - 1, j - 1, arr)
                    + dfs(i, j - 1, arr)
                    + dfs(i, j + 1, arr)
                    + dfs(i - 1, j, arr)
                    + dfs(i - 1, j + 1, arr)
                    + dfs(i + 1, j, arr)
                    + dfs(i + 1, j - 1, arr)
                    + dfs(i + 1, j + 1, arr);
        }
        return 0;
    }

    public static void main(String[] args) {
        Main m = new Main();
        char [][] chars = {
                {'*','.','.','.','.','.','.'},
                {'.','.','*','*','.','.','*'},
                {'.','*','.','.','.','*','.'},
                {'.','.','.','*','.','.','.'},
                {'.','.','.','.','*','.','.'}
        };

        m.star(chars);

    }
}









