package leetcode.nowcoder.nc;

import leetcode.util.Print;

/**
 * Created by Edwin Xu on 8/25/2020 10:40 PM
 * 题目描述
 * 请实现有重复数字的有序数组的二分查找。
 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
 * 示例1
 * 输入
 * 复制
 * 5,4,[1,2,4,4,5]
 */
public class NC_105 {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        /*
        关键点：数组有序、>=v的第一个


        */

        int low = 0, high = n;
        int mid=0;
        int res = n+1;
        while(low<high){
            mid = (high+low)/2;
            Print.print(low,high,mid,a[mid],v);

            if(a[mid]==v){
                res = mid;
                high = mid;
            }else if(a[mid]>v){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return res==n+1?res:res+1;
    }

    public static void main(String[] args) {
        NC_105 nc_105 = new NC_105();
        int arr[] = {2,3,4,4,4,7,7,8,10,10,11,12,13,14,15,15,17,18,19,23,24,24,24,24,25,26,26,26,27,27,28,29,29,30,33,36,38,38,40,40,41,43,43,43,44,46,46,47,51,52,52,53,54,56,57,57,57,58,58,61,61,61,62,64,64,66,66,67,67,67,70,72,74,74,74,75,75,78,78,78,79,79,80,83,83,83,83,84,84,86,88,89,89,90,91,91,92,93,93,96};
        System.out.println(nc_105.upper_bound_(arr.length,1,arr));
    }
}
