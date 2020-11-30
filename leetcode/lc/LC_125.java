package leetcode.lc;

/**
 * Created by Edwin Xu on 6/19/2020 2:29 PM
 * 验证回文串
 *
 *
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LC_125 {

    public boolean isPalindrome_mine(String s) {

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c>47&&c<58)sb.append(c);
            else if(c>64&&c<91)sb.append((char)(c+32));
            else if(c>96&&c<123)sb.append(c);

        }
        s = sb.toString();

        if(s.length()<2)return true;

        int len = s.length();
        char arr[] = new char[len*2-1];
        for(int i=0;i<len-1;i++){
            arr[i*2]=s.charAt(i);
            arr[i*2+1]='#';
        }
        arr[len*2-2]=s.charAt(len-1);

        for(int i=0,j=arr.length-1;i<j;i++,j--){
            if(arr[i]!=arr[j])return false;
        }
        return true;

    }


    /*
    * 使用双指针：
    * 分别指向前后
    * 每次向中间移动1位(非字母数字跳过)
    * 最后两个指针相遇则是回文
    *
    * 相遇：相邻或者位于同一位置。
    * */
    public Boolean towPointer(String s){
       int i=0;
       int j = s.length()-1;
       while (i<=j){
           while (!isNumOrAlpha(s.charAt(i)))i++;
           while (!isNumOrAlpha(s.charAt(j)))j--;
           System.out.println(s.charAt(i)+", "+s.charAt(j));
           if ((s.charAt(i)|0x20)!=(0x20|s.charAt(j)))return false;
           i++;
           j--;
       }
       return true;
    }
    public Boolean isNumOrAlpha(char c){
        if (c>47&&c<58)return true;
        int a= c&0xDF;
        if(a>64&&a<98)return true;
        return false;
    }


    class Solution {
        public boolean isPalindrome(String s) {
            int n = s.length();
            int left = 0, right = n - 1;
            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    ++left;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    --right;
                }
                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    ++left;
                    --right;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC_125().towPointer("A man, a plan, a canal: Panama"));

    }


    /*
    * 区分中心扩展：这是用于寻找以某个字符为中心的最大回文串
    *
    * 单纯判断只需要双指针
    *
    * */
}
