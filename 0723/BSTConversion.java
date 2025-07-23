public class BSTConversion {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static class DoublyListNode {
        int val;
        DoublyListNode prev, next;
        DoublyListNode(int val) { this.val = val; }
    }

    static DoublyListNode prev = null;
    static DoublyListNode head = null;

    public static DoublyListNode bstToDoublyList(TreeNode root) {
        prev = null;
        head = null;
        inorderToList(root);
        return head;
    }

    private static void inorderToList(TreeNode node) {
        if (node == null) return;
        inorderToList(node.left);
        DoublyListNode curr = new DoublyListNode(node.val);
        if (prev != null) {
            prev.next = curr;
            curr.prev = prev;
        } else {
            head = curr;
        }
        prev = curr;
        inorderToList(node.right);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBalancedBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBalancedBST(nums, left, mid - 1);
        root.right = buildBalancedBST(nums, mid + 1, right);
        return root;
    }

    static int sum = 0;
    public static TreeNode convertToGreaterTree(TreeNode root) {
        sum = 0;
        reverseInorder(root);
        return root;
    }

    private static void reverseInorder(TreeNode node) {
        if (node == null) return;
        reverseInorder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInorder(node.left);
    }

    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void printDoublyList(DoublyListNode node) {
        System.out.print("Doubly Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(10);

        System.out.println("1. BST -> Doubly Linked List");
        DoublyListNode list = bstToDoublyList(root);
        printDoublyList(list);

        System.out.println("\n2. Sorted Array -> Balanced BST");
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode bst = sortedArrayToBST(sortedArr);
        System.out.print("Inorder of Balanced BST: ");
        printInorder(bst);
        System.out.println();

        System.out.println("\n3. BST Node -> Greater Tree Conversion");
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(10);

        convertToGreaterTree(root2);
        System.out.print("Inorder After Conversion: ");
        printInorder(root2);
        System.out.println();
    }
}
