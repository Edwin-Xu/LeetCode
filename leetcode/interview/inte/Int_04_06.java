package leetcode.interview.inte;

import leetcode.util.TreeNode;

import java.util.SortedSet;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Edwin Xu on 9/24/2020 11:38 PM
 *
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 */


/*
*
* 如果是一般树：
* 中序遍历下一个节点在那里？
*
* class Solution {
public:
    void inorder(TreeNode* root, vector<TreeNode*>& res) {
        if (root->left) inorder(root->left, res);
        res.push_back(root);
        if (root->right) inorder(root->right, res);
    }

    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        vector<TreeNode*> res;
        inorder(root, res);
        res.push_back(NULL);
        for (int i = 0; i < res.size(); ++i) {
            if (res[i] == p) {
                return res[i+1];
            }
        }
        return NULL;
    }
};

https://leetcode-cn.com/problems/successor-lcci/solution/zhong-xu-bian-li-de-xia-yi-ge-yuan-su-5da-jie-fa-h/
*
* */
public class Int_04_06 {
    //这是BST树，要利用其特点：
    /**
     所谓 p 的后继节点，就是这串升序数字中，比 p 大的下一个。
     如果 p 大于当前节点的值，说明后继节点一定在 RightTree
     如果 p 等于当前节点的值，说明后继节点一定在 RightTree
     如果 p 小于当前节点的值，说明后继节点一定在 LeftTree 或自己就是
     递归调用 LeftTree，如果是空的，说明当前节点就是答案
     如果不是空的，则说明在 LeftTree 已经找到合适的答案，直接返回即可
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p==null || root == null)return null;

        //当前节点 <= 目标节点  递归到右子节点
        if(p.val >= root.val )return inorderSuccessor(root.right,p);
            // 当前节点 > 目标节点
        else{
            //先递归到左边节点
            TreeNode L = inorderSuccessor(root.left,p);

            return L==null ? root :L ;
        }



    }
}


