package leetcode.lc;

/**
 * Created by Edwin Xu on 6/25/2020 7:11 PM
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 分析：首先需要确定的是：开始点，需要遍历
 */
public class LC_79 {
    public boolean exist(char[][] board, String word) {
        if (board.length==0 || board[0].length==0 || word.length()==0)return false;
        if (board.length==1&&board[0].length==1&&word.length()==1&&board[0][0]==word.charAt(0))return true;
        char [] w = word.toCharArray();
        for (int i = 0;i<board.length;i++)
            for (int j = 0;j< board[0].length;j++)
                if (dfs(board,i,j,w,0))return true;
        return false;
    }
    private boolean dfs(char [][]board,int x,int y,char[]word, int wordIndex){
        if (x<0||x>=board.length || y<0 || y>=board[0].length )return false;
        if (board[x][y]!=word[wordIndex])return false;
        else{
            if (wordIndex+1==word.length)return true;
            char tmp = board[x][y];
            board[x][y] = 1; //走过的设置为1
            boolean up = (x-1>=0)&&board[x-1][y]!=1&&dfs(board,x-1,y,word,wordIndex+1);
            boolean down = (x+1<board.length)&&board[x+1][y]!=1&&dfs(board,x+1,y,word,wordIndex+1);
            boolean left = (y-1>=0)&&board[x][y-1]!=1&&dfs(board,x,y-1,word,wordIndex+1);
            boolean right = (y+1<board[0].length)&&board[x][y+1]!=1&&dfs(board,x,y+1,word,wordIndex+1);
            boolean res =  up||down||left||right;
            if (!res)board[x][y] = tmp;  //死胡同，当前的转为没走过
            return res;
        }
    }

    public static void main(String[] args) {
        LC_79 lc_79 = new LC_79();
        char board[][] =
//                {
//                        {'A', 'B', 'C', 'E'},
//                        {'S', 'F', 'C', 'S'},
//                        {'A', 'D', 'E', 'E'}
//                };
                {{
                 'a','a'}
                };

        String word = "aa";

        System.out.println(lc_79.exist(board,word));
    }
}
