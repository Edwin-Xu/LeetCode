package company.tencent.exam20200521;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Edwin Xu
 * @date 5/21/2021 2:13 PM.
 *
 * 给你一个数组,让第个数加一的代价是b_i,你可以求出让数组a,每个数各不相同的最小代价吗?
 *
 * 输入描述:
 * 第一行一个整数,表示数组长度
 *
 * 第二行个整数a_i,表示数组
 *
 * 第三行个整数b_i,表示第个增加1的代价
 *
 * 输出描述:
 * 一个整数表示结果.
 */



/**
 * 太难了
 *
 https://www.nowcoder.com/test/question/done?tid=44476988&qid=1701886#summary

 #include <bits/stdc++.h>
 typedef long long ll;
 using namespace std;
 struct node
 {
 ll a,b;
 bool operator<(const node X)const
 {
 return a<X.a;
 }
 }e[100005];
 ll ans;
 int main()
 {
 ios::sync_with_stdio(0),cin.tie(0);
 //    freopen(".in","r",stdin);
 //    freopen(".out","w",stdout);
 int i,j=1,n;
 cin>>n;
 for(i=1;i<=n;i++)
 cin>>e[i].a;
 for(i=1;i<=n;i++)
 cin>>e[i].b;
 sort(e+1,e+n+1);
 priority_queue<ll>pq;
 ll cur=e[1].a,sum=0;
 for(i=1;i<=n;i++)// n次计算
    { // 把a值相同的元素，对应的b保存在一个优先队列中，sum存储代价之和
    while(j<=n&&e[j].a==cur)
    {
    pq.push(e[j].b);
    sum+=e[j++].b;
    }
    sum-=pq.top();
    pq.pop();
    ans+=sum;//除了b值最大的，其他元素的a都必须+1
    cur++;
    if(pq.empty())//< 队列为空，没有a值=cur重复的元素
    cur=e[j].a;
    }
    cout<<ans;
    return 0;
    }

 * */
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        SortedMap<Integer,Integer> valMap = new TreeMap<>();
        SortedMap<Integer,Integer> costMap = new TreeMap<>();

        for (int i = 0; i < T; i++) {
            valMap.put(i, sc.nextInt());
        }

        for (int i = 0; i < T; i++) {
            costMap.put(i, sc.nextInt());
        }



    }
}
