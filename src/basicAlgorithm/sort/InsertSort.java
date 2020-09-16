package basicAlgorithm.sort;

/**
 * Created by Edwin Xu on 7/25/2020 11:54 AM
 *
 *void StraightSort(int *arr,int len)
 * {
 * 	int tmp;
 * 	int i;
 * 	int j;
 * 	for (i = 1;i < len;i++)
 *   {
 * 		tmp = arr[i];
 * 		for (j = i - 1;j >= 0 && arr[j] > tmp;j--)
 *        {
 * 			arr[j + 1] = arr[j];
 *        }
 * 		arr[j + 1] = tmp;
 *    }
 * }
 *
 *
 * 分为有序和无序两部分：每次从后面无序的插入到有序的
 */
public class InsertSort {

}
