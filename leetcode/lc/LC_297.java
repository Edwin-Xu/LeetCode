package leetcode.lc;

import leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * @author Edwin Xu
 * @date 6/30/2021 12:58 PM.
 * <p>
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 */

public class LC_297 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);

        int depth = getDepth(root);

        int layer = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            layer++;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.removeFirst();
                if (tmp == null) {
                    q.addLast(null);
                    q.addLast(null);
                    sb.append("null,");
                } else {
                    q.addLast(tmp.left);
                    q.addLast(tmp.right);
                    sb.append(tmp.val);
                    sb.append(",");
                }
            }
            if (layer == depth) {
                break;
            }
        }

        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }

        String[] nodes = data.split(",");
        if (nodes.length == 0) {
            return null;
        }

        nodes[0] = nodes[0].substring(1);
        nodes[nodes.length - 1] = nodes[nodes.length - 1].substring(0, nodes[nodes.length - 1].length() - 1);


        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            treeNodes[i] = "null".equals(nodes[i]) ? null : new TreeNode(Integer.parseInt(nodes[i]));
        }
        // i的子节点： 2i+1 2i+2
        for (int i = 0; i < nodes.length; i++) {
            if (treeNodes[i] == null) continue;
            if (2 * i + 1 < nodes.length)
                treeNodes[i].left = treeNodes[2 * i + 1];
            if (2 * i + 2 < nodes.length)
                treeNodes[i].right = treeNodes[2 * i + 2];
        }
        return treeNodes[0];
    }


    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
