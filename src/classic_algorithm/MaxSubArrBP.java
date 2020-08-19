package classic_algorithm;

/**
 * Created by Edwin Xu on 6/4/2020 8:54 AM
 *
 *
 * 和最大的子数组
 * 乘积最大的子数组
 *
 * 这都是一样的
 * 乘积之前遇到不会做就放下了，妈的现在遇到了吧
 * 活该
 *
 * --一定要认真，遇到问题一定要解决，不然早晚遭报应
 *
 */
public class MaxSubArrBP {

    public static int maxsubarr(int arr[]){
        int [] dp = new int[arr.length];
        dp[0] = arr[0];
        int max  =dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
            if (dp[i]>max)max = dp[i];
        }
        return max;
    }
    public static int maxsubarr_opti(int arr[]){
        int max  =arr[0];
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
           cur = Math.max(cur+arr[i],cur);
           max = Math.max(cur,max);
        }
        return max;
    }



    public static void maxArr_myself(int arr[]){
        /*
        * max = Max(max,max+arr[i])
        * */
        int []dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i=1;i<arr.length;i++){
            dp[i]=Math.max(dp[i-1]+arr[i],arr[i]);
        }
        int max = dp[0];
        for (int a:dp) {
            if (a>max)max= a;
        }
        System.out.println(max);
    }
    public static void maxArr_myself_op(int arr[]){
        /*
         * max = Max(max,max+arr[i])
         * */
        int max = arr[0];
        int cur = max;
        for (int i=1;i<arr.length;i++){
            cur=Math.max(cur+arr[i],arr[i]);
            max= Math.max(cur,max);
        }
        System.out.println(max);
    }





    /*
    * 乘积最大的子数组*/
//    public static void maxMulSubArr(int[] arr){
//        int min = arr[0];
//        int max = min;
//        int res = max;
//        for (int i = 1; i < arr.length; i++) {
//            max = Math.max()
//        }
//    }


    public static void main(String[] args) {
        int arr[] = {1,4-2,34,0,9,-4};
        System.out.println(MaxSubArrBP.maxsubarr(arr));
        System.out.println(MaxSubArrBP.maxsubarr_opti(arr));
        MaxSubArrBP.maxArr_myself(arr);
        MaxSubArrBP.maxArr_myself_op(arr);

    }
}
