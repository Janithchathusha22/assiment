import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SecondLargestInTree {

  
    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // Traverse the tree and collect all values in a set
    public static void traverseTree(TreeNode node, Set<Integer> values) {
        if (node != null) {
            values.add(node.value);
            traverseTree(node.left, values);
            traverseTree(node.right, values);
        }
    }

    // Find the second largest element in the tree
    public static int findSecondLargestInTree(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty.");
        }

        Set<Integer> values = new HashSet<>();
        traverseTree(root, values);

        if (values.size() < 2) {
            throw new IllegalArgumentException("Not enough distinct elements in the tree.");
        }

        // Convert set to an array and sort it
        Object[] uniqueValues = values.toArray();
        Arrays.sort(uniqueValues);

        
        return (int) uniqueValues[uniqueValues.length - 2];
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(17);

        
        System.out.println("Second largest number in the tree is: " + findSecondLargestInTree(root));
    }
}
