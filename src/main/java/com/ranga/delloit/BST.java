package com.ranga.delloit;
public class BST {
    public static void main(String[] args) {
        Node _2Node=new Node(2,null,null);
        Node _7Node=new Node(7,null,null);
        Node _6Node=new Node(6,_2Node,_7Node);
        Node _1Node=new Node(1,null,null);
        Node _3Node=new Node(3,_1Node,_6Node);
        Node _14Node=new Node(14,null,null);
        Node _10Node=new Node(10,null,_14Node);
        Node root=new Node(8,_3Node,_10Node);
        System.out.println(root);
        boolean isValidBST= isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);//-2147489648 -2147489647
        if(isValidBST){
            System.out.println("Above prepared tree is valid BST");
        }else{
            System.out.println("Above prepared tree is invalid BST");
        }
    }

    private static boolean isValidBST(Node root,int min,int max) {
        //TODO:
         if(root==null){
             return true;
         }
         if(root.data<min || root.data>max){
             return false;
         }

        return  isValidBST(root.left,min,root.data)&& isValidBST(root.right,root.data,max);
    }
}
//HAS A relationship
class Node{
    public int data;
    public Node left;
    public Node right;
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

