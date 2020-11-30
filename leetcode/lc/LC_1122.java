package leetcode.lc;

import java.util.*;

/**
 * Created by Edwin Xu on 11/14/2020 12:26 AM.
 *
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */

public class LC_1122 {
    //借助hashmap
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>(arr1.length);
        // <数字, 出现次数>
        for (int n:arr1){
            map.merge(n,1,Integer::sum);
        }

        int index = 0;
        for(int a:arr2){ // 按arr2的顺序
            for (int i = 0 ; i < map.getOrDefault(a,0);i++){
                arr1[index++] = a;//依次填充
            }
            map.remove(a);  //并把使用过的去除
        }
        int L = index;
        //剩下的是没有出现过的，依次加到末尾
        for (int key:map.keySet()){
            for (int i = 0 ; i < map.getOrDefault(key,0);i++){
                arr1[index++] = key;
            }
        }
        //然后给末尾这些数排序
        qs(arr1,L,index-1);
        return arr1;
    }



    public static void qs(int arr[], int left, int right) {
        int L = left;
        int R = right;
        if (L >= R) {
            return;
        }

        int tmp = arr[left]; // 取一个基准点
        while (L < R) {
            while (L < R && arr[R] >= tmp) R--;//找第一个比基准小的
            arr[L] = arr[R];//覆盖
            while (L < R && arr[L] <= tmp) L++;//找第一个比基准大的
            arr[R] = arr[L];//覆盖
        }
        arr[L] = tmp;//将基准归位

        qs(arr, left, L - 1);
        qs(arr, R + 1, right);
    }





    /**
    * 自定义排序
    * */
    public int[] relativeSortArrayDiySort(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : arr1) {
            list.add(num);
        }
        for(int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        list.sort((x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });
        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }


}
