package company.sina;


/*
* 判断字符数组中是否有重复的字符
*
* 空间复杂度要求 O(1)
* 时间复杂度 O(NlogN)
*
*
* */

import java.util.Scanner;

public class Main2 {
    public Main2(){
        Scanner scanner = new Scanner(System.in);
        char[] chs = scanner.nextLine().toCharArray();
        scanner.close();

        /*
        * 方法1： 使用hashMap， 时间复杂度：O(N)，空间复杂度：O(N)
        * */
//        Map<Character,Integer> map = new HashMap<>();
//        for(char c:chs){
//            if (map.containsKey(c)){
//                System.out.println(false);
//                return;
//            }else{
//                map.put(c,0);
//            }
//        }
//        System.out.println(true);

        //----------------------------------------------------------------

        /*
        * 方法2： 快排+二分查找
        * 先对输入字符排序，然后遍历字符，对每一个字符，去字符数组中查找，
        * 如果找到的字符不是当前字符，那说明存在两个相同的字符，返回false
        * 否则，不存在相同字符，返回true
        *
        * 时间复杂度：
        *   快排 O(NlogN) + 遍历且二分查找N*logN
        *   = NlogN
        *
        * 空间复杂度：不算输入的字符串空间，是O(1)
        *
        * */


        quickSort(chs,0,chs.length-1);

        for (int i = 0; i < chs.length; i++) {
            int index = binarySearch(chs,chs[i]);
            if (index!=i){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    //二分查找
    private int binarySearch(char[]chs,char target){
        int L = 0, R =chs.length-1;
        while (L<=R){
            int mid = (L+R)/2;
            if (chs[mid]==target){
                return mid; //找到
            }else if (chs[mid]<target){
                L=mid+1;
            }else {
                R = mid-1;
            }
        }
        return -1; //找不到
    }

    public void quickSort(char[] arr,int left,int right){
        int R = right;
        int L = left;
        if (L<R){
            char tmp = arr[left];
            while (L<R){
                while (L<R&& arr[R]>=tmp)R--;
                arr[L]=arr[R];
                while (L<R&& arr[L]<=tmp)L++;
                arr[R]=arr[L];
            }
            arr[L]=tmp;
            quickSort(arr,left,L-1);
            quickSort(arr,R+1,right);
        }
    }

    public static void main(String[] args) {
        new Main2();
    }
}
