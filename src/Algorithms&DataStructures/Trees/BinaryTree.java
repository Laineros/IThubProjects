package Trees;

class Node {
    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;

    // Создание дерева
    private void createTree() {
        root = new Node("A");
        root.left = new Node("B");
        root.right = new Node("C");
        root.left.left = new Node("D");
        root.left.right = new Node("E");
        root.right.left = new Node("F");
        root.right.right = new Node("G");
        root.left.left.left = new Node("H");
        root.left.left.right = new Node("I");
        root.right.left.right = new Node("J");
        root.left.left.right.left = new Node("K");
        root.left.left.right.right = new Node("L");
    }

    // Прямой обход (Pre-order)
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Симметричный обход (In-order)
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    // Обратный обход (Post-order)
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Подсчёт всех узлов в дереве
    public int countNodes(Node node) {
        if (node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Подсчёт узлов в левом поддереве
    public int countLeftSubtree() {
        if (root == null || root.left == null)
            return 0;
        return countNodes(root.left);
    }

    // Подсчёт узлов в правом поддереве
    public int countRightSubtree() {
        if (root == null || root.right == null)
            return 0;
        return countNodes(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createTree();

        System.out.println("Прямой обход (Pre-order):");
        tree.preOrder(tree.root);

        System.out.println("\nСимметричный обход (In-order):");
        tree.inOrder(tree.root);

        System.out.println("\nОбратный обход (Post-order):");
        tree.postOrder(tree.root);

        System.out.println("\n\nОбщее количество узлов: " + tree.countNodes(tree.root));
        System.out.println("Узлов в левом поддереве: " + tree.countLeftSubtree());
        System.out.println("Узлов в правом поддереве: " + tree.countRightSubtree());
    }
}