/**
The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes. The diagram below shows two trees each with diameter nine, the leaves that form the ends of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).


Solution: The diameter of a tree T is the largest of the following quantities:
The diameter of T's left subtree.
The diameter of T's right subtree.
The longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T).
**/

package org.dreambig.ds.tree;

public class DiameterOfTree{

  public static class Node{

    public Node(int data){
      this.data=data;
    }

    int data;
    Node left;
    Node right;
  }


  private int getHeight(Node root){
    if( root==null) return 0;
    else
    return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }

  public int getDiameter(Node root){

      if(root==null)
      return 0;

      int leftHeight= getHeight(root.left);
      int rightHeight = getHeight(root.right);

      int lTreeDia= getDiameter(root.left);
      int rTreeDia= getDiameter(root.right);

      return Math.max(1+leftHeight+rightHeight, Math.max(lTreeDia,rTreeDia));

    }

    public static void main(String[] args) {
      DiameterOfTree tree= new DiameterOfTree();
      Node root= new Node(1);
      root.left=new Node(2);
      root.right=new Node(3);
      root.right.right=new Node(4);
      root.right.right.right=new Node(5);
      root.right.right.left=new Node(6);
      root.right.right.left.left=new Node(7);
      root.right.right.left.left.right=new Node(8);

      System.out.println("Diameter is "+tree.getDiameter(root));


  }




}
