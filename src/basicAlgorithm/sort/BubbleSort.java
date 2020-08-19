package basicAlgorithm.sort;

/**
 * Created by Edwin Xu on 6/3/2020 2:02 PM
 */
public class BubbleSort {
    public void bubble(){
        int[] arr = new Util(100).getArr();
        for (int i = arr.length-1; i>=0 ; i--) {
            for (int j=1;j<=i;j++){
                if (arr[j-1]<arr[j])Util.swap(arr,j-1,j);
            }
        }
        Util.print(arr);
    }

    public static void main(String[] args) {
        new BubbleSort().bubble();
    }
}
