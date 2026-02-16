package Behavioural.Iterator;

import Behavioural.Iterator.bst.BSTIterator;
import Behavioural.Iterator.bst.TreeNode;

public class Main {
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = null;
        int[] vals = {7,3,15,9,20};

        for(int v: vals)
            root = insert(root,v);

        BSTIterator it = new BSTIterator(root);

        System.out.println(it.next()); 
        System.out.println(it.next()); 
        System.out.println(it.next());

        System.out.println(it.prev());
        System.out.println(it.prev());

        System.out.println(it.next());
    }
}
