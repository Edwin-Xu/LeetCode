package leetcode.lc;

/**
 * Created by Edwin Xu on 3/17/2020 10:50 PM
 *
 *
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_1160 {

    public int countCharacters(String[] words, String chars) {
        int [] [] arr = new int[123][2]; //使用一个二维数组记录chars中每一个字母出现的次数，97-122对应a-z。这里避免后面不断减97，牺牲空间换取时间，前97个数组单元无用。
        for (char ch: chars.toCharArray()){
            arr[ch][0]++;//初始化
        }
        int sum =0;//计数：掌握的所有单词的 长度之和
        for (String word : words){
            for (int i=97;i<123;i++){//从arr导入过来
                arr[i][1]=arr[i][0];
            }
            boolean match =true;//是否匹配
            for (char ch:word.toCharArray()){//遍历每一个Word的字母
                if(arr[ch][1]--==0){//每次使用该字母作为下标，给数组减1，减之前<=0即表示字母已经被用完了，不可能匹配
                    match = false;
                    break;
                }
            }
            if (match) sum+=word.length();//加上Word长度
        }
        return sum;
    }

    public static void main(String[] args) {
        String [] a={"hello","world","leetcode","well"};
        String  b="welldonehoneyr";
        System.out.println(new LC_1160().countCharacters(a,b));
    }
}
