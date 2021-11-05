package org.dreambig.ds.bst.practice.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class InOrderSuccessor implements IQuestion {
    @Override
    public String getQuestion() {
        return "Given a BST, and a reference to a Node x in the BST. Find the Inorder Successor of the given node in the BST.\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input:\n" +
                "      2\n" +
                "    /   \\\n" +
                "   1     3\n" +
                "K(data of x) = 2\n" +
                "Output: 3 \n" +
                "Explanation: \n" +
                "Inorder traversal : 1 2 3 \n" +
                "Hence, inorder successor of 2 is 3.\n" +
                "\n" +
                "Example 2:\n" +
                "\n" +
                "Input:\n" +
                "             20\n" +
                "            /   \\\n" +
                "           8     22\n" +
                "          / \\\n" +
                "         4   12\n" +
                "            /  \\\n" +
                "           10   14\n" +
                "K(data of x) = 8\n" +
                "Output: 10\n" +
                "Explanation:\n" +
                "Inorder traversal: 4 8 10 12 14 20 22\n" +
                "Hence, successor of 8 is 10.\n" +
                "Please find more details at https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

public static class Node {
  Node left,right;
  int data;
  Node (int d){
    this.data=d;
  }
}
public static class RefInt{
 public  int data;
}

  public Node getInorderSuccessor(Node root, int data){
        if(root == null)
            return null;

        Node temp=null;

        while(root!=null){
            // Search right sub tree
            if(root.data<=data){
                root=root.right;
            }else{
                temp= root;
                root=root.left;

            }
        }
        return  temp;

    }

  public static void main(String[] args) {
    InOrderSuccessor obj= new InOrderSuccessor();
    Node root= new Node(20);

    root.left=new Node(8);
    root.right=new Node(22);

    root.left.left=new Node(4);
    root.left.right=new Node(12);

    root.left.right.left=new Node(10);
      root.left.right.right=new Node(14);

      /***
               20
           8       22
         4   12
            10   14

       */
      Node res= obj.getInorderSuccessor(root,20);
      System.out.println(res.data);

  }


}
