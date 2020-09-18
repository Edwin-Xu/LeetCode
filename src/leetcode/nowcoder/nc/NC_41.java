package leetcode.nowcoder.nc;

import leetcode.util.Print;

import java.util.HashMap;

/**
 * Created by Edwin Xu on 9/17/2020 11:28 PM
 */
public class NC_41 {
    public int maxLength (int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for(int start = 0, end = 0; end<arr.length ; end++){
            if(map.containsKey(arr[end])){
                //重复了
                Print.print(start,map.get(arr[end])+1,arr[start],arr[map.get(arr[end])+1]);
                start = Math.max(start, map.get(arr[end])+1);
                //注意：这里一定要取最大的start，不然就错误了
                //为什么？ 因为重复数字的所有很可能比start小
            }
            max = Math.max(max , end-start+1);
            map.put(arr[end],end);
        }
        return max;
    }

    public static void main(String[] args) {
        NC_41 nc   = new NC_41();
        int arr [] = {2,3,3,2};
        nc.maxLength(arr);
    }
}
