import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private static boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return isValidBSTHelper(node.left, min, node.val) &&
               isValidBSTHelper(node.right, node.val, max);
    }

    public static List<TreeNode> findInvalidNodes(TreeNode root) {
        List<TreeNode> invalidNodes = new ArrayList<>();
        findInvalidNodesHelper(root, null, null, invalidNodes);
        return invalidNodes;
    }

    private static void findInvalidNodesHelper(TreeNode node, Integer min, Integer max, List<TreeNode> result) {
        if (node == null) return;

        boolean isValid = true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            isValid = false;
            result.add(node);
        }

        findInvalidNodesHelper(node.left, min, isValid ? node.val : max, result);
        findInvalidNodesHelper(node.right, isValid ? node.val : min, max, result);
    }

    public static int minNodesToRemove(TreeNode root) {
        return countToRemove(root, null, null).removalCount;
    }

    static class Result {
        int removalCount;
        boolean isValid;
        Result(int removalCount, boolean isValid) {
            this.removalCount = removalCount;
            this.isValid = isValid;
        }
    }

    private static Result countToRemove(TreeNode node, Integer min, Integer max) {
        if (node == null) return new Result(0, true);

        boolean valid = (min == null || node.val > min) && (max == null || node.val < max);

        Result left = countToRemove(node.left, min, node.val);
        Result right = countToRemove(node.right, node.val, max);

        if (valid && left.isValid && right.isValid) {
            return new Result(left.removalCount + right.removalCount, true);
        } else {
            return new Result(1 + left.removalCount + right.removalCount, false);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        System.out.println("=== BST 驗證與修復 ===");

        System.out.println("是否為合法 BST: " + isValidBST(root));

        List<TreeNode> invalidNodes = findInvalidNodes(root);
        System.out.print("不合法節點值: ");
        for (TreeNode node : invalidNodes) {
            System.out.print(node.val + " ");
        }
        System.out.println();

        System.out.println("最少需移除節點數量: " + minNodesToRemove(root));
    }
}
