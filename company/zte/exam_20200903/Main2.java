package company.zte.exam_20200903;

import java.util.*;

/**
 * Created by Edwin Xu on 9/3/2020 10:58 AM
 */
public class Main2 {
    class City {
        ArrayList<Integer> nexts = new ArrayList<>();
        ArrayList<Integer> lens = new ArrayList<>();
    }

    City[] cities;
    private boolean[] visited;


    public Main2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //初始化城市
        //玲姐矩阵
        cities = new City[n + 1]; //1-n
        visited = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            cities[i] = new City();
        }


        int m = sc.nextInt();
        int q = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int len = sc.nextInt();
            //a-->b
            // b-->a

            cities[a].nexts.add(b);
            cities[a].lens.add(len);

            cities[b].nexts.add(a);
            cities[b].lens.add(len);


        }


        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j = 1; j < visited.length; j++) {
                visited[i] = false;
            }

            System.out.println(getminPath(a, b, new HashSet<>()));

        }
        sc.close();


    }


    private int getminPath(int a, int b, Set<Integer> visited) {
        City aCity = cities[a]; //当前出发点
        if (a==b)return 0;
        //还未到达目标节点，继续访问
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < aCity.nexts.size(); i++) {
            int n = aCity.nexts.get(i);
            int tmp = getminPath(n, b, visited);
            if (tmp==-1 || tmp==Integer.MAX_VALUE)continue;
            if(min > tmp+aCity.lens.get(i)) { //找到更小的路径
                min = tmp+aCity.lens.get(i);
            }
        }
        return min;
    }


    public static void main(String[] args) {
        new Main2();
    }

}

/*
*
5 3 3
1 2 1
2 3 1
3 5 2
1 2
2 4
1 5

1
-1
4

* */
