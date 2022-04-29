package com.binaryTree;

public class BinaryTree implements Tree {

    private Node root;

    private static class Node {
        private Node left;
        private Node right;

        private int value;

        private Node(int value) {
            this.value = value;
        }
    }

    @Override
    public boolean insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            Node parent = null;
            var tmp = root;
            while (tmp != null) {
                if (tmp.value == node.value) {
                    return false;
                }
                parent = tmp;
                tmp = compareValueAndSetNode(node.value, tmp);
            }
            if (node.value > parent.value) {
                parent.right = node;
            } else if (node.value < parent.value) {
                parent.left = node;
            }
        }
        return true;
    }

    @Override
    public boolean delete(int value) {
        Node parent = null;
        var tmp = root;
        while (tmp != null && tmp.value != value) {
            parent = tmp;
            tmp = compareValueAndSetNode(value, tmp);
        }
        if (tmp == null) {
            return false;
        } else {
            //Node does not have any leaves
            if (tmp.right == null && tmp.left == null) {
                compareAndSetRightChild(parent, tmp, null);
                compareAndSetLeftChild(parent, tmp, null);
                if (tmp == root) {
                    root = null;
                }
            }
            //Node does have just one leaf
            if (tmp.right != null && tmp.left == null) {
                compareAndSetRightChild(parent, tmp, tmp.right);
                compareAndSetLeftChild(parent, tmp, tmp.right);
            }
            if (tmp.left != null && tmp.right == null) {
                compareAndSetRightChild(parent, tmp, tmp.left);
                compareAndSetLeftChild(parent, tmp, tmp.left);
            }
            //Node has two leaves
            if (tmp.left != null && tmp.right != null) {
                Node deputyParent = tmp;
                var deputy = tmp.right;
                while (deputy.left != null) {
                    deputyParent = deputy;
                    deputy = deputy.left;
                }
                if (deputyParent.left == deputy) {
                    if (deputy.right != null){
                        deputyParent.left = deputy.right;
                    } else
                    deputyParent.left = null;
                }
                if (deputyParent.right == deputy) {
                    if (deputy.right != null){
                        deputyParent.right = deputy.right;
                    } else
                    deputyParent.right = null;
                }
                tmp.value = deputy.value;
            }
            return true;
        }
    }

    private Node compareValueAndSetNode(int value, Node node) {
        if (value > node.value) {
            node = node.right;
        } else {
            node = node.left;
        }
        return node;
    }

    private void compareAndSetRightChild(Node parent, Node tmp, Node nodeToReplace) {
        if (parent != null && parent.right == tmp) {
            parent.right = nodeToReplace;
        }
    }

    private void compareAndSetLeftChild(Node parent, Node tmp, Node nodeToReplace) {
        if (parent != null && parent.left == tmp) {
            parent.left = nodeToReplace;
        }
    }

    @Override
    public boolean contains(int value) {
        var tmp = root;
        while (tmp != null && tmp.value != value) {
            tmp = compareValueAndSetNode(value, tmp);
        }
        return tmp != null;
    }

    @Override
    public void inorder() {
        inorderPrint(root);
    }

    void inorderPrint(Node node) {
        if (node == null) {
            return;
        }
        inorderPrint(node.left);
        System.out.print(node.value + " ");
        inorderPrint(node.right);
    }
}
