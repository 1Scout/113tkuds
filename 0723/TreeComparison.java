public class TreeComparison {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static class Result {
        TreeNode node;
        int size;
        Result(TreeNode node, int size) {
            this.node = node;
            this.size = size;
        }
    }

    public static TreeNode largestCommonSubtree(TreeNode root1, TreeNode root2) {
        Result res = new Result(null, 0);
        findLargestCommon(root1, root2, res);
        return res.node;
    }

    private static int findLargestCommon(TreeNode a, TreeNode b, Result res) {
        if (a == null || b == null) return 0;
        if (a.val == b.val) {
            int left = findLargestCommon(a.left, b.left, res);
            int right = findLargestCommon(a.right, b.right, res);
            int total = 1 + left + right;
            if (total > res.size) {
                res.size = total;
                res.node = a; 
            }
            return total;
        } else {
            findLargestCommon(a.left, b, res);
            findLargestCommon(a.right, b, res);
            findLargestCommon(a, b.left, res);
            findLargestCommon(a, b.right, res);
            return 0;
        }
    }

    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(4);
        a.right = new TreeNode(5);
        a.left.left = new TreeNode(1);
        a.left.right = new TreeNode(2);

        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(1);
        b.right = new TreeNode(2);

        TreeNode c = new TreeNode(4);
        c.left = new TreeNode(1);
        c.right = new TreeNode(9);

        System.out.println("1. 是否完全相同:");
        System.out.println("A vs B: " + isSameTree(a, b));
        System.out.println("B vs B: " + isSameTree(b, b));

        System.out.println("\n2. 是否為子樹:");
        System.out.println("B 是否為 A 的子樹: " + isSubtree(a, b));
        System.out.println("C 是否為 A 的子樹: " + isSubtree(a, c));

        System.out.println("\n3. 最大公共子樹:");
        TreeNode largest = largestCommonSubtree(a, c);
        System.out.print("最大公共子樹中序遍歷: ");
        printInorder(largest);
        System.out.println();
    }
}
