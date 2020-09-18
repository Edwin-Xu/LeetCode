package company.tonghaushun;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 9/17/2020 3:52 PM
 *
 * 同花顺二面
 * 面得差
 *
 * - 没有自我介绍
 * - 数据库连接池
 * - 两个有序顺序合并为一个有序数组
 * - 1GB文件，200MB内存，排序？   外文件排序？  归并排序
 * -
 *
 * 两个有序顺序合并为一个有序数组
 */
public class Interview2 {
    public int[] mergeTwoArr(int []arr1,int []arr2){
        int res[] = new int[arr1.length+arr2.length];
        int i = 0, j = 0;
        int index = 0;
        while (i< arr1.length && j < arr2.length){
            int a = arr1[i];
            int b = arr2[j];
            if (a<b){
                res[index++]  = a;
                i++;
            }else if(b>a){
                res[index++] = b;
                j++;
            }else{
                res[index++] = a;
                i++;
                j++;
            }
        }
        while (i<arr1.length){
            res[index++] = arr1[i++];
        }
        while (j<arr2.length){
            res[index++] = arr2[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        Interview2 main = new Interview2();
        int arr1 [] = {1,3,5,200};
        int arr2 []= {1,6,100};
        int res []=  main.mergeTwoArr(arr1,arr2);
        Print.printArr(res);
    }

}
