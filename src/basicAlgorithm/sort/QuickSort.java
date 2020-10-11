package basicAlgorithm.sort;

/**
 * Created by Edwin Xu on 6/3/2020 7:46 PM
 *
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



    /*
    * 快排的思路在于：对于一个数，将小于它的移动到左边，大于它的移动到右边。
    *
    * */

    public void qs_review(int [] nums,int left,int right){
        int L = left;
        int R = right;
        if (L<R){
            int tmp = nums[L];
            while(L<R){
                while (L<R && nums[R]>=tmp)R--;
                nums[L] = nums[R];
                while (L<R && nums[L]<=tmp)L++;
                nums[R] = nums[L];
            }
            nums[L] = tmp;
            qs_review(nums,left,L-1);
            qs_review(nums,L+1,right);

        }
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int arr[] = new Util(100).getArr();
        quickSort.qs(arr,0,arr.length-1);
        Util.print(arr);

//        quickSort.quick(arr,0,arr.length-1);
//        Util.print(arr);

        quickSort.qs_review(arr,0,arr.length-1);
        Util.print(arr);




    }
}
