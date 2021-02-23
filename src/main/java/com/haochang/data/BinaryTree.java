package com.haochang.data;

/**
 * 二叉树
 */
public class BinaryTree {

    private Node root;

    public void printNode(Node node){
        System.out.print(node.getValue());
    }

    public void pre(Node root){
        printNode(root);

        if(null != root.left){
            pre(root.left);
        }

        if(null != root.right){
            pre(root.right);
        }
    }

    /**
     * 中序
     * @param root
     */
    public void in(Node root){

        if(null != root.left){
            in(root.left);
        }

        printNode(root);

        if(null != root.right){
            in(root.right);
        }
    }

    public void post(Node root){
        if(null != root.left){
            post(root.left);
        }
        if(null != root.right){
            post(root.right);
        }
        printNode(root);
    }
}

class Node{
    Node left;
    Node right;
    char value;

    public Node(Node left, Node right, char value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
