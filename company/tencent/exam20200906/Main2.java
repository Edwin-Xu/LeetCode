package company.tencent.exam20200906;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    ArrayList<ArrayList<Integer>> recoder;
    ArrayList<ArrayList<Integer>> groups;

    public Main2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

//        System.out.println(n);

        //记录 i属于那几个组
        recoder = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            recoder.add(new ArrayList<Integer>());
        }


        int m = scanner.nextInt();

        groups = new ArrayList<>(m + 1);
        groups.add(new ArrayList<>());

        for (int i = 1; i <= m; i++) { //组数  1~m
            int groupNum = scanner.nextInt();
            ArrayList<Integer> group = new ArrayList<>();
            for (int j = 0; j < groupNum; j++) {
                int num = scanner.nextInt();
                group.add(num);
                recoder.get(num).add(i);
            }
            groups.add(group);
        }

        dfs(0);
        System.out.println(map.size());
    }

    Map<Integer, Integer> map = new HashMap<>();

    void dfs(int index) { //index知道了
        if (map.containsKey(index)) return;
        map.put(index, 0);

        //通知同组的人员

        //所在的多个组：
        ArrayList<Integer> sameGroup = recoder.get(index);
        for (int g : sameGroup) {
            //对于每一个组
            ArrayList<Integer> group = groups.get(g);
            for (int people : group) {
                dfs(people);
            }
        }
    }

    public static void main(String[] args) {
        new Main2();
    }
}
