public class TreeStatistics {
    
    // 節點類別
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    private TreeNode root;
    
    // 建構函式
    public TreeStatistics() {
        this.root = null;
    }
    
    public TreeStatistics(TreeNode root) {
        this.root = root;
    }
    
    // 設置根節點
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    // 插入節點（簡單的二元搜尋樹插入）
    public void insert(int val) {
        root = insertRec(root, val);
    }
    
    private TreeNode insertRec(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        
        if (val < node.val) {
            node.left = insertRec(node.left, val);
        } else if (val > node.val) {
            node.right = insertRec(node.right, val);
        }
        
        return node;
    }
    
    // 1. 計算樹中所有節點值的總和
    public int sum() {
        return sumRec(root);
    }
    
    private int sumRec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sumRec(node.left) + sumRec(node.right);
    }
    
    // 2. 找出樹中的最大值
    public int findMax() {
        if (root == null) {
            throw new RuntimeException("樹為空，無法找到最大值");
        }
        return findMaxRec(root);
    }
    
    private int findMaxRec(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        
        int maxVal = node.val;
        int leftMax = findMaxRec(node.left);
        int rightMax = findMaxRec(node.right);
        
        return Math.max(maxVal, Math.max(leftMax, rightMax));
    }
    
    // 3. 找出樹中的最小值
    public int findMin() {
        if (root == null) {
            throw new RuntimeException("樹為空，無法找到最小值");
        }
        return findMinRec(root);
    }
    
    private int findMinRec(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        
        int minVal = node.val;
        int leftMin = findMinRec(node.left);
        int rightMin = findMinRec(node.right);
        
        return Math.min(minVal, Math.min(leftMin, rightMin));
    }
    
    // 4. 計算所有葉節點的數量
    public int countLeaves() {
        return countLeavesRec(root);
    }
    
    private int countLeavesRec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // 如果是葉節點（沒有左右子樹）
        if (node.left == null && node.right == null) {
            return 1;
        }
        
        // 遞歸計算左右子樹的葉節點
        return countLeavesRec(node.left) + countLeavesRec(node.right);
    }
    
    // 5. 計算樹的深度（高度）
    public int depth() {
        return depthRec(root);
    }
    
    private int depthRec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftDepth = depthRec(node.left);
        int rightDepth = depthRec(node.right);
        
        return 1 + Math.max(leftDepth, rightDepth);
    }
    
    public void inorderTraversal() {
        System.out.print("中序遍歷: ");
        inorderRec(root);
        System.out.println();
    }
    
    private void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.val + " ");
            inorderRec(node.right);
        }
    }
    
    public boolean isEmpty() {
        return root == null;
    }

    public int countNodes() {
        return countNodesRec(root);
    }
    
    private int countNodesRec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodesRec(node.left) + countNodesRec(node.right);
    }
    
    public void printStatistics() {
        if (isEmpty()) {
            System.out.println("樹為空！");
            return;
        }
        
        System.out.println("=== 二元樹統計資訊 ===");
        System.out.println("總節點數: " + countNodes());
        System.out.println("所有節點值總和: " + sum());
        System.out.println("最大值: " + findMax());
        System.out.println("最小值: " + findMin());
        System.out.println("葉節點數量: " + countLeaves());
        System.out.println("樹的深度: " + depth());
        inorderTraversal();
        System.out.println();
    }
    
    // 主程式測試
    public static void main(String[] args) {
        // 測試方法1：使用插入建立樹
        System.out.println("=== 使用插入建立二元搜尋樹 ===");
        TreeStatistics tree1 = new TreeStatistics();
        int[] values1 = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        
        for (int val : values1) {
            tree1.insert(val);
        }
        
        tree1.printStatistics();
    }
}