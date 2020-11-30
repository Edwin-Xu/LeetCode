package leetcode.lc;

/**
 * Created by Edwin Xu on 3/15/2020 2:20 PM
 */
public class LC_9 {
//    public boolean isPalindrome(int x) {
//        if (x>=0){
//            String tmp = Integer.toString(x);
//            String revStr = new StringBuilder(tmp).reverse().toString();
//            if (revStr.equals(tmp))return true;
//        }
//        return false;
//    }

/*
123
 */

//    public boolean isPalindrome(int x) {
//        if (x<0) return false;
//        String str = Integer.toString(x);
//        int len = str.length();
//        for (int i=0,j=len-1;i<j;i++,j--){
//            if (str.charAt(i)!=str.charAt(j))return false;
////            if (i>=j)break;
//        }
//        return true;
//    }


    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0&&x%10==0)) return false;
        int rev = 0;
        while(x>rev){
            rev = rev + x%10;
            x/=10;
        }
        return x==rev || x==rev/10;
    }

    public static void main(String[] args) {
        System.out.println(  new LC_9().isPalindrome(111));
    }
}
