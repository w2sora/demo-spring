package com.designPatterns._16Composite;

public class TreeTest {
    private TreeNode root = null;

    private TreeTest(String name) {
        root = new TreeNode(name);
    }

    public static void main(String[] args) {
        TreeTest tree = new TreeTest("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finished!");
    }
}
