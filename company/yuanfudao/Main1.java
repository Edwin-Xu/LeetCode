package company.yuanfudao;

//100%
import java.util.ArrayList;
import java.util.Scanner;
public class Main1 {
    public Main1(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int arr [] = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int mid = n/2;

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> list = new ArrayList<>(n);
            //不使用额外开销也行？ 直接原地交换，是可以的，稍麻烦点

            int x = 0 ;
            int y = mid;
            while (x<mid && y<n){
                list.add(arr[y]);
                list.add(arr[x]);
                x++;
                y++;
            }
            if (y!=n){
                list.add(arr[y]);
            }


            for (int j = 0; j <n ; j++) {
                arr[j] =list.get(j);
            }
//            Print.printArr(arr);

        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        new Main1();
    }
}
