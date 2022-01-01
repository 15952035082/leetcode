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


    class TempNode implements Comparable<TempNode>{

        int val;
        ListNode node;

        TempNode(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }


        @Override
        public int compareTo(TempNode o) {
            return val - o.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<TempNode> que = new PriorityQueue<TempNode>();
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for(ListNode node : lists) {
            if(node != null) {
                que.add(new TempNode(node.val, node));
            }
        }
        while(!que.isEmpty()) {
            TempNode curHead = que.poll();
            tail.next = curHead.node;
            tail = tail.next;
            if(curHead.node.next != null) {
                que.add(new TempNode(curHead.node.next.val, curHead.node.next));
            }
        }
        return head.next;
    }




}
