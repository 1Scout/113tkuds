class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class inOrder {
    
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;  // 基礎情況：空節點
        }
        
        // 左 -> 根 -> 右
        inOrder(root.left);         
        System.out.print(root.data + " ");  
        inOrder(root.right);         
    }
    // 計算樹的高度
    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    // 計算節點總數
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    // 搜尋特定值
    public static boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.data == target) {
            return true;
        }
        return search(root.left, target) || search(root.right, target);
    }
     public static void main(String[] args) {
        // 建立測試樹:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.left.left.left.left = new TreeNode(8);
        root.left.left.left.right = new TreeNode(9);
        
        System.out.print("前序走訪: ");
        inOrder(root);
        System.out.println();
        
    }
}

