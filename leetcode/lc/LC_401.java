package leetcode.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Edwin Xu
 * @date 6/21/2021 12:27 PM.
 *
 * N 位二进制，如果取K位1，返回所有的可能值
 */

public class LC_401 {

    /**
     * C(n,k)
     * */
    private static Map<Integer, List<Integer>> hour = new HashMap<>();
    private static Map<Integer, List<String>> minute = new HashMap<>();

    static {
        initHour();
        initMinute();
    }


    private static void initHour(){
        for (int i = 0; i < 12; i++) {
            int cnt = 0;
            for (int j = 0; j <4 ; j++) {
                if (((i>>j)&1)==1){
                    cnt++;
                }
            }
            hour.computeIfAbsent(cnt, k -> new ArrayList<>());
            hour.get(cnt).add(i);
        }
    }
    private static void initMinute(){
        for (int i = 0; i < 60; i++) {
            int cnt = 0;
            for (int j = 0; j <6 ; j++) {
                if (((i>>j)&1)==1){
                    cnt++;
                }
            }
            minute.computeIfAbsent(cnt, k -> new ArrayList<>());
            minute.get(cnt).add(i<10 ? "0"+ i :String.valueOf(i));
        }
    }




    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0 ; i <=turnedOn ; i++){
            int minuteBinary = turnedOn - i;
            List<Integer> hourList = hour.get(i);
            List<String> minList = minute.get(minuteBinary);
            if (hourList == null || minList == null){
                continue;
            }
            for (Integer hou : hourList) {
                for (String min :minList) {
                    res.add(hou+":"+min);
                }
            }
        }
        return res;
    }



    /**
     * 计算二进制中1的个数
     * */
    int count1_m1(int n) {
        int res = 0;
        while (n != 0) {
            // 下面这条语句会消去一个1
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    int count1_m2(int n){
        return  Integer.bitCount(n);
    }

    int count1_m3(int n){
        // 循环
        return 0;
    }



    public static void main(String[] args) {
        LC_401 binaryComb = new LC_401();
        List<String> comb = binaryComb.readBinaryWatch(9);
        comb.forEach(System.out::println);
    }
}
