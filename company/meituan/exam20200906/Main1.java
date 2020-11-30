package company.meituan.exam20200906;

import java.util.*;

/*
 * 有数：1-N之间
 *
 * A有若干个
 * B有若干个
 *
 * 求只有A有、只有B有、和AB都有的数个数
 *
 * */
public class Main1 {
    public Main1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        HashMap<Integer, Integer> aMap = new HashMap<>(A);
        HashMap<Integer, Integer> bMap = new HashMap<>(B);

        for (int i = 0; i < A; i++) {
            aMap.put(scanner.nextInt(), 0);
        }
        for (int i = 0; i < B; i++) {
            bMap.put(scanner.nextInt(), 0);
        }
        scanner.close();

        int aNum = 0;
        int bNum = 0;
        int common = 0;
        for (int a : aMap.keySet()) {
            if (bMap.containsKey(a)) { //B 也有： common
                common++;
            } else {
                aNum++; //B 没有，A独有
            }
        }
        for (int b : bMap.keySet()) {
            if (!aMap.containsKey(b)) { //
                bNum++;
            }
        }
        System.out.println(aNum + " " + bNum + " " + common);
    }

    public static void main(String[] args) {
        new Main1();
    }


    /*
     * 反思：
     * 更好的方式：
     * 使用一个Set
     * 然后A往其中扔
     * B也往其中扔
     *
     * 然后： Set中有C个-----common
     * A私有的： A-common
     * B私有的：B-common
     *
     * */

    public void better() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A + B; i++) {
            set.add(scanner.nextInt());
        }
        scanner.close();
        int common = set.size();
        System.out.println((A - common) + " " + common + " " + (B - common));
    }


}

