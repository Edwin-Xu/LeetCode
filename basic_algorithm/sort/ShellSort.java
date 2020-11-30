package basic_algorithm.sort;

import leetcode.util.ArrOpsUtil;
import leetcode.util.Print;

/**
 *
 *
 * 每个增量分组使用插入排序： 因为数组基本有序后，插入排序时间复杂度很小
 *
 *
 * void ShellSort(int *arr,int len)
 * {
 * 	for (int gap = len/2;gap > 0;gap = gap/2)
 *        {
 * 		for (int i = gap;i < len;i++)
 *        {
 * 			int j = i;
 * 			while (j - gap >= 0 && arr[j] < arr[j - gap])
 *            {
 * 				Swap(arr,j,j - gap);
 * 				j = j - gap;
 *            }
 *        }
 *    }
 * }
 * Created by Edwin Xu on 6/3/2020 11:01 PM
 */
public class ShellSort {
    /*
    可以自己制定增量
     */
    public static void shellSort(int[] array){
        int[] d = {5,3,1};
        for(int i = 0;i < d.length;i++){
            shell(array,d[i]);
        }
    }

    // 分为gap组，组内排序
    private static void shell(int[] array, int gap) {
        int tmp,j;
        for(int i = gap;i < array.length;i+=gap){ // i= gap，即该组最后一个元素
            //对于每一组

            tmp = array[i];//备份最后一个
            //往前找插入的位置
            for(j = i-gap;j >= 0;j = j-gap){
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            //插入
            array[j+gap] = tmp;
        }
    }

    /*
    * 希尔排序是按照分治法的思想，将原来的元素分成几个组，在组内采用直接插入法进行排序。
    *
    * 时间复杂度：O(n^1.3~2.5) 不稳定
    *
    *希尔排序法的关键在于关键字的选择，关键字的选择有如下规则：
     - 关键字必须为素数。
     - 最后一个关键字必须为 1 。
    * */

    public static void shellSort_gap_2(int[] a) { //三个循环，一个是增量，另外两个是插入排序
        /**
         * 希尔排序
         * 希尔排序又叫缩小增量排序。
         * 其最坏时间复杂度依然为O(n2)，一些经过优化的增量序列如Hibbard经过复杂证明可使得最坏时间复杂度为O(n3/2)。
         * 思想：将数组分为几个区，然后在每个区内排序，然后将区数缩小，再次迭代
         */
        for (int gap = a.length / 2; gap > 0; gap /= 2) {//增量每次都/2, 并非是最优解
            // gap分的组数
            //从增量那组开始进行插入排序，直至完毕

            for (int i = gap; i < a.length; i+=gap) {
                int temp = a[i];
                int j;
                // j - gap 就是代表与它同组隔壁的元素
                for (j = i; j - gap >= 0 && a[j - gap] > temp; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = temp;
            }
        }
    }


    public static void main(String[] args) {

        int arr[] = ArrOpsUtil.genRandomArr(20);
//        int [] arr = {10,9,8,7,6,5,4,3,2,1,0};

        Print.printArr(arr);
//        shellSort_gap_2(arr);
        sh(arr,1);
        Print.printArr(arr);



    }


    public static void sh(int[] arr, int gap) {
        //分为gap组
        //对于每一组：
        for (int i = gap; i < arr.length; i += gap) {
            //组内采用直接插入排序
            int tmp = arr[i]; //该组最后一个
            int j = 0;
            for (j = i; j - gap >= 0 && arr[j - gap] > tmp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = tmp;
        }
    }

}
















