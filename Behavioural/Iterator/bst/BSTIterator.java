package Behavioural.Iterator.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private List<Integer> history = new ArrayList<>();
    private int pointer = -1;

    public BSTIterator(TreeNode root){
        pushLeft(root);
    }

    private void pushLeft(TreeNode node){
        while (node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public Boolean hasNext(){
        return pointer + 1 < history.size() | !stack.empty();
    }

    public int next() {
        pointer++;

        if (pointer < history.size()) {
            return history.get(pointer);
        }

        TreeNode node = stack.pop();

        if (node.right != null) pushLeft(node.right);

        history.add(node.val);

        return node.val;
    }

    public boolean hasPrev() {
        return pointer > 0;
    }

    public int prev() {
        pointer--;
        return history.get(pointer);
    }
}
