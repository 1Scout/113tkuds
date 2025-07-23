import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1,
                          inorder, 0, inorder.length - 1, inorderIndex);
    }

    private static TreeNode buildPreIn(int[] pre, int preStart, int preEnd,
                                       int[] in, int inStart, int inEnd,
                                       Map<Integer, Integer> inorderIndex) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inorderIndex.get(rootVal);
        int leftSize = inRoot - inStart;

        root.left = buildPreIn(pre, preStart + 1, preStart + leftSize,
                               in, inStart, inRoot - 1, inorderIndex);
        root.right = buildPreIn(pre, preStart + leftSize + 1, preEnd,
                                in, inRoot + 1, inEnd, inorderIndex);

        return root;
    }

    public static TreeNode buildTreePostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length - 1,
                           inorder, 0, inorder.length - 1, inorderIndex);
    }

    private static TreeNode buildPostIn(int[] post, int postStart, int postEnd,
                                        int[] in, int inStart, int inEnd,
                                        Map<Integer, Integer> inorderIndex) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = post[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inorderIndex.get(rootVal);
        int leftSize = inRoot - inStart;

        root.left = buildPostIn(post, postStart, postStart + leftSize - 1,
                                in, inStart, inRoot - 1, inorderIndex);
        root.right = buildPostIn(post, postStart + leftSize, postEnd - 1,
                                 in, inRoot + 1, inEnd, inorderIndex);

        return root;
    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        System.out.print("Level-order: ");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        System.out.println("=== 前序 + 中序 建構 ===");
        TreeNode root1 = buildTreePreIn(preorder, inorder);
        System.out.print("中序: ");
        printInorder(root1);
        System.out.println();
        printLevelOrder(root1);

        System.out.println("\n=== 後序 + 中序 建構 ===");
        TreeNode root2 = buildTreePostIn(postorder, inorder);
        System.out.print("中序: ");
        printInorder(root2);
        System.out.println();
        printLevelOrder(root2);
    }
}
