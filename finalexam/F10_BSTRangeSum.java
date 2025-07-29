import java.util.*;
public class F10_BSTRangeSum {
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        
        System.out.println("請輸入BST層序序列:");
        String treeInput=scanner.nextLine();
        String[] tokens=treeInput.split(" ");
        
        TreeNode root=buildTreeFromLevelOrder(tokens);
        
        System.out.println("請輸入區間範圍:");
        int L=scanner.nextInt();
        int R=scanner.nextInt();
        
        int rangeSum = rangeSumBST(root,L,R);
        
        System.out.println("RangeSum: "+rangeSum);
        
        scanner.close();
    }
    
    private static TreeNode buildTreeFromLevelOrder(String[] tokens) {
        if (tokens.length == 0 || tokens[0].equals("-1")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        
        int index = 1;
        
        while (!queue.isEmpty() && index < tokens.length) {
            TreeNode current = queue.poll();
            
            if (index < tokens.length) {
                if (!tokens[index].equals("-1")) {
                    current.left = new TreeNode(Integer.parseInt(tokens[index]));
                    queue.offer(current.left);
                }
                index++;
            }
            
            if (index < tokens.length) {
                if (!tokens[index].equals("-1")) {
                    current.right = new TreeNode(Integer.parseInt(tokens[index]));
                    queue.offer(current.right);
                }
                index++;
            }
        }
        
        return root;
    }
    
    private static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        
        if (root.val >= L && root.val <= R) {
            sum += root.val;
            
            sum += rangeSumBST(root.left, L, R);
            sum += rangeSumBST(root.right, L, R);
        }
        
        return sum;
    }

    private static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}
