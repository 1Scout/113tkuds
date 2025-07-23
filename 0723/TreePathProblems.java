import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> getAllRootToLeafPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfsAllPaths(root, new ArrayList<>(), result);
        return result;
    }

    private static void dfsAllPaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            dfsAllPaths(node.left, path, result);
            dfsAllPaths(node.right, path, result);
        }

        path.remove(path.size() - 1); 
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }

    public static List<Integer> getMaxPathSum(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        dfsMaxPath(root, 0, new ArrayList<>(), new int[]{Integer.MIN_VALUE}, maxPath);
        return maxPath;
    }

    private static void dfsMaxPath(TreeNode node, int currentSum, List<Integer> path, int[] maxSum, List<Integer> maxPath) {
        if (node == null) return;

        currentSum += node.val;
        path.add(node.val);

        if (node.left == null && node.right == null) {
            if (currentSum > maxSum[0]) {
                maxSum[0] = currentSum;
                maxPath.clear();
                maxPath.addAll(path);
            }
        } else {
            dfsMaxPath(node.left, currentSum, path, maxSum, maxPath);
            dfsMaxPath(node.right, currentSum, path, maxSum, maxPath);
        }

        path.remove(path.size() - 1); 
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println("=== 所有根到葉節點的路徑 ===");
        List<List<Integer>> allPaths = getAllRootToLeafPaths(root);
        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }

        int target = 22;
        System.out.println("\n是否存在總和為 " + target + " 的路徑: " + hasPathSum(root, target));

        System.out.println("\n=== 總和最大的根到葉路徑 ===");
        List<Integer> maxPath = getMaxPathSum(root);
        int maxSum = maxPath.stream().mapToInt(i -> i).sum();
        System.out.println("最大路徑: " + maxPath);
        System.out.println("總和: " + maxSum);
    }
}
