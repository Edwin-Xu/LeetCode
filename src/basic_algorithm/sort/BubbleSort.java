package basic_algorithm.sort;

import leetcode.util.ArrOpsUtil;
import leetcode.util.Print;

import java.util.Arrays;

/**
 * Created by Edwin Xu on 6/3/2020 2:02 PM
 */
public class BubbleSort {
    /*
    * 这个冒泡排序是基础版的，最好时间复杂度也是O(N)
    * */
    public static void bubble_basic(int[] arr ) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] < arr[j]) Util.swap(arr, j - 1, j);
            }
        }
    }

    /*
    * 下面这个冒泡排序是高配版的，通过有序提前退出来降低最优时间复杂度
    * */
    public static void bubble(int[] arr ) {
        for (int i = 0, size = arr.length; i < size - 1; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - 1 - i; ++j) {
                if (arr[j]> arr[j + 1]) {
                    Util.swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) { //如果一次遍历过程中发现全部有序了，一次也没有交换值，就直接退出
                break;
            }
        }
    }

    /*
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0, size = array.length; i < size - 1; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - 1 - i; ++j) {
            	if (greater(array[j], array[j + 1])) {
            		swap(array, j, j + 1);
            		swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }
    */


    public static void main(String[] args) {
//        int arr[] = new int[10000];
//        for (int i = 0; i <10000 ; i++) {
//            arr[i] = i;
//        }
//        long begin = System.currentTimeMillis();
//        bubble(arr);
//        System.out.println(System.currentTimeMillis() - begin);
//
//        for (int i = 0; i <10000 ; i++) {
//            arr[i] = i;
//        }
//        begin = System.currentTimeMillis();
//        bubble_basic(arr);
//        System.out.println(System.currentTimeMillis() - begin);

        int []arr = ArrOpsUtil.genRandomArr(60);
        int arr2[] = Arrays.copyOf(arr,arr.length);
        bubbleRev(arr);
        Print.printArr(arr);
        bubbleRev_advanced(arr2);
        Print.printArr(arr2);

    }




    public static void bubbleRev(int [] nums){
        for (int i = 0; i <nums.length-1 ; i++) {
            for (int j = 1; j <nums.length-i ; j++) {
                if(nums[j]<nums[j-1]) ArrOpsUtil.swap(nums,j-1,j);
            }
        }
    }

    public static void bubbleRev_advanced(int [] nums){
        for (int i = 0; i <nums.length-1 ; i++) {
            boolean isSorted = true;
            for (int j = 1; j <nums.length-i ; j++) {
                if(nums[j]<nums[j-1]){
                    ArrOpsUtil.swap(nums,j-1,j);
                    isSorted = false;
                }
            }
            if (isSorted)break;
        }
    }




}
