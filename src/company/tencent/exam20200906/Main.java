package company.tencent.exam20200906;


import java.util.*;

public class Main {

    public Main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];



        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int []c = Arrays.copyOf(arr,arr.length);

        Arrays.sort(arr);

        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map2.put(arr[i],i);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = map2.get(c[i]);
            if (x>(n-1)/2){
                sb.append(arr[(n-1)/2]);
            }else{
                sb.append(arr[(n-1)/2 +1 ]);
            }
            if (i!=n-1)sb.append("\n");
        }

        System.out.println(sb.toString());
    }





    public static void main(String[] args) {
        new Main();
    }
}


