package leetcode.vijos;

import java.io.IOException;
import java.util.*;

/**
 * Created by Edwin Xu on 10/19/2020 9:42 PM.
 *
 * 不高兴的津津
 * 描述
 * 津津上初中了。妈妈认为津津应该更加用功学习，所以津津除了上学之外，还要参加妈妈为她报名的各科复习班。另外每周妈妈还会送她去学习朗诵、舞蹈和钢琴。但是津津如果一天上课超过八个小时就会不高兴，而且，上得越久就会越不高兴。假设津津不会因为其它事不高兴，并且她的不高兴不会持续到第二天。请你帮忙检查一下津津下周的日程安排，看看下周她会不会不高兴；如果会的话，哪天最不高兴。
 *
 * 格式
 * 输入格式
 * 输入包括七行数据，分别表示周一到周日的日程安排。每行包括两个小于10的非负整数，用空格隔开，分别表示津津在学校上课的时间和妈妈安排她上课的时间。
 *
 * 输出格式
 * 输出包括一行，这一行只包含一个数字。如果不会不高兴则输出0，如果会则输出最不高兴的是周几(用1,2,3,4,5,6,7分别表示周一，周二，周三，周四，周五，周六，周日)。如果有两天或两天以上不高兴的程度相当，则输出时间最靠前的—天。
 *
 * 样例1
 * 样例输入1
 * 5 3
 * 6 2
 * 7 2
 * 5 3
 * 5 4
 * 0 4
 * 0 6
 *
 * Copy
 * 样例输出1
 * 3
 */
import java.util.*;
public class P1113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i]  = sc.nextInt()+ sc.nextInt();
        }
        sc.close();

        int unHappyDay = 0;
        int max = 0;
        for (int i = 0; i <7; i++) {
            if (arr[i]>max){
                max = arr[i];
                unHappyDay = i+1;
            }
        }
        System.out.println(unHappyDay);
    }
}
