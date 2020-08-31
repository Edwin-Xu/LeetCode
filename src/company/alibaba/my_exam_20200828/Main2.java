package company.alibaba.my_exam_20200828;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Edwin Xu on 8/28/2020 7:06 PM
 *
 * 一个数：
 * 其数字的全排列中：
 *   不含前缀0、能被m整除的有多少个？
 *
 */
public class Main2 {
    public void f(){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        scanner.close();

        ArrayList<Long> arrayList = new ArrayList<>();
        while (n!=0){
            arrayList.add(n%10);
            n/=10;
        }
        recur(arrayList,"");

        for (String s:strings){
            if (s.charAt(0)!='0' && Integer.valueOf(s)%m==0){
                res++;
            }
        }

        System.out.println(res);

    }

    private int res = 0;
    HashSet<String > strings = new HashSet<>();
    public void recur(ArrayList<Long>list,String num){
        if (list.size()==0){
            strings.add(num);
        }else{
            ArrayList<Long> tmp = new ArrayList<>(list);
            for (Long a:list){
                tmp.remove(new Long(a));
                recur(tmp,num+a);
                tmp.add(a);
            }
        }

    }

    public static void main(String[] args) {

        Main2 main2 = new Main2();
        main2.f();
    }
}
