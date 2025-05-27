package Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchingTreeTest {
    @Test
    public void testExample1() {
        BinarySearchingTree solution = new BinarySearchingTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(3, solution.maxDepth(root));
    }
    @Test
    public void testSearchFound() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = new BinarySearchingTree().search(root, 2);
        assertNotNull(result);
        assertEquals(2, result.value);
    }
    @Test
    public void testSearchNotFound() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = new BinarySearchingTree().search(root, 5);
        assertNull(result);
    }
}
