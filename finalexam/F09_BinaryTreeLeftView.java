import java.util.*;

public class F09_BinaryTreeLeftView {
    
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
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("請輸入層序序列");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        
        TreeNode root = buildTreeFromLevelOrder(tokens);
        
        List<Integer> leftView = getLeftView(root);
        
        System.out.print("LeftView:");
        for (int val : leftView) {
            System.out.print(" " + val);
        }
        System.out.println();
        
        scanner.close();
    }
    private static TreeNode buildTreeFromLevelOrder(String[] tokens) {
        if (tokens.length == 0 || tokens[0].equals("-1")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();
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
    
    private static List<Integer> getLeftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize=queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                if (i == 0) {
                    result.add(current.val);
                }
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        
        return result;
    }
}
