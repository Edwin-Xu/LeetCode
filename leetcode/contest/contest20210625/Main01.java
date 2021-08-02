package leetcode.contest.contest20210625;

/**
 * @author Edwin Xu
 * @date 6/25/2021 7:01 PM.
 *
 * 链接：https://ac.nowcoder.com/acm/contest/11175/A
 * 来源：牛客网
 *
 * 牛卷积是研究卷积神经网络的专家，而卷积神经网络可以用来给图像进行分类。你作为刚拜入他门下的学生，被他要求完成一个小作业。
 *
 * 这个小作业的要求如下：首先给你一张5\times 55×5大小的图片，其可以抽象成一个5 \times 55×5的0101矩阵。图片里面显示着一个数字，而你需要识别出图片中的数字。作为给刚入门学生布置的作业，作业难度自然不能太高，因此图片中的数字只有8/9/08/9/0三种之一。
 *
 * 请你设计一个程序来完成这个作业。
 *
 * 输入描述:
 * 输入一个5\times 55×5的0101矩阵表示图片，图片具有以下特点：
 *
 * 1.图片中的数字都是水平的，且只会是8/9/08/9/0三种数字之一。
 *
 * 2.图片中数字的大小和位置都可能任意出现，但其笔触的大小固定为11。比如会出现：
 *
 * 00000
 *
 * 01110
 *
 * 01010
 *
 * 01110
 *
 * 00000
 * 或
 * 01110
 *
 * 01010
 *
 * 01010
 *
 * 01110
 *
 * 00000
 * 类似这样的0，而不会出现
 * 11111
 *
 * 11111
 *
 * 11011
 *
 * 11111
 *
 * 11111
 *
 * 这样粗线条的0。
 *
 * 输出描述:
 * 输出图片中的数字。
 *
 * 示例1
 * 输入
 * 复制
 * 00000
 * 01110
 * 01010
 * 01110
 * 00000
 * 输出
 * 复制
 * 0
 * 示例2
 * 输入
 * 复制
 * 01110
 * 01010
 * 01110
 * 01010
 * 01110
 * 输出
 * 复制
 * 8
 */


import java.util.Scanner;

public class Main01 {
    private static int is089(int [][]matrix){
        // 左下角1
        int x = 0;
        int y = 5;
        for (int i = 0; i < 5; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                if (matrix[i][i1] ==1) {
                    if (i>=x && y>=i1){
                        x = i;
                        y = i1;
                    }
                }
            }
        }
//        System.out.println(x);
//        System.out.println(y);
        if (matrix[x-1][y] == 0){
            return 9;
        }
        int cnt = 0;
        for (int i = 0; i<5; i++) {
            if (x-i>=0&& matrix[x-i][y] == 1 && matrix[x-i][y+1] == 1){
                cnt++;
            }
        }
        return cnt==3?8:0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] matrix = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String str = scanner.nextLine();
            for (int i1 = 0; i1 < 5; i1++) {
                matrix[i][i1] = str.charAt(i1)-'0';
            }
        }
        System.out.println(is089(matrix));

        scanner.close();
    }
}

/**

 00000
 01110
 01010
 01110
 00000


 */