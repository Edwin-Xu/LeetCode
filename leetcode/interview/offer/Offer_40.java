package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 3/20/2020 11:03 PM
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 */
public class Offer_40 {
    //排序法
//    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        int [] res = new int[k];
//        for (int i=0;i<k;i++){
//            res[i]=arr[i];
//        }
//        return res;
//    }

//    只找前k
//    public int[] getLeastNumbers(int[] arr, int k) {
//        int len = arr.length;
//        int [] res = new int[k];
//        for (int i=0;i<k;i++){
//            int min = arr[i];
//            int minIndex=i;
//            for (int j=i+1;j<len;j++){
//                if (arr[j]<min){
//                    min = arr[j];
//                    minIndex=j;
//                }
//            }
//            if (minIndex!=i) arr[minIndex]=arr[i];
//            res[i]=min;
//        }
//
//        return res;
//    }



    //快速排序法：
    //先复习下快排：
    /*
    排序算法的思想：取一个基准，把小于基准的移到一边，大于基准的移动到另一边。递归下去。
     */
    private int [] quickSort(int []arr,int left,int right){//right=数组长-1
        int L=left,R=right;
        if (L<R){//至少2两个元素
            int tmp = arr[L];//取基准
            while (L<R){
                //找出右边比基准小的第一个数，
                while (L<R && arr[R]>=tmp)R--;
                //找到了之后拿到左边：如果没有匹配的则L==R，相当于没替换
                arr[L]=arr[R];
                //找出左边比基准大的第一个元素
                while (L<R && arr[L]<=tmp)L++;
                //找到之后拿到右边
                arr[R]=arr[L];
            }
            //跳出循环是L==R,arr[L]是中间的那个数，大小数居两边；
            //注意上面：去掉内部while，发现执行了L=R’,R‘=L‘，即这个基准被改变了，需要还原：
            arr[L] = tmp;

            System.out.println("L:"+L);
            printArr(arr);

            //那么对左右递归，对子数组排序
            quickSort(arr,left,L-1);
            quickSort(arr,R+1,right);
        }

        return  arr;
    }

    /*
    考虑如何使用快速排序法解决这个问题

    快排是选一个分解值，然后把小于的移到一边，大于的移到另一边，会返回分界值所在的下标。

    这里每次找一个分界值，得出其下标m,m和K比较：
        k=m：说明刚好找到
        k<m:说明top k在前m个，递归(0,m-1)
        k>m:说明还有m-k个数在(m+1,R)中，递归
     */


    //求前k
    private void topK(int []a,int left,int right,int k){
        int m=partition(a,left,right);
        if (m==k)return ;
        else if (m>k)topK(a,left,m-1,k);
        else topK(a,m+1,right,k);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        else if(arr.length<=k)return arr;
        topK(arr,0,arr.length-1,k);
        int res [] = new int[k];
        for (int i=0;i<k;i++)res[i]=arr[i];
        return res;
    }

    //先写分区函数：
    private int partition(int []a,int L,int R){
        int tmp = a[L];
        while (L!=R){
            while (L<R && a[R]>=tmp)R--;
            a[L]=a[R];
            while(L<R && a[L]<=tmp)L++;
            a[R]=a[L];
        }
        a[R]=tmp;
        return R;
    }
    /*
    为什么这个比上面的分区函数好很多
     */
    int partition_better(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) //左到右扫描，找到第一个 >= v的
                if (i == hi) break;//没有，退出
            while (a[--j] > v)//右到左扫描，找到第一个 <= v的
                if (j == lo)break;//没有，退出
            if (i >= j)  break;//扫描完毕，退出
            swap(a, i, j);//找到后交换值
        }
        swap(a, lo, j);//j是分界下标，把分界值拿过去
        return j;
    }
    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



    //用最大堆来



    private void printArr(int a[]){
        for (int i:a) System.out.print(i+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        Offer_40 i = new Offer_40();
//        int [] a = {4,3,5,4,3,2,1,0,10,-100};
        int []  a= {0,0,2,3,2,1,1,2,0,4};
        i.topK(a,0,a.length-1,2);
        i.printArr(a);
    }
}
