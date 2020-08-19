package basicAlgorithm.sort;

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
    private static void shell(int[] array, int gap) {
        int tmp,j;
        for(int i = gap;i < array.length;i++){
            tmp = array[i];
            for(j = i-gap;j >= 0;j = j-gap){
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = tmp;
        }

    }

    public static void main(String[] args) {


    }
}
















