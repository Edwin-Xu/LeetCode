package company.zte.exam_20200903;


import java.util.Scanner;

public class Main1 {
    public Main1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();;
        comb(n,k);
    }

    /*
    * 定位第一个数A，使右边>A的只有K-1个
    * A= n-k+1
    * 然后输出顺序 k-1个比A大的，剩下的全部是小的，最后输出
    * */
    public void comb(int n,int k){
        StringBuilder sb = new StringBuilder();
        String space = " ";
        for (int i = n-k+1; i <=n ; i++) {
            sb.append(i);
            sb.append(space);
        }
        for (int i = 1; i < n-k+1; i++) {
            sb.append(i);
            if (i!=n-k) sb.append(space);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        new Main1();
    }
}
