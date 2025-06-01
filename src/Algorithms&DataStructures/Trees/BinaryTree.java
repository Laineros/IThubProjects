package Trees;

class TreeNode {
    String value;
    TreeNode left;
    TreeNode right;

    public TreeNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    // Создание дерева
    private void createTree() {
        root = new TreeNode("A");
        root.left = new TreeNode("B");
        root.right = new TreeNode("C");
        root.left.left = new TreeNode("D");
        root.left.right = new TreeNode("E");
        root.right.left = new TreeNode("F");
        root.right.right = new TreeNode("G");
        root.left.left.left = new TreeNode("H");
        root.left.left.right = new TreeNode("I");
        root.right.left.right = new TreeNode("J");
        root.left.left.right.left = new TreeNode("K");
        root.left.left.right.right = new TreeNode("L");
    }

    // Прямой обход (Pre-order)
    public void preOrder(TreeNode TreeNode) {
        if (TreeNode != null) {
            System.out.print(TreeNode.value + " ");
            preOrder(TreeNode.left);
            preOrder(TreeNode.right);
        }
    }

    // Симметричный обход (In-order)
    public void inOrder(TreeNode TreeNode) {
        if (TreeNode != null) {
            inOrder(TreeNode.left);
            System.out.print(TreeNode.value + " ");
            inOrder(TreeNode.right);
        }
    }

    // Обратный обход (Post-order)
    public void postOrder(TreeNode TreeNode) {
        if (TreeNode != null) {
            postOrder(TreeNode.left);
            postOrder(TreeNode.right);
            System.out.print(TreeNode.value + " ");
        }
    }

    // Подсчёт всех узлов в дереве
    public int countNodes(TreeNode TreeNode) {
        if (TreeNode == null)
            return 0;
        return 1 + countNodes(TreeNode.left) + countNodes(TreeNode.right);
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