package leetcode.nowcoder.nc;

/**
 * Created by Edwin Xu on 9/23/2020 6:55 PM
 * 最长递增子序列
 *
 * 题目描述
 * 给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）
 * 示例1
 * 输入
 * 复制
 * [2,1,5,3,6,4,8,9,7]
 * 输出
 * 复制
 * [1,3,4,8,9]
 */
public class NC_91 {

    public int[] LIS (int[] arr) {
        if(arr == null || arr.length <= 0){
            return null;
        }

        int len = arr.length;
        int[] count = new int[len];             // 存长度
        int[] end = new int[len];               // 存最长递增子序列

        //init
        int index = 0;                          // end 数组下标
        end[index] = arr[0];
        count[0] = 1;

        for(int i = 0; i < len; i++){
            if(end[index] < arr[i]){
                end[++index] = arr[i];
                count[i] = index;
            }
            else{
                int left = 0, right = index;
                while(left <= right){
                    int mid = (left + right) >> 1;
                    if(end[mid] >= arr[i]){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
                end[left] = arr[i];
                count[i] = left;
            }
        }

        //因为返回的数组要求是字典序，所以从后向前遍历
        int[] res = new int[index + 1];
        for(int i = len - 1; i >= 0; i--){
            if(count[i] == index){
                res[index--] = arr[i];
            }
        }
        return res;
    }

}
