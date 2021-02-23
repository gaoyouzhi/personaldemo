package com.haochang.data;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {

    private int data;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinarySearchTree(int data, BinarySearchTree left, BinarySearchTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void insert(BinarySearchTree root, int data){

        if(root.data < data){
            if(root.right == null){
                root.right = new BinarySearchTree(data);
            } else {
                insert(root.right, data);
            }
        } else {
            if(root.left == null){
                root.left = new BinarySearchTree(data);
            } else {
                insert(root.left, data);
            }
        }
    }

    public void in(BinarySearchTree root){
        if(null != root){
            in(root.left);
            System.out.println(root.data);
            in(root.right);
        }
    }

    public int select(BinarySearchTree root, int data, int i){
        if(null == root){
            return -1;
        }

        if(root.data == data){
            return i++;
        }
        if(root.left != null){
            select(root.left, data, i++);
        }

        if(root.right != null){
            select(root.right, data, i++);
        }

        return i;
    }
    public static void main(String[] args) {
        int data[] = {12, 1, 3, 5, 15};
        BinarySearchTree root = new BinarySearchTree(data[0]);
        for (int i = 1; i < data.length; i++){
            root.insert(root, data[i]);
        }
        System.out.println("中序遍历：");
        root.in(root);
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTree getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree left) {
        this.left = left;
    }

    public BinarySearchTree getRight() {
        return right;
    }

    public void setRight(BinarySearchTree right) {
        this.right = right;
    }
}
