package company.baidu.exam20200903;

import java.util.*;

/**
 * Created by Edwin Xu on 9/3/2020 8:40 PM
 * <p>
 * 0~N-1 奶牛
 * 有多个指标
 * 对一一个指标： 多个区间，[a,b]区间内的奶牛符合该指标
 * 求符合所有指标的的奶牛数
 *
 *
 * 这题只写了20分钟
 * 复杂度过高，70p超时
 */
public class Main2 {
    public Main2() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); //T組測試
        for (int i = 0; i < T; i++) { //对于每一组测试
            int n = scanner.nextInt(); //输入奶牛数

            HashMap<Integer, Integer> map = new HashMap<>(); //用hashmap存储奶牛编号，便于O(1)查找
            for (int j = 0; j < n; j++) {
                map.put(j, 0);
            }
            int m = scanner.nextInt(); //输入M个指标

            for (int j = 0; j < m; j++) { //对于一个指标
                int k = scanner.nextInt(); // 输入该指标的区间数
                boolean[] booleans = new boolean[n]; // 对于该指标，任意奶牛在任一区间即可。 用一个数组记载，初始时全部不满足
                for (int l = 0; l < k; l++) {
                    int a = scanner.nextInt(); //区间起点
                    int b = scanner.nextInt(); //区间终点
                    for (int o = a; o <= b; o++) {
                        booleans[o] = true; //只要出现在一个区间，满足了
                    }
                }
                for (int l = 0; l < n; l++) {
                    if (!booleans[l]) { //把不在任一区间的去掉。
                        map.remove(l);
                    }
                }
            }

            System.out.println(map.size());
            StringBuilder sb = new StringBuilder();

            for (int a : map.keySet()) {   //经过多个指标的检测，输出还存在的，即符合所有标准的
                sb.append(a);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        new Main2();
    }
}
