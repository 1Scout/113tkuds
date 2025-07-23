public class BSTKthElement {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class KthSmallestFinder {
        private int count = 0; 
        private int result = -1; 

        public int kthSmallest(TreeNode root, int k) {
            inOrder(root, k);
            return result;
        }

        private void inOrder(TreeNode node, int k) {
            if (node == null) return;

            inOrder(node.left, k);

            count++;
            if (count == k) {
                result = node.val;
                return;
            }

            inOrder(node.right, k);
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        KthSmallestFinder finder = new KthSmallestFinder();

        for (int k = 1; k <= 7; k++) {
            int kth = finder.kthSmallest(root, k);
            System.out.println("第 " + k + " 小的元素為: " + kth);
            finder = new KthSmallestFinder(); 
        }
    }
}
