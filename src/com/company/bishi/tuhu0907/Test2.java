package com.company.bishi.tuhu0907;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/9/7
 */
public class Test2 {
    public static void main(String[] args) {

    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static int res = 0;

    public int sum(TreeNode root) {
        // write code here
        dfs(root);
        return res;
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val % 2 != 0) {
            dfsdfs(root, 0);
        }
        dfs(root.left);
        dfs(root.right);
    }

    private static void dfsdfs(TreeNode root, int start) {
        if (root == null) return;
        if (start == 2) {
            res += root.val;
            return;
        }
        dfsdfs(root.left, start + 1);
        dfsdfs(root.right, start + 1);
    }
}
