import java.util.*;

public class TreeDistance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int distance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q);
        return depthFrom(lca, p, 0) + depthFrom(lca, q, 0);
    }

    private static TreeNode findLCA(TreeNode node, int p, int q) {
        if (node == null) return null;
        if (node.val == p || node.val == q) return node;
        TreeNode left = findLCA(node.left, p, q);
        TreeNode right = findLCA(node.right, p, q);
        if (left != null && right != null) return node;
        return left != null ? left : right;
    }

    private static int depthFrom(TreeNode node, int target, int depth) {
        if (node == null) return -1;
        if (node.val == target) return depth;
        int left = depthFrom(node.left, target, depth + 1);
        if (left != -1) return left;
        return depthFrom(node.right, target, depth + 1);
    }

    static int maxDiameter = 0;

    public static int treeDiameter(TreeNode root) {
        maxDiameter = 0;
        diameterHelper(root);
        return maxDiameter;
    }

    private static int diameterHelper(TreeNode node) {
        if (node == null) return 0;
        int left = diameterHelper(node.left);
        int right = diameterHelper(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static List<Integer> nodesAtDistanceK(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        findKDistance(root, k, result);
        return result;
    }

    private static void findKDistance(TreeNode node, int k, List<Integer> result) {
        if (node == null) return;
        if (k == 0) {
            result.add(node.val);
        } else {
            findKDistance(node.left, k - 1, result);
            findKDistance(node.right, k - 1, result);
        }
    }

    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println("中序遍歷:");
        printInorder(root);
        System.out.println();

        System.out.println("\n1. 節點 4 和 5 之間的距離: " + distance(root, 4, 5));
        System.out.println("   節點 4 和 6 之間的距離: " + distance(root, 4, 6));

        System.out.println("\n2. 樹的直徑為: " + treeDiameter(root));

        int k = 2;
        List<Integer> kDistanceNodes = nodesAtDistanceK(root, k);
        System.out.println("\n3. 距離根節點距離為 " + k + " 的節點: " + kDistanceNodes);
    }
}
