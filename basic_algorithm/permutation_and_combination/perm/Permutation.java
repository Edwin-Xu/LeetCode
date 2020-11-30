package basic_algorithm.permutation_and_combination.perm;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 8/28/2020 10:18 PM
 */

/*
* 全排列
* */
public class Permutation {



    /*
    * 递归方法
    * 不使用复制来进行递归
    *
    * 递归+交换数字
    * */
    static void perm(int a[], int start, int end) {
        Print.printArr(a);
        if (start == end) {
            for (int i : a) System.out.print(i);
            System.out.println();
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(a, i, start); //这个地方swap，实际上就是把从start+1-end中选一个出来：i
            perm(a, start + 1, end);
            swap(a, i, start);//递归结束后还回去
        }
    }
    static void swap(int arr[], int i, int j) {
        int te = arr[i];
        arr[i] = arr[j];
        arr[j] = te;
    }











    /*
     * 迭代方法
     * 复杂度过高
     * */
    public void permutation1(){
        int a[] = {1, 2, 3, 4};
        int b[] = new int[a.length];
        boolean b1[] = new boolean[a.length];//判断是否被用
        dfs(b1, a, b, 0);
    }
    private static void dfs(boolean[] b1, int[] a, int b[], int index) {
        int len = a.length;
        if (index == a.length)//停止
        {
            if (b[0] != 0) {
                for (int j : b) {
                    System.out.print(j + "  ");
                }
                System.out.println();
            }
        } else
            for (int i = 0; i < len; i++) { // 这他妈每一层都需要遍历整个数组。。。。。
                if (!b1[i]) {
                    b[index] = a[i];
                    b1[i] = true;//下层不能在用
                    dfs(b1, a, b, index + 1);
                    b1[i] = false;//还原
                }
            }

    }









    /*
    * 复习一下
    * eg:打印int[]的全排列
    * */
    public static void review(int []arr){
        my_perm(arr,0,arr.length-1);
    }
    private static void my_perm(int []a,int l,int r){
        if (l==r){
            Print.printArr(a);
            return;
        }
        for (int i = l; i <=r ; i++) {
            swap(a,l,i);
            my_perm(a,l+1,r);
            swap(a,l,i);
        }
    }







    public static void main(String[] args) {
        int a[] = {1, 2, 3};
//        Permutation.perm(a,0,a.length-1);

        Permutation.review(a);

    }


}
