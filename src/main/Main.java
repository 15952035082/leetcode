package main;

import java.util.*;

public class Main {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        System.out.println();

    }

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i  = 0 ; i< n ; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n -1, 0 , n-1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if(pl > pr) {
            return null;
        }
        int pRoot = pl;
        int iRoot = indexMap.get(preorder[pRoot]);
        TreeNode root = new TreeNode(preorder[pl]);
        int leftSize= iRoot - il;
        root.left = myBuildTree(preorder, inorder, pl + 1, pl + leftSize, il, iRoot -1);
        root.right = myBuildTree(preorder, inorder, pl + leftSize + 1, pr, iRoot + 1, ir);
        return root;
    }


}
