package company.neteasy;

import java.util.*;

/**
 * @author Edwin Xu
 * @date 2/3/2021 10:44 PM.
 * 买票问题:
 * 现在有n个人排队买票，已知是早上8点开始卖票，这n个人买票有两种方式：
 *
 * 第一种是每一个人都可以单独去买自己的票，第 i 个人花费 a[i] 秒。
 *
 * 第二种是每一个人都可以选择和自己后面的人一起买票，第 i 个人和第 i+1 个人一共花费 b[i] 秒。
 *
 * 最后一个人只能和前面的人一起买票或单独买票。
 *
 * 由于卖票的地方想早些关门，所以他想知道他最早几点可以关门，请输出一个时间格式形如：08:00:40 am/pm
 *
 * 时间的数字要保持 2 位，若是上午结束，是 am ，下午结束是 pm
 *
 *
 * 输入描述:
 * 第一行输入一个整数 T，接下来有 T 组测试数据。
 *
 * 对于每一组测试数据：输入一个数 n，代表有 n 个人买票。
 *
 * 接下来n个数，代表每一个人单独买票的时间 a[i]。
 *
 * 接下来 n-1 个数，代表每一个人和他前面那个人一起买票需要的时间 b[i]
 * 1<= T <=100
 * 1<= n <=2000
 * 1<= a[i] <=50
 * 1<= b[i] <=50
 *
 *
 * 输出描述:
 * 对于每组数据，输出一个时间，代表关门的时间 。
 *
 * 输入例子1:
 * 2
 * 2
 * 20 25
 * 40
 * 1
 * 8
 *
 * 输出例子1:
 * 08:00:40 am
 * 08:00:08 am
 *
 * From https://www.nowcoder.com/question/next?pid=28083482&qid=1262800&tid=40898993
 *
 */

public class TicketProblem {

}