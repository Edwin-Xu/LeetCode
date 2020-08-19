package leetcode.lc;

/**
 * Created by Edwin Xu on 8/3/2020 9:45 PM
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 */
public class LC_14 {
    /*
    * 纵向比较
    * */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        int i = 0;
        for (;i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean isover = false;
            for (int j=1;j<strs.length;j++){
                if (strs[j].length()==i || strs[j].charAt(i)!=c){
                    isover=true;
                    break;
                }
            }
            if (isover)break;
        }
        System.out.println(strs[0].substring(0,i));

        return strs[0].substring(0,i);
    }


    /*
    * 先字符串数组 字典排序
    * class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if(strs.empty()) return string();
        sort(strs.begin(), strs.end());
        string st = strs.front(), en = strs.back();
        int i, num = min(st.size(), en.size());
        for(i = 0; i < num && st[i] == en[i]; i ++);
        return string(st, 0, i);
    }
};
    *
    * */


    /*
    * 横向比较：
    * 从前往后：先找出两两的公共前缀，然后往后，不断比较
    * */

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            int count = strs.length;
            for (int i = 1; i < count; i++) {
                prefix = longestCommonPrefix(prefix, strs[i]);
                if (prefix.length() == 0) {
                    break;
                }
            }
            return prefix;
        }

        public String longestCommonPrefix(String str1, String str2) {
            int length = Math.min(str1.length(), str2.length());
            int index = 0;
            while (index < length && str1.charAt(index) == str2.charAt(index)) {
                index++;
            }
            return str1.substring(0, index);
        }
    }

}




















