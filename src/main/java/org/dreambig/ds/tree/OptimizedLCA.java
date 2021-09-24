/**
Method 2: The method 1 finds LCA in O(N) time but requires three tree traversals plus extra spaces for path arrays. If we assume that the keys are present in Binary Tree, we can find LCA using single traversal of Binary Tree and without extra storage for path arrays.

The idea is to traverse the tree starting from the root node. If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present). If root doesn't match with any of the keys, we recur for left and right subtrees. The node which has one key present in its left subtree and the other key present in the right subtree is the LCA. If both keys lie in left subtree, then left subtree has LCA also, otherwise, LCA lies in the right subtree.
**/
package org.dreambig.ds.tree;

public class OptimizedLCA{

public static class Node{
  public Node(int data){
    this.data=data;
  }

  int data;
  Node left;
  Node right;
}


public Node getLCA(int d1, int d2, Node root){

  if(root==null)
    return null;

  // 1. if Root has any of these then Root is LCA
  if( root.data==d1 || root.data==d2){
    return root;
  }

  // Now finding LCA in both right and left sub Tree
  // We assume that both values are unique and should be present in any
  // of the sub tree
  Node rightLCA =getLCA(d1,d2,root.right);
  Node leftLCA =getLCA(d1,d2,root.left);

  // Now if both are not null then root is LCA
  if(rightLCA !=null && leftLCA!=null){
    return root;
  }

  // else in any subtree which is not null
  return rightLCA!=null ?rightLCA : leftLCA;
}

 public static void main(String[] args) {
   Node root= new Node(1);
   OptimizedLCA tree = new OptimizedLCA();
   root.left=new Node(3);
   root.right=new Node(2);
   root.left.left=new Node(5);
   root.left.right=new Node(6);
   root.right.left=new Node(7);
   System.out.println(tree.getLCA(5,6, root).data);

  }
}
