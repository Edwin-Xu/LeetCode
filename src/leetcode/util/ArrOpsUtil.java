package leetcode.util;

import java.util.*;

/**
 * Created by Edwin Xu on 10/13/2020 11:07 PM.
 */

public class ArrOpsUtil {

//    public  static <T> void swap(T[] arr, int i, int j) {
//        T tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }

    public  static  void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public  static  int[] genRandomArr(int size){
        int res[] = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = (int)(Math.random()*100);
        }
        return  res;
    }



}
