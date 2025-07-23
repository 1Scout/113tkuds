public class BSTBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private static int checkBalance(TreeNode node) {
        if (node == null) return 0;
        int left = checkBalance(node.left);
        int right = checkBalance(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static class MaxImbalance {
        TreeNode node;
        int balance; 
    }

    public static TreeNode findMostUnbalanced(TreeNode root) {
        MaxImbalance max = new MaxImbalance();
        max.balance = -1;
        findUnbalanced(root, max);
        return max.node;
    }

    private static void findUnbalanced(TreeNode node, MaxImbalance max) {
        if (node == null) return;
        int bf = getBalanceFactor(node);
        if (Math.abs(bf) > max.balance) {
            max.balance = Math.abs(bf);
            max.node = node;
        }
        findUnbalanced(node.left, max);
        findUnbalanced(node.right, max);
    }

    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(20);
        root.right.right.right = new TreeNode(25);

        System.out.println("中序遍歷:");
        printInorder(root);

        System.out.println("\n\n1. 是否為平衡樹: " + isBalanced(root));
        System.out.println("2. 根節點的平衡因子: " + getBalanceFactor(root));

        TreeNode unbalanced = findMostUnbalanced(root);
        System.out.println("3. 最不平衡的節點值: " + unbalanced.val);
        System.out.println("   其平衡因子: " + getBalanceFactor(unbalanced));
    }
}
