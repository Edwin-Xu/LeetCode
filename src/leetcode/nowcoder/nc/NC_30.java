package leetcode.nowcoder.nc;

/**
 * Created by Edwin Xu on 9/22/2020 9:44 PM
 *
 * 数组中未出现的最小正整数
 * 题目描述
 * 给定一个无序数组arr，找到数组中未出现的最小正整数
 * 例如arr = [-1, 2, 3, 4]。返回1
 * arr = [1, 2, 3, 4]。返回5
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 */
public class NC_30 {
    /*
    * 原地哈希，把数组中取值在1到n的数放到对应的位置，比如1放到0的位置，
    * 2放到1的位置，……n放到n-1的位置，然后遍历重置后的数组，若i下标位
    * 置不是i+1，则i+1就是那个最小的正整数，若1到n位置都对的上，说明最
    * 小的正整数是n+1。
    *
    * */
    public int minNumberdisappered (int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(arr[i]>=1&&arr[i]<=n&&arr[arr[i]-1]!=arr[i]){
                swap(arr,arr[i]-1,i);
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
