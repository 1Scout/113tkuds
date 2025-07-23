import java.util.*;
public class TreeMirror {
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
    
    public TreeMirror() {
        this.root = null;
    }
    
    public TreeMirror(TreeNode root) {
        this.root = root;
    }
    
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    public TreeNode getRoot() {
        return root;
    }

    public boolean isSymmetric() {
        if (root == null) {
            return true; 
        }
        return isSymmetricRec(root.left, root.right);
    }
    
    private boolean isSymmetricRec(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        
        if (left == null || right == null) {
            return false;
        }
        
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricRec(left.left, right.right) && 
               isSymmetricRec(left.right, right.left);
    }
    
    public void mirrorTree() {
        root = mirrorTreeRec(root);
    }
    
    private TreeNode mirrorTreeRec(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        TreeNode temp = node.left;
        node.left = mirrorTreeRec(node.right);
        node.right = mirrorTreeRec(temp);
        
        return node;
    }

    public static TreeNode copyTree(TreeNode node) {
        if (node == null) return null;
        return new TreeNode(node.val, copyTree(node.left), copyTree(node.right));
    }

    public static boolean areMirrors(TreeNode tree1, TreeNode tree2) {
        return areMirrorsRec(tree1, tree2);
    }
    
    private static boolean areMirrorsRec(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }
        
        if (node1.val != node2.val) {
            return false;
        }
        
        return areMirrorsRec(node1.left, node2.right) && 
               areMirrorsRec(node1.right, node2.left);
    }

    public void printLevelOrder() {
        if (root == null) {
            System.out.println("空樹");
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        System.out.print("層序遍歷: ");
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                System.out.print(current.val + " ");
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }
    
    public void printInorder() {
        System.out.print("中序遍歷: ");
        printInorderRec(root);
        System.out.println();
    }
    
    private void printInorderRec(TreeNode node) {
        if (node != null) {
            printInorderRec(node.left);
            System.out.print(node.val + " ");
            printInorderRec(node.right);
        }
    }
    
    public void printTreeStructure() {
        if (root == null) {
            System.out.println("空樹");
            return;
        }
        
        System.out.println("樹結構:");
        printTreeStructureRec(root, "", true);
    }
    
    private void printTreeStructureRec(TreeNode node, String prefix, boolean isLast) {
        if (node != null) {
            System.out.println(prefix + (isLast ? "└── " : "├── ") + node.val);
            
            if (node.left != null || node.right != null) {
                if (node.left != null) {
                    printTreeStructureRec(node.left, prefix + (isLast ? "    " : "│   "), node.right == null);
                }
                if (node.right != null) {
                    printTreeStructureRec(node.right, prefix + (isLast ? "    " : "│   "), true);
                }
            }
        }
    }
    
    public static boolean areIdentical(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        
        if (tree1 == null || tree2 == null) {
            return false;
        }
        
        return tree1.val == tree2.val && 
               areIdentical(tree1.left, tree2.left) && 
               areIdentical(tree1.right, tree2.right);
    }
    
    public static void main(String[] args) {
        System.out.println("=== 二元樹鏡像操作測試 ===\n");
        System.out.println("--- 對稱性檢查 ---");
        
        TreeNode symmetricRoot = new TreeNode(1);
        symmetricRoot.left = new TreeNode(2);
        symmetricRoot.right = new TreeNode(2);
        symmetricRoot.left.left = new TreeNode(3);
        symmetricRoot.left.right = new TreeNode(4);
        symmetricRoot.right.left = new TreeNode(4);
        symmetricRoot.right.right = new TreeNode(3);
        
        TreeMirror symmetricTree = new TreeMirror(symmetricRoot);
        System.out.println("對稱樹結構:");
        symmetricTree.printTreeStructure();
        System.out.println("是否對稱 (遞歸): " + symmetricTree.isSymmetric());
        
        TreeNode asymmetricRoot = new TreeNode(1);
        asymmetricRoot.left = new TreeNode(2);
        asymmetricRoot.right = new TreeNode(2);
        asymmetricRoot.left.left = new TreeNode(3);
        asymmetricRoot.right.right = new TreeNode(3);
        
        TreeMirror asymmetricTree = new TreeMirror(asymmetricRoot);
        System.out.println("\n非對稱樹結構:");
        asymmetricTree.printTreeStructure();
        System.out.println("是否對稱: " + asymmetricTree.isSymmetric());
        System.out.println();

        System.out.println("--- 鏡像轉換 ---");
        

        TreeNode originalRoot = new TreeNode(1);
        originalRoot.left = new TreeNode(2);
        originalRoot.right = new TreeNode(3);
        originalRoot.left.left = new TreeNode(4);
        originalRoot.left.right = new TreeNode(5);
        originalRoot.right.left = new TreeNode(6);
        
        TreeMirror originalTree = new TreeMirror(originalRoot);
        System.out.println("原始樹:");
        originalTree.printTreeStructure();
        originalTree.printInorder();

        TreeMirror mirrorTree = new TreeMirror(TreeMirror.copyTree(originalTree.getRoot()));
        mirrorTree.mirrorTree();

        System.out.println("鏡像後的樹:");
        mirrorTree.printTreeStructure();
        mirrorTree.printInorder();
        
        System.out.println("--- 兩樹鏡像關係檢查 ---");
        
        System.out.println("原始樹與其鏡像是否互為鏡像: " + 
                          TreeMirror.areMirrors(originalTree.getRoot(), mirrorTree.getRoot()));
        
        System.out.println("原始樹與自己是否互為鏡像: " + 
                          TreeMirror.areMirrors(originalTree.getRoot(), originalTree.getRoot()));
        
        System.out.println("對稱樹與自己是否互為鏡像: " + 
                          TreeMirror.areMirrors(symmetricTree.getRoot(), symmetricTree.getRoot()));
        System.out.println();
    }
}