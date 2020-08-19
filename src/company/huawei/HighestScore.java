package company.huawei;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 4/14/2020 9:02 PM
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模
 * 拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 *
 *
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 */
public class HighestScore {

    private int N;
    private int M;
    private int stu[];

    private int [][] ord;

    private Scanner sc;

    public HighestScore(){
        sc = new Scanner(System.in);

        String arr[] ;

        while (sc.hasNext()){
            arr = sc.nextLine().split(" ");
            N = Integer.valueOf(arr[0]);
            M = Integer.valueOf(arr[1]);
            stu = new int[N];
            arr = sc.nextLine().split(" ");

            for (int i=0;i<N;i++){
                stu[i]= Integer.valueOf(arr[i]);
            }

            String tmp[];
            for (int i=0;i<M;i++){
                tmp = sc.nextLine().split(" ");
                int a=tmp[0].equals("Q")?1:0; //1:Q  0:U
                int b = Integer.valueOf(tmp[1]);
                int c = Integer.valueOf(tmp[2]);


                if (a==1){//Q
                    int max = stu[b-1];
                    if (b>c){//大小问题
                        int t = b;
                        b = c;
                        c= t;
                    }
                    for (int y=b-1;y<c;y++){
                        if (max<stu[y])max =stu[y];
                    }
                    System.out.println(max);
                }
                else{//U
                    stu[b-1]=c;
                }
            }
        }
    }

    public static void main(String[] args) {
        new HighestScore();
    }

}

/*
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5
10 2
43 36 1 27 2 4 11 25 32 49
U 7 57
Q 1 2


 */
