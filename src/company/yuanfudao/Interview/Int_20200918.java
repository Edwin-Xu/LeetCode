package company.yuanfudao.Interview;

/**
 *
 * 给出一个数N
 * 求1-N的字典序
 *
 *
 *
 * 当成一颗多叉树
 *
 */

import java.util.*;

public class Int_20200918 {
    public static void main(String[] args) {
        Int_20200918 main = new Int_20200918();
        List<Integer> res = main.func(170);
        res.forEach(System.out::println);
    }

    public List<Integer> func(int n) {
        this.num = n;
        preOrder(0);
        return list;
    }

    int num ;
    List<Integer> list = new ArrayList<>();
    public void preOrder(int n){
        if(n>num)return;
        if(n!=0)list.add(n);
        for(int i = 0; i< 10;i++){
            preOrder(Math.max(1, n*10+i));
        }
    }


}