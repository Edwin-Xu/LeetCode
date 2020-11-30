package company.huawei;

import java.util.Scanner;

/**
 * Created by Edwin Xu on 4/15/2020 12:11 AM
 *
 *输入一个字符串，求出该字符串包含的字符集合
 *
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 *
 * 使用循环链表：
 */
public class MinCharSet {



    private Scanner sc ;

    public MinCharSet(){
        sc = new Scanner(System.in);
        String s;
        while (sc.hasNext()){
          s = sc.nextLine();
          System.out.println(getColl(s));
        }
        sc.close();

    }

    private String getColl(String s){
        String res= "";
        int [] note = new int[127];
        char []chars = s.toCharArray();
        for (char c:chars){
            System.out.print(note[c]);
            if (note[c]==0){
                res+=c;
                note[c]=1;
            }

        }
        System.out.println(res);
        return res;

    }

    public static void main(String[] args) {
        new MinCharSet();
    }
}
