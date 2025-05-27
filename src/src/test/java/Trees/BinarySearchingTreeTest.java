package Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchingTreeTest {
    @Test
    public void testExample1() {
        BinarySearchingTree solution = new BinarySearchingTree();
        // Tree structure: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(3, solution.maxDepth(root));
    }
}
