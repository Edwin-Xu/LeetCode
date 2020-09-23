package company.fanruan;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/*
 * 给出多个<k,v>升序链表
 *
 * 合并为一个，相同k的v它们之和
 *
 *
 * 不知道哪里错了，只过了一半
 * */
public class Main {
    public Main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Pair[] pairs = new Pair[n];

        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line[] = scanner.nextLine().split(" +|:");
            if (arr[i] == 0) continue;
            pairs[i] = new Pair(Integer.valueOf(line[0]), Integer.valueOf(line[1]));
            Pair cur = pairs[i];
            for (int j = 1; j < arr[i]; j++) {
                Pair p = new Pair(Integer.valueOf(line[2 * j]), Integer.valueOf(line[2 * j + 1]));
                cur.next = p;
                cur = p;
            }
        }
//
//        for (int i = 0; i < n; i++) {
//            showPair(pairs[i]);
//        }
//        showPair(mergeAll(pairs));

        showPair(mergeAll(pairs, 0, pairs.length - 1));

    }

    /*
     * 迭代方式
     * */
    private Pair mergeAll(Pair[] pairs) {
        for (int i = 1; i < pairs.length; i++) {
            pairs[i] = mergeTwo(pairs[i], pairs[i - 1]);
        }
        return pairs[pairs.length - 1];
    }

    /*
     * 归并方式
     * */
    private Pair mergeAll(Pair[] pairs, int i, int j) {
        if (i > j || i < 0 || j >= pairs.length) return null;
        if (i == j) return pairs[i];
        int mid = (i + j) / 2;
        return mergeTwo(mergeAll(pairs, i, mid), mergeAll(pairs, mid + 1, j));
    }


    private Pair mergeTwo(Pair a, Pair b) {
        if (a == null) return b;
        if (b == null) return a;

        Pair head = new Pair(0, 0);
        Pair cur = head;

        while (a != null && b != null) {
            if (a.k < b.k) {
                if (cur.k == a.k) cur.v += a.v; //保证和前一个不同
                else cur.next = a;
                a = a.next;
            } else if (a.k > b.k) {
                if (cur.k == b.k) cur.v += b.v;
                else cur.next = b;

                b = b.next;
            } else {
                if (cur.k == a.k) cur.v += a.v + b.v;
                else cur.next = new Pair(a.k, a.v + b.v);
                a = a.next;
                b = b.next;
            }
            cur = cur.next;
        }

        while (a != null) {
            if (cur.k == a.k) cur.v += a.v;
            else cur.next = a;
            a = a.next;
        }
        while (b != null) {
            if (cur.k == b.k) cur.v += b.v;
            else cur.next = b;
            b = b.next;
        }

        return head.next;
    }


    private void showPair(Pair p) {
        while (p != null) {
            System.out.print(p.k + ":" + p.v);
            p = p.next;
            if (p != null) System.out.print(" ");
        }
        System.out.println();
    }

    class Pair {
        int k;
        int v;
        Pair next;
        Pair(int k_, int v_) {
            k = k_;
            v = v_;
        }
    }

    public static void main(String[] args) {
        new Main();
//        int is;
//        int res ;
//        is = res =1;
//        System.out.println(is+" "+res);
    }
}

/*

3 3 4 3
1:5 3:8 5:1
1:2 2:2 4:3  5:2
2:3 4:4 6:3

* */


/*
* 1-N顺序进栈
*
* 出栈顺序有多少种
*
*
* */