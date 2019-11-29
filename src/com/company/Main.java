package com.company;

public class Main {
    public static void main(String[] args) {

        Tree t = new Tree();

        t.add(40);
        t.add(25);
        t.add(78);
        t.add(10);
        t.add(32);
        t.add(50);
        t.add(93);
        t.add(3);
        t.add(17);
        t.add(30);
        t.add(38);

        System.out.println("Минимальное значение в дереве: "+t.getLow());

        System.out.println("Минимальное значение в дереве: "+t.getHigh());

        System.out.println("Размер дерева - " + t.getSize());

        t.inorder();

        t.preorder();

        t.postorder();

        t.traverseLevelOrder();

        t.search(4);

        t.delete(40);

        t.inorder();

        t.preorder();

        t.postorder();

    }
}