package com.haochang.data;

/**
 * 二叉树测试
 */
public class TreeTest {

    public static void main(String[] args) {
        Node D = new Node(null, null, 'D');
        Node H = new Node(null, null, 'H');
        Node K = new Node(null, null, 'K');
        Node C = new Node(D, null, 'C');
        Node B = new Node(null, C, 'B');
        Node G = new Node(H, K, 'G');
        Node F = new Node(G, null, 'F');
        Node E = new Node(null, F, 'E');
        Node A = new Node(B, E, 'A');
        BinaryTree binaryTree = new BinaryTree();
        System.out.print("前:");
        binaryTree.pre(A);
        System.out.println();
        System.out.print("中:");
        binaryTree.in(A);
        System.out.println();
        System.out.print("后:");
        binaryTree.post(A);
    }
}
