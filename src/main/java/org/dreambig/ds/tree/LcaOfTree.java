
/**
Given a Binary Tree and the value of two nodes n1 and n2. The task is to find the lowest common ancestor of the nodes n1 and n2 in the given Binary Tree.

The LCA or Lowest Common Ancestor of any two nodes N1 and N2 is defined as the common ancestor of both the nodes which is closest to them. That is the distance of the common ancestor from the nodes N1 and N2 should be least possible.
**/

package org.dreambig.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class LcaOfTree {

public static class Node {

public Node (int data){
  this.data=data;
}

  int data;
  Node right;
  Node left;
}


private boolean findPath(List<Integer> path, Node root, final int data){
  if(root ==null)
    return  false;


  if(root.left!=null && findPath(path,root.left,data) || (root.right!=null && findPath(path,root.right,data))){
  path.add(root.data);
  return true;
  }


 if (root.data==data){
    path.add(data);
    return true;
  }

  return false;

}


public int getLCA ( int data1, int data2, Node root){

  List<Integer> p1= new ArrayList<>();
  List<Integer> p2= new ArrayList<>();

  boolean r1=findPath(p1, root, data1);
  boolean r2=findPath(p2, root, data2);

  if(!r1||!r2 )
    return -1;

  int ptr1= p1.size()-1;
  int ptr2= p2.size()-1;
  int res=-1;

  while(ptr1>=0 &&ptr2>=0) // Iterating in reverse order   and stop when match found
  {
    if(p1.get(ptr1)!= p2.get(ptr2))
      return res;
    else{
        res = p1.get(ptr1);
        ptr1--;
        ptr2--;
      }
  }
  return res;

}


public Node getLCAoptimized(Node root, int d1, int d2){

  if(root==null)
    return  root;

  if( root.data==d1|| root.data==d2){ // if any of data is in root then that is LCA
    return root;
  }

  Node lTree= getLCAoptimized(root.left,d1,d2); // searching left and right sub tree
  Node rTree= getLCAoptimized(root.right,d1,d2);

  if(lTree!=null && rTree!=null){
    return root;
  }

  return lTree== null ? rTree : lTree;

}

 public static void main(String[] args) {
   /**
    *     1
    *   2   3
    * 4  5    6
    */

   LcaOfTree t= new LcaOfTree();
   Node root= new Node(1);

   Node l1= new Node(2);
   root.left=l1;
   Node r1= new Node(3);
   root.right=r1;

   Node rr2= new Node(6);
   r1.right=rr2;
   Node ll2= new Node(4);
   l1.left=ll2;

   Node lr2= new Node(5);
   l1.right=lr2;
   System.out.println(t.getLCA(4,6,root));

   Node node= t.getLCAoptimized(root,4,5);
   System.out.println("==>"+node.data);


}



}
