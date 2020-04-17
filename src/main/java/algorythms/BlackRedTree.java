package main.java.algorythms;

public class BlackRedTree {


}

class Tree {

    TreeNode root;

    static class TreeNode {
        static enum Color { RED, BLACK }
        int key;
        Color color;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int key, TreeNode parent) {
            this.key = key;
            this.color = Color.RED;
            this.parent = parent;
        }
    }

    void insert(int key) {
        if(root == null) {
            root = new TreeNode(key, null);
            root.color = TreeNode.Color.BLACK;
            return;
        }
        insert(root, key);
    }

    void insert(TreeNode node, int key) {
        if (key < node.key) {
            if (node.left == null) {
                node.left = new TreeNode(key, node);
                if(node.color == TreeNode.Color.RED) {

                }
            } else {
                insert(node.left, key);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(key, node);
                if(node.color == TreeNode.Color.RED) {

                }
            } else {
                insert(node.right, key);
            }
        }
    }

    void remove(int key) {

    }
}
