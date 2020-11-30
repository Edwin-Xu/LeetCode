package leetcode.lc;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Edwin Xu on 11/4/2020 1:33 AM.
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 *

 *
 */

public class LC_57 {

    /*
 写得比较久:2020/11/4 1:24
 效率还是不错的
 思路： 检测是否有重叠的，有合并掉即可
 */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //长度不合法:[]
        if(intervals==null||intervals.length==0){
            return new int[][]{newInterval};
        }

        //插入的左右边界
        int left = newInterval[0];
        int right = newInterval[1];

        int len = intervals.length;

        //重叠的边界：intervals索引
        int L=-1,R=-1;

        //排除插入在两边的情况
        if(intervals[0][0]<=right && intervals[len-1][1]>=left){
            //如果newInterval是某个区间的子区间
            for(int i = 0 ;i <len; i++){
                if(left>=intervals[i][0] && right<=intervals[i][1]){
                    L=i;
                    R=i;
                    break;
                }
            }
            //从左往右找L
            for(int i = 0 ;i <len; i++){
                if(intervals[i][1]>=left && right>=intervals[i][1] ){
                    L = i;
                    break;
                }
            }
            //从右往左找R
            for(int i= len-1;i>=0;i--){
                if(intervals[i][0]<=right && left<=intervals[i][0]){
                    R=i;
                    break;
                }
            }
        }

        //结果数组
        int res[][] ;
        if(L+R==-2){//没有重复
            res = new int[len+1][2];//没有重复时结果多一个
            int index =0;
            for(int i = 0 ;i <len; i++){
                if(right<intervals[i][0]&&index==i){//index==i保证只加一次
                    res[index++] = newInterval;
                }
                res[index++] = intervals[i];
            }
            if(index==len)res[index++] = newInterval;//在末尾

        }else{//重复
            //L~R之间应该和newInterval合并
            if(L==-1)L=R;//防止有-1越界
            if(R==-1)R=L;

            res = new int[len-R+L][2];//少R-L个
            //合并
            int newInte[] = new int[]{
                    Math.min(intervals[L][0],left),
                    Math.max(intervals[R][1],right)
            };

            int index =0;
            //左边
            for(int i = 0 ;i <L;i++){
                res[index++] = intervals[i];
            }
            //插入合并后的
            res[index++] = newInte;
            //右边
            for(int i = R+1 ;i <len;i++){
                res[index++] = intervals[i];
            }
        }
        return res;
    }





    /*
    * 官方解法
    * */
    public int[][] insert_offical(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }





}
