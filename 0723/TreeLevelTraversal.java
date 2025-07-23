import java.util.*;

public class TreeLevelTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(levelList);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void printLastNodeOfEachLevel(TreeNode root) {
        List<List<Integer>> zigzagLevels = zigzagLevelOrder(root);
        System.out.println("每層最後一個節點如下：");
        for (int i = 0; i < zigzagLevels.size(); i++) {
            List<Integer> level = zigzagLevels.get(i);
            System.out.println("第 " + (i + 1) + " 層最後節點: " + level.get(level.size() - 1));
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("=== 之字形層序遍歷 ===");
        List<List<Integer>> levels = zigzagLevelOrder(root);
        int levelCount = 1;
        for (List<Integer> level : levels) {
            System.out.println("第 " + (levelCount++) + " 層: " + level);
        }

        System.out.println("\n=== 每層最後一個節點 ===");
        printLastNodeOfEachLevel(root);
    }
}
