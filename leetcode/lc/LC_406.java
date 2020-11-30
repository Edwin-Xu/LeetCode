package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 11/16/2020 3:00 PM.
 *
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * -----------------------------
 * A little difficult.
 *
 *let me see:
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 先找出每一个人的 >=身高的人数：
 *   1      5       1      4     2      4
 *   和实际中前面>=身高的人数对比：
 *   0      4       1      0     1      2
 *
 *
 *
 */

public class LC_406 {
    /**
     * 解题思路：先排序再插入
     * 1.排序规则：按照先H高度降序，K个数升序排序
     * 2.遍历排序后的数组，根据K插入到K的位置上
     *
     * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
     *
     */
    public int[][] reconstructQueue(int[][] people) {
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(new int[list.size()][2]);
    }


    /**
     * TreeMap
     * */
    public int[][] reconstructQueueByTreeMap(int[][] people) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (int[] p: people) {
            map.computeIfAbsent(p[0], z -> new TreeSet<>()).add(p[1]);
        }
        List<int[]> list = new ArrayList<>();
        for (int k: map.descendingKeySet()) {
            for (int v: map.get(k)) {
                list.add(v, new int[] {k, v});
            }
        }
        return list.toArray(new int[0][2]);
    }





    /**
     * 快排：
     *
     * */
    public int[][] reconstructQueueByQuickSort(int[][] people) {
        quickSort(people, 0, people.length - 1);
        List<int[]> list = new ArrayList<>();
        for (int[] p: people) {
            // ！p[1] is the index of p?
            list.add(p[1], p);
        }
        return list.toArray(new int[0][2]);
    }

    private void quickSort(int[][] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int partition(int[][] arr, int l, int r) {
        int[] pivot = arr[l];
        while (l < r) {
            while (l < r) {
                if (arr[r][0] > pivot[0] || arr[r][0] == pivot[0] && arr[r][1] < pivot[1]) {
                    arr[l++] = arr[r];
                    break;
                }
                r--;
            }
            while (l < r) {
                if (arr[l][0] < pivot[0] || arr[l][0] == pivot[0] && arr[l][1] > pivot[1]) {
                    arr[r--] = arr[l];
                    break;
                }
                l++;
            }
        }
        arr[l] = pivot;
        return l;
    }





    /**
     * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/pa-de-yi-xia-jiu-100liao-hen-kuai-a-by-keylol/
     * */
    static final int BASE = 1048576;

    public int[][] reconstructQueueByIdontKnow(int[][] people) {
        int len = people.length;
        if (len == 0) return new int[0][0];
        long[] aux = new long[len];
        for (int i = 0; i < len; i++) {
            aux[i] = ((long) people[i][0] << 20) + BASE - 1 - people[i][1];
        }
        Arrays.sort(aux);
        List<int[]> list = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            int a = (int) (aux[i] >> 20);
            int b = (int) (BASE - 1 - aux[i] % BASE);
            list.add(b, new int[] {a, b});
        }
        return list.toArray(new int[0][2]);
    }

}
