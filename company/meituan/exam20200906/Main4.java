package company.meituan.exam20200906;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Edwin Xu on 9/6/2020 10:35 AM
 * 这题有点难。
 *
 *
 * 公司 下属
 *
 * 构造树：
 * 树特点：
 *  - 一棵树：子树为0或者2.
 *  - 一个子树有关键字X 是左右子树的个数+1 (包括自己的树的节点数)
 *现在给出具有关键字的节点arr,arr[i]表示节点i的关键字
 * 能不能构造一颗树？
 *
 *
 * 如: 1 1 3
 * 可以的：   3
 *         /   \
 *        1     1
 * 如：1 2 3：
 *
 *
 * 如果存在偶数，一定不可能
 * 1：n(n+1)/2
 *
 *
 * 排序：
 * 对于最大值X：找出和为X-1的两对数，然后递归
 *
 */


public class Main4 {
    public Main4() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                map.merge(arr[i], 1, Integer::sum);
            }

//            for (Map.Entry<Integer,Integer> entry:map.entrySet() ){
//                System.out.println(entry.getKey()+" "+entry.getValue());
//            }

            /*
             * arr[i]==1: 叶子节点
             * 否则：分支节点
             *
             * 最大的是根节点
             * 第二大的是一个子节点
             *
             *
             * 自底向上？
             *
             *
             * */
            isTree(map);
        }
    }

    private void isTree(Map<Integer, Integer> map) {
        if (!map.containsKey(1) || !map.containsKey(3)) {
            System.out.println("NO");
            return;
        }
        int one = map.get(1);
        int three = map.get(3); //
        if (one < 2 || three < 1){
            System.out.println("NO");
            return;
        };
        //必然有一对1是叶子节点
        map.put(1, one - three * 2);  //   /\
        one = map.get(1); //剩余的单节点
        if (one<0){
            System.out.println("NO");
            return;
        }

        if (!map.containsKey(4) && !map.containsKey(6)){
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }

    public static void main(String[] args) {



        new Main4();
    }
}
