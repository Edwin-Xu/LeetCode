package leetcode.interview.offer;

/**
 * Created by Edwin Xu on 6/25/2020 5:11 PM
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer_11 {

    /*
    * 暴力解法：遍历 O(N)
    * */
    public int minArray_1(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i <numbers.length ; i++) {
            if (numbers[i]<min)min = numbers[i];
        }
        return min;
    }

//    遍历还可以优化：减少一半遍历
    /*只需要找到最高到最低的点
    * 如果两个两个的找不行，可能刚好错过
    * 三个三个一起找
    * */
//    public int minArray_2(int[] numbers) {
//        for (int i = 1; i < numbers.length-2; i+=2) {
//            if (numbers[i]<)
//        }
//    }

    /*
    * 二分查找
    * O(logN)
    *
    * */
        public int minArray(int[] numbers) {
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                int m = (i + j) / 2;
                if (numbers[m] > numbers[j]) i = m + 1; // 说明旋转点在右边
                else if (numbers[m] < numbers[j]) j = m;// 说明旋转点在左边
                else j--; //不知道旋转点在哪里，要么遍历，这里由于i<j且m=(i+j)/2,故m<j，所以j不可能是旋转点，j--用以缩小范围

            }
            return numbers[i];
        }


}
