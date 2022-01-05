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

    public String minWindow(String s, String t) {
        int len = t.length();
        int[] needCnt = new int[128];
        for(int i = 0 ; i< len; i++) {
            needCnt[t.charAt(i)]++;
        }
        int l =0, r= 0, minSize = Integer.MAX_VALUE, needNum = len, startIndex = 0;
        while(r < s.length()) {
            needCnt[s.charAt(r)]--;
            if(needCnt[s.charAt(r)] >= 0) {
                needNum --;
            }
            // 满足条件了
            if(needNum == 0) {
                while(l < r &&needCnt[s.charAt(l)] < 0) {
                    needCnt[s.charAt(l)]++;
                    l++;
                }
                int curLen = r - l + 1;
                if(curLen < minSize) {
                    minSize = curLen;
                    startIndex = l;
                }
                needCnt[s.charAt(l)]++;
                needNum++;
                l++;
            }
            r++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minSize);
    }


}
