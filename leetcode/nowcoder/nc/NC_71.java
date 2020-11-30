package leetcode.nowcoder.nc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 9/19/2020 11:22 AM
 *旋转数组的最小数字
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 *
 *
 *
 *
 *
 * 关键点：
 * 搞清楚这个数组是怎么分布的 ：
 * ^y
 * |             .
 * |          .
 * |       . A段
 * |    .
 * | .
 * |                        . (不超过上半部分的最高点)
 * |                     .
 * |                  . B段
 * |               .
 * |---------------------------------------->x
 *
 * 根据这个写二分还是有很多注意点，如下代码
 */
public class NC_71 {
    /*
    * 一定要保证high在B段，然后不断把low移动到B段 并将low调整到B段起始点
    * */
    public int minNumberInRotateArray(int [] array) {
        int low = 0 ; int high = array.length - 1;
        while(low < high){
            int mid = (high + low) / 2;  // 取中点
            Print.print(array[low],array[high],array[ mid]);
            if(array[mid] > array[high]){  // high在B段，那mid在A段。
                low = mid + 1;  // low必须移到mid+1,因为必须跨过A段移动到B段
            }else if(array[mid] < array[high]){// high在B段，那mid也在B段。
                high = mid; //high左移到mid。不能是mid-1。 如果是mid-1可能会将high移动到A段。
            }else{
                high--; //相同的，high往左移动1位
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        NC_71 nc_71 = new NC_71();
        int arr [] = {4,5,6,1,2,3,3};
        System.out.println(nc_71.minNumberInRotateArray(arr));
    }
}
