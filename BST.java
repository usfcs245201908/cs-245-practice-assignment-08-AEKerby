class BST implements Practice08Test {

    public BST() {
        Node root = null;
    }

    // Return True if Item is Found in the BST
    boolean find(Comparable item) {
        return find(target, root);
    }

    boolean find(int target, Node node) {
        if (target == node.data) {
            return true;
        }
        if (node.data > target) {
            return find(target, node.left);

        } else {
            return find(target, node.right);
        }
    }

    // Insert Item Into BST, Keeping Duplicates in Their Own Nodes
    void insert(Copmarable item) {
        root = insert(root, item);
    }

    Node insert(Node node, int item) {
        // Base Case
        if (node == null) {
            return new Node(item);

        } else if (node.data < item) {
            node.rigt = insert(node.right, item);
        } else {
            node.left = insert(node.left, item);
            return node;
        }
    }

    // Using Println, Output Each Item in the BST, in Order
    void print(Node node) {
        if (node == null) {
            System.out.println("Tree is Empty!");
        } else {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    // Delete First Instance of Item From the BST, in Order
    void delete(Comparable item) {
        root = delete(root, item);
    }

    Node delete(Node node, int item) {
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
        } else if (item < node.data) {
            node.left = delete(node.left, item);
        } else {
            node.right = delete(node.right, item);
        }
        return node;
    }
}
