package leetcode.lc;

import leetcode.util.Print;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 11/29/2020 2:52 PM.
 *
 * 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 *
 * 输入：[1,2,1]
 * 输出：0
 */

public class LC_976 {
    /**
    周长最大：三边之和最大
    排序： 选择三个最大的。
    如果三个数不符合，用后面一个替换掉最大的数。
    */
    public int largestPerimeterByEdwinXu(int[] A) {
        if (A==null||A.length<3) {
            return 0;
        }
        // 实际也不需要写快排，Arrays.sort从小到大，然后从后往前遍历即可。 这里权当复习
        quickSort(A,0,A.length-1);

        int max = A[0];
        int middle = A[1];
        int min = A[2];

        int index = 3;
        while (!isTriangle(max,middle,min) && index<A.length){
            max = middle;
            middle = min;
            min = A[index++];
        }
        return isTriangle(max,middle,min)?max+middle+min:0;
    }

    /**
     * quick sort
     * */
    private void quickSort(int[] arr, int left, int right){
        int L = left;
        int R = right;
        if (L<R){
            int tmp = arr[L];
            while (L<R){
                while(L<R && arr[R]<=tmp)R--;
                arr[L] = arr[R];
                while (L<R && arr[L]>=tmp)L++;
                arr[R] = arr[L];
            }
            arr[L] = tmp;
            quickSort(arr,left,L-1);
            quickSort(arr,R+1,right);
        }
    }


    private boolean isTriangle(int a,int b,int c){
        return  a+b>c
                && a+c>b
                && b+c>a;
        //并不需要载判断两个之差小于第三边
//                && Math.abs(a-b)<c
//                && Math.abs(a-c)<b
//                && Math.abs(b-c)<a;
    }




    /*
    * ------------------------------------------------------
    * 优化：
    *
    * 思考： 排序后 判断三角形 还需要使用三个【两边之和大于第三边吗】？
    * 不需要， max 不管加哪一个都是大于另一个，只需要判断 min + middle > max 即可
    *
    * */



    public int largestPerimeter(int[] A) {
        if (A ==null || A.length<3)return 0;
        Arrays.sort(A);
        for (int i = A.length-1; i >=2 ; i--) {
            if ( A[i-2] + A[i-1] >A[i]){
                return A[i] + A[i-1] + A[i-2];
            }
        }
        return 0;
    }





    public static void main(String[] args) {
        int []arr= new int[]{3,6,2,3};
        System.out.println(new LC_976().largestPerimeter(arr));
    }
}
