package basicAlgorithm.sort;

/**
 * Created by Edwin Xu on 6/3/2020 7:46 PM
 */
public class QuickSort {


    public void quick(int[] arr,int left,int right){
        int R = right;
        int L = left;
        if (L<R){
            int tmp = arr[left];
            while (L<R){
                while (L<R&& arr[R]>=tmp)R--;
                arr[L]=arr[R];
                while (L<R&& arr[L]<=tmp)L++;
                arr[R]=arr[L];
            }
            arr[L]=tmp;
            quick(arr,left,L-1);
            quick(arr,R+1,right);
        }
    }





    /*
    *
    * 忘了，捡起来很快
    *
    * 时间复杂度O(NlogN)
    *
    * */


    public void qs(int a[],int left,int right){
        int L=left;
        int R = right;
        if (L<R){
            int tmp = a[L];
            while (L<R){
                while (L<R && a[R]<=tmp)R--;
                a[L] = a[R];
                while (L<R && a[L]>=tmp)L++;
                a[R] = a[L];
            }
            a[L] = tmp;
            qs(a,left,L-1);
            qs(a,R+1,right);
        }

    }


    public void qs1(int[]a, int left,int right){
        int L = left,R = right;
        if (L<R){
            int tmp = a[L];
            while (L<R){
                while (L<R && tmp>=a[R])R--;
                a[L]=a[R];
                while (L < R && tmp <= a[L])L++;
                a[R] = a[L];
            }
            a[L] = tmp;
            qs1(a,left,L-1);
            qs1(a,R+1,right);
        }
    }




    public static void main(String[] args) {
        int arr[] = new Util(100).getArr();
        new QuickSort().qs(arr,0,arr.length-1);
        Util.print(arr);
        new QuickSort().quick(arr,0,arr.length-1);
        Util.print(arr);


    }
}
