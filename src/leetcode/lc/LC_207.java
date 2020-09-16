package leetcode.lc;

import leetcode.util.Print;

import java.util.HashSet;

/**
 * Created by Edwin Xu on 9/13/2020 11:55 PM
 *
 * 207. 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 */

/*
* 拓扑排序
*
* 步骤：
* -循环： 选择入度=0的顶点，输出，从图中删除，同时删除相应的边
* 如果最终输出的顶点数<总顶点数，有环。
*
*
* vertex
* edge
*
* */
public class LC_207 {
    //使用邻接矩阵。时间复杂度高
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] arr = new int[numCourses][numCourses];
        for (int[] courses: prerequisites){
            //courses[1]->courses[0]
            arr[courses[1]][courses[0]]=1;   // arr[i][j] : i-->j的边
        }
        Print.printArr(arr);
        HashSet<Integer> vertexSet = new HashSet<>();
        while (true){
            //选择一个入度为0的顶点：入度=0，说明该列全部为0
            int vertex = -1;
            for (int i = 0; i <numCourses ; i++) {
                if (vertexSet.contains(i))continue;

                int cnt = 0;
                for (int j = 0; j <numCourses ; j++) {
                    if (arr[j][i]==0)cnt++;
                    else break;
                }
                if (cnt==numCourses){
                    vertex = i;
                }else continue;
            }

            if (vertex==-1)break;

            System.out.println(vertex);
            vertexSet.add(vertex);

            for (int i = 0; i <numCourses ; i++) {
                arr[vertex][i] = 0;
            }
        }
        if (vertexSet.size()<numCourses)return false;
        return true;
    }


    public static void main(String[] args) {
        LC_207 lc_207 = new LC_207();

        int n = 4;
        int[][] arr = {
                {1,0},
                {2,1},
                {3,2},
        };

        System.out.println(lc_207.canFinish(n,arr));

    }
}





















