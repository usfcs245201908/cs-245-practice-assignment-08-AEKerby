public class BST<T> {

    private class Node {
        public Comparable data;
        public Node left;
        public Node right;

        Node(Comparable newData) {
            this.data = newData;
        }
    }

    private Node root;

    public BST() {
        this.root = null;
    }

    // Return True if Item is Found in the BST
    public boolean find(Comparable item) {
        return find(item, root);
    }

    public boolean find(Comparable target, Node node) {
        if (node == null) {
            return false;
        } else if (target == node.data) {
            return true;
        } else if (target.data < node.data) {
            return find(target, node.left);
        } else {
            return find(target, node.right);
        }
    }

    // Insert Item Into BST, Keeping Duplicates in Their Own Nodes
    public void insert(Comparable item) {
        root = insert(item, root);
    }

    public Node insert(Comparable item, Node node) {
        // Base Case
        if (node == null) {
            return new Node(item);

        } else if (node.data < item.data) {
            node.rigt = insert(item, node.right);
        } else {
            node.left = insert(item, node.left);
            return node;
        }
    }

    // Using Println, Output Each Item in the BST, in Order
    public void print() {
        print(node);
    }

    public void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    // Delete First Instance of Item From the BST, in Order
    public void delete(Comparable item) {
        root = delete(root, item);
    }

    public Node delete(Node node, Comparable item) {
        if (node == null) {
            return null;
        }
        if (node.data == item) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else if (node.right.left == null) {
                node.data = node.right.data;
                node.right = node.right.right;
                return node;
            } else {
                node.data = removeSmallest(node.right);
                return node;
            }
        } else if (item.data < node.data) {
            node.left = delete(node.left, item);
        } else {
            node.right = delete(node.right, item);
        }
        return node;
    }

    public Comparable removeSmallest(Node node) {
        if (node.left.left == null) {
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } else {
            return removeSmallest(node.left);
        }
    }
}
