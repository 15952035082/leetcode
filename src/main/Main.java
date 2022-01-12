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

    }

    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int index =0 ;
        for(int i = 0 ; i < parts1.length && i < parts2.length; i++) {
            index++;
            long part1 = Long.parseLong(parts1[i]);
            long part2 = Long.parseLong(parts2[i]);
            if(part1 < part2) {
                return -1;
            } else if(part1 > part2) {
                return 1;
            }
        }
        if(parts1.length < parts2.length) {
            for(int i = index; i < parts2.length ; i++) {
                long part = Long.parseLong(parts2[i]);
                if(part != 0) {
                    return -1;
                }
            }
        } else {
            for(int i = index; i < parts1.length ; i++) {
                long part = Long.parseLong(parts1[i]);
                if(part != 0) {
                    return 1;
                }
            }
        }
        return 0;
    }



}
