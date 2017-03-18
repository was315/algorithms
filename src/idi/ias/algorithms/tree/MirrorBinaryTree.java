package idi.ias.algorithms.tree;

import java.util.LinkedList;

/**
 * Created by IAS on 2017/3/18.
 */
public class MirrorBinaryTree {


    public void mirror(Node root){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }
    public void traverse(Node root){
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);
        while (list.size() != 0){
            Node temp = list.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null){
                list.add(temp.left);
            }
            if (temp.right != null){
                list.add(temp.right);
            }

        }
        System.out.println();

    }
    public void reverse(Node root){
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);
        while (list.size() != 0){
            Node first = list.remove();
            if (first.left != null || first.right != null){
                Node temp = first.left;
                first.left = first.right;
                first.right = temp;
            }
            if (first.left != null){
                list.add(first.left);
            }
            if (first.right != null){
                list.add(first.right);
            }

        }
    }

    public static void main(String[] args){
        Node bt = new Node(8);
        bt.left = new Node(6);
        bt.right = new Node(10);
        bt.left.left = new Node(5);
        bt.left.right = new Node(7);
        bt.right.left = new Node(9);
        bt.right.right = new Node(11);
        MirrorBinaryTree a = new MirrorBinaryTree();
        a.traverse(bt);
        a.reverse(bt);
        a.traverse(bt);
    }
}
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}

