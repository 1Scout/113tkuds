import java.util.*;
public class F12_TreeDiameter {
    
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
    private static int maxDiameter;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("請輸入二元樹層序序列:");
        String treeInput = scanner.nextLine();
        String[] tokens = treeInput.split(" ");
        
        TreeNode root = buildTreeFromLevelOrder(tokens);
        
        int diameter = calculateDiameter(root);
    
        System.out.println("直徑:" + diameter);
        
        scanner.close();
    }
    
    private static TreeNode buildTreeFromLevelOrder(String[] tokens) {
        if (tokens.length== 0||tokens[0].equals("-1")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        
        int index = 1;
        
        while (!queue.isEmpty()&&index<tokens.length) {
            TreeNode current = queue.poll();
            
            if (index < tokens.length) {
                if (!tokens[index].equals("-1")) {
                    current.left=new TreeNode(Integer.parseInt(tokens[index]));
                    queue.offer(current.left);
                }
                index++;
            }
            
            if (index<tokens.length) {
                if (!tokens[index].equals("-1")) {
                    current.right = new TreeNode(Integer.parseInt(tokens[index]));
                    queue.offer(current.right);
                }
                index++;
            }
        }        
        return root;
    }

    private static int calculateDiameter(TreeNode root) {
        maxDiameter=0;
        calculateHeight(root);
        return maxDiameter;
    }
    private static int calculateHeight(TreeNode node) {
        if (node==null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        
        int currentDiameter = leftHeight + rightHeight;
        
        maxDiameter=Math.max(maxDiameter, currentDiameter);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    static class DiameterResult {
        int diameter;
        int height;
        
        DiameterResult(int diameter, int height) {
            this.diameter=diameter;
            this.height=height;
        }
    }

    private static int calculateDiameterNoGlobal(TreeNode root) {
        return calculateDiameterHelper(root).diameter;
    }

    private static DiameterResult calculateDiameterHelper(TreeNode node) {
        if (node==null) {
            return new DiameterResult(0, 0);
        }
        
        DiameterResult leftResult=calculateDiameterHelper(node.left);
        DiameterResult rightResult=calculateDiameterHelper(node.right);
        
        int currentHeight = Math.max(leftResult.height, rightResult.height) + 1;
        int currentDiameter = leftResult.height + rightResult.height;
        
        int maxDiameter=Math.max(currentDiameter, 
                                  Math.max(leftResult.diameter, rightResult.diameter));
        
        return new DiameterResult(maxDiameter, currentHeight);
    }
}
