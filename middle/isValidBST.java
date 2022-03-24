package middle;

// https://leetcode-cn.com/problems/validate-binary-search-tree/
//98. 验证二叉搜索树
// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。


import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

// 中序遍历递归法
public class isValidBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    long pre = Long.MIN_VALUE;

    boolean inorder(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean l = inorder(node.left);
        if (node.val <= pre) {
            return false;
        }
        pre = node.val;
        boolean r = inorder(node.right);
        return l && r;
    }

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }



 // 中序遍历，利用栈实现
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         Deque<TreeNode> stack = new LinkedList<TreeNode>();
//         double inorder = -Double.MAX_VALUE;
//
//         while (!stack.isEmpty() || root != null) {
//             while (root != null) {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
//             if (root.val <= inorder) {
//                 return false;
//             }
//             inorder = root.val;
//             root = root.right;
//         }
//         return true;
//     }
// }

}
