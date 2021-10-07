package leetcode.lc;

import java.util.Arrays;

/**
 * @author taoxu.xu
 * @date 10/1/2021 10:29 PM
 */
public class LC_223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int aArea = calcSingleRect(ax1, ay1, ax2, ay2);
        int bArea = calcSingleRect(bx1, by1, bx2, by2);
        int repeatArea = 0;

        // 判断是否有重叠：
        // 1. 一个矩形至少有一个点在另一个中
        // 2. 呈中字形
        if (isPointInRect(ax1, ay1, bx1, by1, bx2, by2)
                || isPointInRect(ax1, ay2, bx1, by1, bx2, by2)
                || isPointInRect(ax2, ay1, bx1, by1, bx2, by2)
                || isPointInRect(ax2, ay2, bx1, by1, bx2, by2)
                || isPointInRect(bx1, by1, ax1, ay1, ax2, ay2)
                || isPointInRect(bx1, by2, ax1, ay1, ax2, ay2)
                || isPointInRect(bx2, by1, ax1, ay1, ax2, ay2)
                || isPointInRect(bx2, by2, ax1, ay1, ax2, ay2)
                || (ax1> bx1 && ax2 < bx2 && ay1<by1 && ay2 > by2)
                || (bx1> ax1 && bx2 < ax2 && by1<ay1 && by2 > ay2)
        ){
            int x = getMultiplyMiddleTwoOfFour(ax1, ax2, bx1, bx2);
            int y = getMultiplyMiddleTwoOfFour(ay1, ay2, by1, by2);
            repeatArea = x*y;
        }
        return aArea + bArea - repeatArea;
    }

    private int calcSingleRect(int ax1, int ay1, int ax2, int ay2){
        return Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
    }
    /**
     * 从四个值中找到第二大和第三大的差的绝对值
     * */
    private int getMultiplyMiddleTwoOfFour(int a,int b,int c,int d){
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a+b+c - max - min;
        if(d <min){
            return mid - min;
        }
        if (d > max){
            return max - mid;
        }
        return Math.abs(d - mid);
    }
    boolean isPointInRect(int px, int py, int x1, int y1, int x2, int y2){
        return px >= x1 && px <= x2 && py>=y1 && py <= y2;
    }

    public static void main(String[] args) {
        LC_223 lc_223 = new LC_223();
        int area = lc_223.computeArea(-3,
                1,
                3,
                4,
                0,
                -1,
                9,
                2);
        System.out.println(area);
    }



    public int computeAreaOffical(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1), area2 = (bx2 - bx1) * (by2 - by1);
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1), overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);
        return area1 + area2 - overlapArea;
    }

}
