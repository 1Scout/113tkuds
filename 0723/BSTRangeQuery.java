import java.util.*;

/**
 * BST範圍查詢練習
 * 實作在二元搜尋樹中查找指定範圍內所有節點值的功能
 */
public class BSTRangeQuery {
    
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
    }
    
    private TreeNode root;
    
    // 建構函式
    public BSTRangeQuery() {
        this.root = null;
    }
    
    // 插入節點到BST
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
        // 如果值相等，不插入重複值
        
        return node;
    }
    
    // 主要方法：範圍查詢
    // 返回範圍 [min, max] 內的所有節點值，結果已排序
    public ArrayList<Integer> rangeQuery(int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        if (min > max) {
            return result; // 無效範圍，返回空列表
        }
        rangeQueryRec(root, min, max, result);
        return result;
    }
    
    // 遞歸範圍查詢實作
    private void rangeQueryRec(TreeNode node, int min, int max, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        
        // 利用BST性質進行剪枝優化
        // 如果當前節點值小於最小值，只需搜尋右子樹
        if (node.val < min) {
            rangeQueryRec(node.right, min, max, result);
        }
        // 如果當前節點值大於最大值，只需搜尋左子樹
        else if (node.val > max) {
            rangeQueryRec(node.left, min, max, result);
        }
        // 如果當前節點值在範圍內
        else {
            // 先搜尋左子樹（較小的值）
            rangeQueryRec(node.left, min, max, result);
            // 將當前節點加入結果
            result.add(node.val);
            // 再搜尋右子樹（較大的值）
            rangeQueryRec(node.right, min, max, result);
        }
    }

    public void printTree() {
        System.out.print("BST中序遍歷: ");
        printInorder(root);
        System.out.println();
    }
    
    private void printInorder(TreeNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.val + " ");
            printInorder(node.right);
        }
    }
    
    public void printTreeStructure() {
        if (root == null) {
            System.out.println("空樹");
            return;
        }
        
        System.out.println("BST結構:");
        printTreeStructureRec(root, "", true);
    }
    
    private void printTreeStructureRec(TreeNode node, String prefix, boolean isLast) {
        if (node != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + node.val);
            
            List<TreeNode> children = new ArrayList<>();
            if (node.left != null) children.add(node.left);
            if (node.right != null) children.add(node.right);
            
            for (int i = 0; i < children.size(); i++) {
                boolean isChildLast = (i == children.size() - 1);
                String childPrefix = prefix + (isLast ? "    " : "│   ");
                
                if (children.get(i) == node.left) {
                    printTreeStructureRec(node.left, childPrefix, node.right == null);
                } else {
                    printTreeStructureRec(node.right, childPrefix, true);
                }
            }
        }
    }
    
    public boolean search(int val) {
        return searchRec(root, val);
    }
    
    private boolean searchRec(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        
        if (val == node.val) {
            return true;
        } else if (val < node.val) {
            return searchRec(node.left, val);
        } else {
            return searchRec(node.right, val);
        }
    }
   
    public static void main(String[] args) {

        System.out.println("===題目範例===");
        BSTRangeQuery bst1 = new BSTRangeQuery();
        int[] values1 = {20, 10, 30, 5, 15, 25, 35};
        
        for (int val : values1) {
            bst1.insert(val);
        }
        
        bst1.printTree();
        bst1.printTreeStructure();
        
        ArrayList<Integer> result1 = bst1.rangeQuery(12, 27);
        System.out.println("範圍查詢 [12, 27]: " + result1);
        System.out.println("預期結果: [15, 20, 25]");
        System.out.println("結果正確: " + result1.equals(Arrays.asList(15, 20, 25)));
        System.out.println();
    }
}
        