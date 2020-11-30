package company.c360;

import java.util.*;

/**
 * Created by Edwin Xu on 9/11/2020 8:30 PM
 */
public class Main {
    public Main(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int [][] arr = new int[m][2];

        TreeSet<Integer> treeSet = new TreeSet<>();

        int on = 0;
        int off = 0;

        for (int i = 0; i <m ; i++) {
            arr[i][0]  = scanner.nextInt();
            arr[i][1]  = scanner.nextInt();

            treeSet.add(arr[i][0]);

            if (arr[i][1]==1){
                on++;
            }else{
                off++;
            }
        }


        /*
        * 记录里面
        * 如果全部是上班打卡:
        *   第一个及以及没出现的的都可能是
        * 如果全部是下班打卡：
        *   最后一个及没出现的都可能
        *
        * 否则：
        *
        * */

        ArrayList<Integer> offOfWork = new ArrayList<>();
        for (int i = 1;i<=n;i++){
            if (!treeSet.contains(i)){
                offOfWork.add(i);
            }
        }

        int firstOn =  arr[0][0];
        int lastOff = arr[arr.length-1][0];

//        System.out.println(offOfWork.size());

        if (off==0){
            //全是上班
            offOfWork.add(firstOn);

        }
        else if (on==0){
            //全是下班
            offOfWork.add(lastOff);

        }
        else{
            //同时有上下班打卡


        }

        Collections.sort(offOfWork);
        show(offOfWork);


    }

    private void show(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for (int i :list) {
            sb.append(i);
            sb.append(" ");
        }
        if (sb.length()>0)sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }

    public static void main(String[] args) {
        new Main();
    }

}


/*

3 2
1 1
2 0

* */