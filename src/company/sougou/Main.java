package company.sougou;

import leetcode.util.Print;

import java.util.*;

/*
*
* 考得差
*
* 40
* 100
* 0
*
* */
public class Main {

    /*
    * 第一题：
    *
    * N道选择题： 选项ABCD
    * XY两位同学做：
    * 现在给出：
    * n:总题数
    * k:Y做对的题目数
    * str1/str2: XY的答案
    *
    * eg: 4 3 "ABC" "CBA"
    *
    *
    *
    * 40%
    * */
    public Interval solve(int n, int k, String str1, String str2) {

        if (str1.equals(str2))return new Interval(k,k);

        int sameNum = 0; //相同的答案 的题数
        for (int i = 0; i <n ; i++) {
            if (str1.charAt(i)==str2.charAt(i))sameNum++;
        }

        int difNum = n -sameNum;

        //朋友做对了K道
        int wrong =  n-k; //朋友错了的

        int max =0 ;
        int min =0 ;

        if (k>=sameNum){
            max = sameNum+wrong;
            min = k - difNum ;
        }else{
            max = k+wrong;
            if (wrong-k>0){
                min = 0;
            }else{
                min = k-wrong;
            }
        }


//        max = 2*Math.min( sameNum,k) + difNum - k;
//        min = Math.max(0,k-difNum);


        return new Interval(max,min);

    }



    /*
    * 第二题：
    * s1: 解密举证。01组成，0透明
    * s2: 加密后的密文矩阵
    *
    * s1贴到s2上，读取密文解析；
    * s1顺时针旋转, 再次读取
    * 共读取四次，得到解密后的密文。
    *
    * */
    public String rotatePassword (String[] s1, String[] s2) {
        char [][] decode = new char[s1.length][s1[0].length()];
        for (int i = 0; i < s1.length; i++) {
            decode[i] = s1[i].toCharArray();
        }

        char [][] code = new char[s2.length][s2[0].length()];
        for (int i = 0; i < s2.length; i++) {
            code[i] = s2[i].toCharArray();
        }

        StringBuilder source = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <decode.length ; j++) {
                for (int k = 0; k <decode[0].length ; k++) {
                    if (decode[j][k]=='0'){
                        source.append(code[j][k]);
                    }
                }
            }
            if (i!=3){
                char [][] chs = new char[decode.length][decode[0].length];
                for (int j = 0; j <chs.length ; j++) {
                    for (int k = 0; k < chs[0].length ; k++) {
                        chs[j][k] = decode[chs.length-k-1][j];
                    }
                }
                decode = chs; //翻转矩阵
            }
        }
        return source.toString();
    }











    public static void main(String[] args) {
        Main m =   new Main();
//       Interval interval = m.solve(3,2,"ABC","ACB");
//        Print.print(interval.start,interval.end);
//
//        String s1 [] ={"1101","1010","1111","1110"};
//        String s2 [] ={"ABCD","EFGH","IJKL","MNPQ"};
//        System.out.println( m.rotatePassword(s1,s2));


         Interval []intervals = new Interval[4];
         intervals[0] = new Interval(0,1);
         intervals[1] = new Interval(0,2);
         intervals[2] = new Interval(2,-1);
         intervals[3] = new Interval(2,1);

         m.trim(3,4,intervals);


    }











    /*
    * 第三题：
    * 字母组成词，删除无效的字母
    *
    * 给出1~N个数：
    * 理解为一个图：
    * 0：头
    * -1：尾
    * 给出边:如 <1,2> <2,-1> <0,3>
    * 现在找出其中不能到达尾部的 数，删除之，
    * 求剩下的数个数，以及和
    *
    *
    *
    * 这题我的第一想法是构建 Node节点，每个Node可以指向多个Node
    * 这是可以的。
    *
    * 但是注意：
    * 比如：
    *
    *
    *
    *     /---
    *    -----\
    * 0- /------<-1>
    *   \  |
    *    \--
    *     \----
    *
    * =====需要倒过来=====
    * =====需要倒过来=====
    * =====需要倒过来=====
    * =====需要倒过来=====
    * 从-1出发，直到到达0， 图中的没一点都是必要的
    * 其他的都不必要
    *
    *
    *
    * 另外，可以使用邻接矩阵。
    * 1 0 0
    * 1 1 1
    * 0 1 1
    *
    *
    *
    * 0分
    *
    *
    *
    * */

    Map<Integer ,Node> map  = new HashMap<>();

    public Interval trim (int N, int M, Interval[] conn) {

        for (Interval interval: conn) {
            if (map.containsKey(interval.start)){
                Node n = map.get(interval.start);
                if (! map.containsKey(interval.end)){
                    Node to = new Node(interval.end);
                    map.put(interval.end,to);
                }
                n.next.add(map.get(interval.end));

            }else{
                map.put( interval.start,new Node(interval.start));
            }
        }

        if (!map.containsKey(0)  ||   !map.containsKey(-1))return new Interval(0,0);

        dfs(map.get(0));




        int s = 0;
        for (int i:set){
            s+=i;
        }
        System.out.println( N - res);
        System.out.println(s%100000007);

        return new Interval(  N - res , s%100000007);

    }

    Set<Integer> set = new HashSet<>();



    int res = -1;
    int sum = 0;
    void dfs(Node n){

        if (n == map.get(-1)){
            return;
        }
        if (n.val==-2)return;

        res++;

        set.add(n.val);  //


        n.val = -2;
        for (Node node : n.next){
            dfs(node);
        }

    }

}

class Node{
    int val;
    LinkedList <Node> next;

    public Node(int val) {
        this.val = val;
        next = new LinkedList<>();
    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
