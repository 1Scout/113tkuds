import java.util.*;
public class F11_BSTClosestValue {
    
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
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("請輸入BST層序序列:");
        String treeInput = scanner.nextLine();
        String[] tokens = treeInput.split(" ");
        
        TreeNode root = buildTreeFromLevelOrder(tokens);
        
        System.out.println("請輸入目標值:");
        int target = scanner.nextInt();
        
        int closestValue = closestValue(root, target);
        
        System.out.println("ClosestValue: " + closestValue);
        
        scanner.close();
    }
    
    private static TreeNode buildTreeFromLevelOrder(String[] tokens) {
        if (tokens.length==0||tokens[0].equals("-1")) {
            return null;
        }
        
        TreeNode root=new TreeNode(Integer.parseInt(tokens[0]));
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
            

            if(index<tokens.length) {
                if(!tokens[index].equals("-1")) {
                    current.right=new TreeNode(Integer.parseInt(tokens[index]));
                    queue.offer(current.right);
                }
                index++;
            }
        }
        
        return root;
    }

    private static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode current = root;
        
        while (current != null) {
            if (Math.abs(current.val - target) < Math.abs(closest - target)) {
                closest = current.val;
            }
            else if (Math.abs(current.val - target) == Math.abs(closest - target)) {
                closest = Math.min(closest, current.val);
            }
            
            if (target <current.val) {
                current=current.left;
            } else if(target>current.val) {
                current=current.right;
            } else {
                return current.val;
            }
        }
        
        return closest;
    }

    private static int closestValueRecursive(TreeNode root, int target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        
        if (target == root.val) {
            return root.val;
        }
        
        int closest = root.val;
        if (target < root.val && root.left != null) {
            int leftClosest = closestValueRecursive(root.left, target);
            if (Math.abs(leftClosest - target) < Math.abs(closest - target) ||
                (Math.abs(leftClosest - target) == Math.abs(closest - target) && leftClosest < closest)) {
                closest = leftClosest;
            }
        } else if (target > root.val && root.right != null) {
            int rightClosest = closestValueRecursive(root.right, target);
            if (Math.abs(rightClosest - target) < Math.abs(closest - target) ||
                (Math.abs(rightClosest - target) == Math.abs(closest - target) && rightClosest < closest)) {
                closest = rightClosest;
            }
        }
        
        return closest;
    }
}
