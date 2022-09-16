package com.company.middium;


import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

/**
 * title: 897. 递增顺序搜索树
 *
 * @author: Miles
 * @date: 2022/9/9
 */
public class Test897 {

     private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.left.left.left = new TreeNode(1);
//        root.right.right = new TreeNode(8);
//        root.right.right.left = new TreeNode(7);
//        root.right.right.right = new TreeNode(9);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        System.out.println(increasingBST(root));
    }

    public static TreeNode increasingBST(TreeNode root) {
        dfs(root);
        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;
        for (TreeNode node : res) {
            cur.right = node;
            node.left = null;
            cur = node;
        }
        return dummy.right;
    }

    static LinkedList<TreeNode> res = new LinkedList<>();

    // 中序遍历
    private static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root);
        dfs(root.right);
    }
}
