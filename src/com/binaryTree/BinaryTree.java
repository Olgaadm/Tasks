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
    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        } else {
            Node parent = null;
            var tmp = root;
            while (tmp != null) {
                parent = tmp;
                if (value >= tmp.value) {
                    tmp = tmp.right;
                } else {
                    tmp = tmp.left;
                }
            }
            if (value >= parent.value) {
                parent.right = node;
            } else {
                parent.left = node;
            }
        }
    }

    @Override
    public void delete(int value) {
        assertEmptyTree();
        Node parent = null;
        var tmp = root;
        while (tmp != null && tmp.value != value) {
            parent = tmp;
            if (value >= tmp.value) {
                tmp = tmp.right;
            } else {
                tmp = tmp.left;
            }
        }
        if (tmp != null) {
            //Node does not have any leaves
            if (tmp.right == null && tmp.left == null) {
                if (parent != null && parent.right == tmp) {
                    parent.right = null;
                }
                if (parent != null && parent.left == tmp) {
                    parent.left = null;
                }
                if (tmp == root) {
                    root = null;
                }
            }
            //Node does have just one leaf
            if (tmp.right != null && tmp.left == null) {
                if (parent != null && parent.right == tmp) {
                    parent.right = tmp.right;
                }
                if (parent != null && parent.left == tmp) {
                    parent.left = tmp.right;
                }
            }
            if (tmp.left != null && tmp.right == null) {
                if (parent != null && parent.right == tmp) {
                    parent.right = tmp.left;
                }
                if (parent != null && parent.left == tmp) {
                    parent.left = tmp.left;
                }
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
                    deputyParent.left = null;
                }
                if (deputyParent.right == deputy) {
                    deputyParent.right = null;
                }
                tmp.value = deputy.value;
            }
        }
    }

    @Override
    public boolean contains(int value) {
        assertEmptyTree();
        var tmp = root;
        while (tmp != null && tmp.value != value) {
            if (tmp.value < value) {
                tmp = tmp.right;
            } else {
                tmp = tmp.left;
            }
        }
        return tmp != null;
    }

    void inorderPrint(Node node) {
        if (node == null) {
            return;
        }
        inorderPrint(node.left);
        System.out.print(node.value + " ");
        inorderPrint(node.right);
    }

    public void inorder() {
        assertEmptyTree();
        inorderPrint(root);
    }

    private void assertEmptyTree() {
        if (root == null) {
            throw new NullPointerException("There are no items in tree yet");
        }
    }

}
