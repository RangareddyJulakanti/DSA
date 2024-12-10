package com.ranga.scaler.dsa.dayTree;

public class BinaryTree {

    public static void main(String[] args) {

        Binary<Integer> _30Node=new Binary<>(30);

        Binary<Integer> _25Node=new Binary<>(25);
        Binary<Integer> _35Node=new Binary<>(35);
        _30Node.setRight(_35Node);
        _30Node.setLeft(_25Node);

        Binary<Integer> _50Node=new Binary<>(50);
        Binary<Integer> _45Node=new Binary<>(55);
        Binary<Integer> _60Node=new Binary<>(60);
        _50Node.setLeft(_45Node);
        _50Node.setRight(_60Node);

        Binary<Integer> rootNode=new Binary<>(40);
        rootNode.setLeft(_30Node);
        rootNode.setRight(_50Node);

        boolean isBinarySearchTree=isValid(rootNode,Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println(isBinarySearchTree);
    }
    private static boolean isValid(Binary<Integer> root,int min,int max){
        if(root==null){
            return true;
        }
        if( !(min<=root.data && root.data<=max) ){
            return false;
        }
        boolean left=isValid(root.left,min,root.data);
        if(left){
            boolean right=isValid(root.right,root.data,max);
            return right;
        }
        return false;
    }

    private static boolean isBinarySearchTree(Binary<Integer> rootNode) {
        if(rootNode==null){
            return true;
        }else{
            Integer rootNodeValue=rootNode.data;
           if(rootNode.left!=null){
                Integer leftNodeVal=rootNode.left.data;
                if(leftNodeVal<rootNodeValue){
                     boolean isTrue=isBinarySearchTree(rootNode.left);
                     if(!isTrue){
                         return false;
                     }
                }else {
                    return false;
                }
            }

           if(rootNode.right!=null){
                Integer rightNodeVal=rootNode.right.data;
                if((rightNodeVal>rootNodeValue)){
                    boolean isTrue=isBinarySearchTree(rootNode.right);
                    return isTrue;
                }
                else {
                    return false;
                }
            }else {
               return true;
            }


        }

    }


    public static  class Binary<T>{
        private Binary<T>  left;
        private Binary<T> right;
        private T data;

        public Binary(T data) {
            this.data = data;
        }
        public Binary(Binary<T> left, Binary<T> right) {
            this.left = left;
            this.right = right;
        }
        public Binary<T> getLeft() {
            return left;
        }
        public void setLeft(Binary<T> left) {
            this.left = left;
        }

        public Binary<T> getRight() {
            return right;
        }

        public void setRight(Binary<T> right) {
            this.right = right;
        }
    }
}
