package com.company;

import java.util.LinkedList;
import java.util.Queue;

class Tree {
    private Node parent;

    private int data;

    private int size = 0;

    public Tree() {
        parent = new Node(data);
    }

    public void add(int data) {

        if (size == 0) {
            parent.data = data;
            size++;
        } else {
            add(parent, new Node(data));
        }
    }

    private void add(Node root, Node newNode) {

        if (root == null) {
            return;
        }

        if (newNode.data < root.data) {

            if (root.left == null) {
                root.left = newNode;
                size++;
            } else {
                add(root.left, newNode);
            }
        } else {

            if (root.right == null) {
                root.right = newNode;
                size++;
            } else {
                add(root.right, newNode);
            }
        }
    }

    public int getLow() {

        Node current = parent;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    public int getHigh() {

        Node current = parent;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    private void in(Node node) {

        if (node != null) {

            in(node.left);
            System.out.print(node.data + " ");
            in(node.right);
        }
    }

    private void pre(Node node) {

        if (node != null) {

            System.out.print(node.data + " ");
            pre(node.left);
            pre(node.right);
        }
    }

    private void post(Node node) {

        if (node != null) {

            post(node.left);
            post(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void preorder() {

        System.out.print("Прямой обход->");
        pre(parent);
        System.out.println();
    }

    public void postorder() {

        System.out.print("Обратный обход->");
        post(parent);
        System.out.println();
    }

    public void inorder() {

        System.out.print("Центрированый обход->");
        in(parent);
        System.out.println();
    }

    public void delete(int value) {
        parent = deleteRecursive(parent, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.data) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
            //Node to delete found
            //... code to delete the node will go here
        }
        if (value < current.data) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private class Node {

        Node left;

        Node right;

        int data;

        public Node(int data) {
            this.data = data;
        }
    }


    private int findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    public String toString() {

        Node current = parent;
        System.out.print("Traverse From Left ");

        while (current.left != null && current.right != null) {

            System.out.print(current.data + "->[" + current.left.data + " " + current.right.data + "] ");
            current = current.left;
        }

        System.out.println();
        System.out.print("Traverse From Right ");

        current = parent;

        while (current.left != null && current.right != null) {

            System.out.print(current.data + "->[" + current.left.data + " " + current.right.data + "] ");
            current = current.right;
        }

        return "";
    }

    public int getSize() {
        return size;
    }

    public void search(int search) {
        Node current = parent;

        while (current != null) {
            if (search > current.data)
                current = current.right;
            else if (search < current.data)
                current = current.left;
            else if (search == current.data) {
                System.out.println("В дереве есть значение " + search);
                return;
            }
            if (current == null) {
                System.out.println("В дереве нет значения " + search);
            }
        }

    }

    public void traverseLevelOrder() {
        if (parent == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(parent);
        System.out.print("Обход в ширину->");
        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(node.data + " ");

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        System.out.println();
    }
}
