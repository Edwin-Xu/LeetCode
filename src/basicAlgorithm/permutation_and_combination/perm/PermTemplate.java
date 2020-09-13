package basicAlgorithm.permutation_and_combination.perm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Edwin Xu on 9/13/2020 1:57 PM
 */
public class PermTemplate {

    /*
    * A(n,n)
    * */
    List<List<Integer>> permList = new ArrayList<>();
    public List<List<Integer>> permutation(int arr[],int m){ //m个
        perm(arr,0,m-1);
        return permList;
    }
    //把end改为m, 即可实现A(n,m), 不行的
    private void perm(int arr[], int start, int end) {
        if (start == end) {
            ArrayList list = new ArrayList(arr.length);
            for (int i= 0;i<arr.length;i++)list.add(arr[i]);
            permList.add(list);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start); //这个地方swap，实际上就是把从start+1-end中选一个出来：i
            perm(arr, start + 1, end);
            swap(arr, i, start);//递归结束后还回去
        }
    }
    private void swap(int arr[], int i, int j) {
        int te = arr[i];
        arr[i] = arr[j];
        arr[j] = te;
    }



    /*
    * 求A(n,m)?
    * 先求组合，再求排列，然后加起来吗?
    * 更简单的方式
    *
    * */



}
