package com.example.algorithm.link;

public class Node {

    public int value;
    public Node next;

    public Node() {
        value = -1;
        next = null;
    }

    public Node(int value) {
        this.value = value;
        next = null;
    }

    public void add(Node head, Node add) {
        if (head == null || add == null) {
            return;
        }

        Node p = head;
        while (p.next != null) {
            p = p.next;
        }

        p.next = add;
    }

    public Node reverse() {
        Node p1 = this;
        Node p2 = p1.next;
        Node p3 = p2.next;
        p1.next = null;

        while (p3 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }

        p2.next = p1;

        return p2;
    }

    public void print(Node head) {
        Node p = head;
        if (p == null) {
            System.out.println("NodeList is null");
            return;
        }

        StringBuilder builder = new StringBuilder();

        while (p != null) {
            if (builder.length() > 0) {
                builder.append("->");
            }
            builder.append(p.value);
            p = p.next;
        }

        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        Node head = new Node(0);

        for (int i = 1; i < 10; i++) {
            head.add(head, new Node(i));
        }

        System.out.print("before reverse: ");
        head.print(head);

        System.out.print("after  reverse: ");
        head.print(head.reverse());
    }
}
