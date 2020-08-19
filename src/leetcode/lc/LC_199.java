package leetcode.lc;

import leetcode.util.ConstructTree;
import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edwin Xu on 7/26/2020 4:30 PM
 *199. 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，
 * 返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 方式1: 程序遍历：返回每层最后一个
 * 方式2：对一个节点p，看有没有右节点：
 *      - 没有右节点,p指向左节点，再次判断
 *      - 有右节点：打印右节点，p指向右节点，再次判断
 *
 *      方式2有问题：如果左子树更加深，一走到右子树就回不去了
 *      怎么解决这个问题：如果达到了叶子节点，就要往左切换到左兄弟
 */
public class LC_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root!=null){
            res.add(root.val);
            if (root.right!=null){
                root=root.right;
            }else if (root.left!=null){
                root = root.left;
            }else{//达到了右节点，需要切换到左边第一个兄弟

                //使用递归，需要借助深度
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = ConstructTree.construct("1,2,3,null,5,null,4");
        List<Integer> res = new LC_199().rightSideView(root);
        for (int a:res){
            System.out.println(a);
        }
    }
}
