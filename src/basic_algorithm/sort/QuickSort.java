package basic_algorithm.sort;

import leetcode.util.ArrOpsUtil;
import leetcode.util.Print;

/**
 * Created by Edwin Xu on 6/3/2020 7:46 PM
 *
 */
public class QuickSort {
    public void quick(int[] arr, int left, int right) {
        int R = right;
        int L = left;
        if (L < R) {
            int tmp = arr[left];
            while (L < R) {
                while (L < R && arr[R] >= tmp) R--;
                arr[L] = arr[R];
                while (L < R && arr[L] <= tmp) L++;
                arr[R] = arr[L];
            }
            arr[L] = tmp;
            quick(arr, left, L - 1);
            quick(arr, R + 1, right);
        }
    }

    public static void qs(int arr[], int left, int right) {
        int L = left;
        int R = right;
        if (L >= R) return;

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


    public static void main(String[] args) {
        int arr[] = ArrOpsUtil.genRandomArr(40);
        myqs(arr,0,arr.length-1);
        Print.printArr(arr);

    }






























    public static void myqs(int[]arr,int left, int right){
        int L = left;
        int R = right;

        if (L>=R)return;

        int tmp = arr[L];
        while(L<R){
            while (L <R && tmp<= arr[R])R--;
            arr[L] = arr[R];
            while(L< R && tmp>=arr[L])L++;
            arr[R] = arr[L];
        }
        arr[L] = tmp;

        myqs(arr,left,L-1);
        myqs(arr,L+1,right);

    }








}
