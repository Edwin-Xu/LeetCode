package basic_algorithm.sort;

/**
 * Created by Edwin Xu on 6/3/2020 2:07 PM
 */
public class Util {
    private int[] arr;

    public Util(int size){
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]= (int)(100*Math.random());
        }
    }

    public  int[] getArr(){
        return arr;
    }

    public static void print(int []a){
        for (int i:a) System.out.print(i+" ");
        System.out.println();
    }

    public static void swap(int []a,int i,int j){
        a[i] += a[j];
        a[j] = a[i]-a[j];
        a[i] -=a[j];
    }
}
