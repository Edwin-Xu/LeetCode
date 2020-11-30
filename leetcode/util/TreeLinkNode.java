package leetcode.util;

/**
 * Created by Edwin Xu on 6/22/2020 7:29 PM
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null; //指向父节点
    public TreeLinkNode(int val)
    { this.val = val;
    }
}
