package org.dreambig.ds.bst.practice.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.List;

public class ExtractLeavesFromBST implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given a Binary Tree, extract all leaves of it in a Doubly Linked List (DLL). Note that the DLL need to be created in-place. Assume that the node structure of DLL and Binary Tree is same, only the meaning of left and right pointers are different. In DLL, left means previous pointer and right means next pointer.  \n" +
                "\n" +
                "Let the following be input binary tree\n" +
                "        1\n" +
                "     /     \\\n" +
                "    2       3\n" +
                "   / \\       \\\n" +
                "  4   5       6\n" +
                " / \\         / \\\n" +
                "7   8       9   10\n" +
                "\n" +
                "\n" +
                "Output:\n" +
                "Doubly Linked List\n" +
                "785910\n" +
                "\n" +
                "Modified Tree:\n" +
                "        1\n" +
                "     /     \\\n" +
                "    2       3\n" +
                "   /         \\\n" +
                "  4           6 "+
                "Find more Details at https://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("Linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }


    public static class Node{
       int data;
       Node left;
       Node right;

       public Node(int data){
         this.data=data;
       }
    }

    private Node root; // root of bst

    private Node head; // head of dll
    private Node prev; // prev  Node of dll


   public Node extractLeaf( Node root){
     // When root is null
     if( root == null)
      return null;

     // When it is leaf
     if(root.left==null && root.right==null){
       // We need to update dll
          if(head==null){
            head=root;
            prev=root;
          }else{
            prev.right=root;
            root.left=prev;
            prev=root;

          }
          return null;

     }else{
       root.left= extractLeaf(root.left); // Move left
       root.right=extractLeaf(root.right); // Move right
       return root;
     }
   }

   public void printDll(){
     Node curr=head;
     while(curr!=null){
       System.out.print( curr.data+" ");
       curr=curr.right;
     }
   }

   public void printInOrder(Node root){
     if(root!=null){
       printInOrder( root.left);
       System.out.print( root.data+" ");
       printInOrder( root.right);
     }
   }

   public static void main(String[] args) {
     Node root= new Node(1);
     root.left=new Node(2);
     root.right=new Node(3);

     root.left.left=new Node(4);
     root.left.right=new Node(5);
     root.right.right=new Node(6);

     root.left.left.left=new Node(7);
     root.left.left.right=new Node(8);

     root.right.right.left=new Node(9);
    root.right.right.right=new Node(10);
    ExtractLeavesFromBST obj = new ExtractLeavesFromBST();

    obj.extractLeaf(root);
    obj.printDll();
    System.out.println("");
    obj.printInOrder(root);


   }




}
