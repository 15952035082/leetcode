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
        int[] a = new int[]{1,2,3,1};
    }

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        for(int i = 0 ; i < nums.length; i++) {
            // 0表示不抢i
            dp[i][0] = i == 0 ? 0 : Math.max(dp[i-1][0], dp[i-1][1]);
            // 1表示要抢
            dp[i][1] = i <= 1 ? nums[i] : Math.max(dp[i-1][0], dp[i-2][1]) + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length -1][1]);
    }


}
