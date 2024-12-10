package com.ranga.scaler.dsa;

public class BinarySearchTree {
    public static void main(String[] args) {
        int arr[]={3,4,6,27,9,5,8};
        Node root = null;
        for(int e:arr){
            root=insert(root,e);
        }
        System.out.println(root);
    }
    public static Node insert(Node root,int value){
        if(root==null){
            root= new Node(value);
            return root;
        }
        if(root.data<value){
            root.right=insert(root.right,value);
            //validation
            //rotation
        }else{
            root.left=insert(root.left,value);
            //validation
            //rotation
        }
        return root;
    }
    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}

