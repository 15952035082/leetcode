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

    int max = 0;
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i< matrix.length; i ++) {
            for(int j = 0 ; j< matrix[0].length ; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else if(dp[i-1][j] != 0 && dp[i][j-1] != 0 && dp[i-1][j-1] != 0) {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }


}
