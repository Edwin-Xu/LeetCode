package company.tencent.exam20200521;
import java.util.*;

/**
 * @author Edwin Xu
 * @date 5/21/2021 2:10 PM.
 *
 *
 * 第一行输入一个正整数 ，代表这份问卷的题目总数。
 *
 * 对于每道题，第一行输入一个正整数 ，代表这道题中的数字个数。
 * 第二行输入  个正整数 ，代表这道题中的每个数字。
 *
 * 对于问卷中的每道问题，一行输出一个整数代表答案（最小的一个只出现了一次的数字）；
 * 特殊的，如果不存在这样的数字，则输出  代表无解。
 */

public class Main01{
    public static void main(String [] a){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0;j<N;j++){
                int num = sc.nextInt();
                if(map.containsKey(num)){
                    map.put(num, map.get(num)+1);
                }else{
                    map.put(num,1);
                }
            }
            int minKey= Integer.MAX_VALUE;
            int minVal = Integer.MAX_VALUE;
            for(Map.Entry<Integer,Integer> e: map.entrySet()){
                if(e.getValue()<minVal||(e.getValue()==minVal&&e.getKey()<minKey)){
                    minVal = e.getValue();
                    minKey = e.getKey();
                }
            }
            if(map.get(minKey)!=1 || minKey==Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(minKey);
            }
        }
    }
}