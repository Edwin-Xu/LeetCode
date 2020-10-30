package leetcode.company;


/**
 * Created by Edwin Xu on 10/21/2020 10:11 PM.
 *
 *
 *
 *
 */

import leetcode.util.Print;

import java.util.*;

public class NetEasy_2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int height[] = new int[n+1];
//        int minHeight = Integer.MAX_VALUE;
        //使用最小值还不行，如果有多个最小值？

        int score = 0;

        for (int i = 0; i < m; i++) {
            int col = sc.nextInt();
            height[ col ]++; //方块累加在这个上。

            boolean isLeast = true;
            for (int j = 1; j <=n ; j++) {
                if (height[j]<height[col]){
                    isLeast = false;
                    break;
                }
            }
            if(isLeast)score++;

        }
        System.out.println(score);
    }

    /*
    *
    * 妈的：发现全部加到height数组中，然后取最小的哪一个不就行了吗
    *
    * 你的思维反应还是有点慢啊
    *
    *
    *
    * */


}
