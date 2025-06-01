package Trees;
class BTreeNode {
    int value;
    BTreeNode left;
    BTreeNode right;

    public BTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class BinarySearchingTree extends BinaryTree {
    private BTreeNode root;

    public BinarySearchingTree() {
        root = null;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return root == null;
    }

    // Вставка элемента
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private BTreeNode insertRec(BTreeNode root, int value) {
        if (root == null) {
            root = new BTreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Поиск элемента
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(BTreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.value == key) {
            return true;
        }

        return key < root.value ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Удаление элемента
    public void remove(int key) {
        root = removeRec(root, key);
    }

    private BTreeNode removeRec(BTreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = removeRec(root.left, key);
        } else if (key > root.value) {
            root.right = removeRec(root.right, key);
        } else {
            // Узел с одним или без детей
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Узел с двумя детьми: получаем преемника inorder (наименьший в правом поддереве)
            root.value = findMin(root.right).value;

            // Удаляем преемника inorder
            root.right = removeRec(root.right, root.value);
        }

        return root;
    }

    // Поиск минимального элемента
    public BTreeNode findMin() {
        return findMin(root);
    }

    private BTreeNode findMin(BTreeNode BTreeNode) {
        BTreeNode current = BTreeNode;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Поиск максимального элемента
    public BTreeNode findMax() {
        return findMax(root);
    }

    private BTreeNode findMax(BTreeNode BTreeNode) {
        BTreeNode current = BTreeNode;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return current;
    }

    // Вычисление высоты дерева
    public int height() {
        return heightRec(root);
    }

    private int heightRec(BTreeNode BTreeNode) {
        if (BTreeNode == null) {
            return -1;
        }
        return 1 + Math.max(heightRec(BTreeNode.left), heightRec(BTreeNode.right));
    }

    // Обходы дерева
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(BTreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(BTreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(BTreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    // Пример использования
    public static void main(String[] args) {
        BinarySearchingTree tree = new BinarySearchingTree();

        System.out.println("Дерево пустое? " + tree.isEmpty());

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder обход:");
        tree.inorder();

        System.out.println("Preorder обход:");
        tree.preorder();

        System.out.println("Postorder обход:");
        tree.postorder();

        System.out.println("Минимальный элемент: " + tree.findMin().value);
        System.out.println("Максимальный элемент: " + tree.findMax().value);
        System.out.println("Высота дерева: " + tree.height());

        System.out.println("Поиск 40: " + tree.search(40));
        System.out.println("Поиск 100: " + tree.search(100));

        System.out.println("Удаляем 20");
        tree.remove(20);
        tree.inorder();

        System.out.println("Удаляем 30");
        tree.remove(30);
        tree.inorder();

        System.out.println("Удаляем 50");
        tree.remove(50);
        tree.inorder();

        System.out.println("Дерево пустое? " + tree.isEmpty());
    }
}
