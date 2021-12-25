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

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        boolean isEven = true;
        boolean res = true;
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            int pre = 0 ;
            for(int i = 0 ;i < size ; i ++) {
                TreeNode cur = nodes.poll();
                if(pre != 0) {
                    if(isEven && ( cur.val%2 == 0 ||  cur.val <= pre)) {
                        res = false;
                        break;
                    } else if(!isEven && ( cur.val%2 == 1 ||  cur.val >= pre)) {
                        res = false;
                        break;
                    }
                } else {
                    if(isEven && cur.val%2 == 0 || (!isEven && cur.val%2 == 1)) {
                        res = false;
                        break;
                    }
                }
                if(cur.left != null) {
                    nodes.add(cur.left);
                }
                if(cur.right != null) {
                    nodes.add(cur.right);
                }
                pre = cur.val;
            }
            isEven = !isEven;
        }
        return res;
    }


}
