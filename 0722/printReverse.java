class ListNode {
    int data;
    ListNode next;
    
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class printReverse {
    
    // 列印整個串列
    public static void printList(ListNode head) {
        // 停止條件：空節點
        if (head == null) {
            return;
        }
        // 處理當前節點，然後遞迴處理下一個
        System.out.print(head.data + " ");
        printList(head.next);
    }
    
    // 反向列印串列（新增功能）
    public static void printReverse(ListNode head) {
        // 停止條件：空節點
        if (head == null) {
            return;
        }
        // 先遞迴到最後一個節點
        printReverse(head.next);
        // 在遞迴返回時列印當前節點
        System.out.print(head.data + " ");
    }
    
    // 計算串列長度
    public static int getLength(ListNode head) {
        // 停止條件：空節點
        if (head == null) {
            return 0;
        }
        // 1（當前節點） + 剩餘節點數量
        return 1 + getLength(head.next);
    }
    
    // 搜尋特定值
    public static boolean search(ListNode head, int target) {
        // 停止條件：空節點（找不到）
        if (head == null) {
            return false;
        }
        // 找到目標值
        if (head.data == target) {
            return true;
        }
        // 遞迴搜尋剩餘節點
        return search(head.next, target);
    }
    
    public static void main(String[] args) {
        // 建立測試串列：1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        System.out.print("串列內容: ");
        printList(head); // 1 2 3 4
        System.out.println();
        
        System.out.print("反向列印: ");
        printReverse(head); // 4 3 2 1
        System.out.println();
        
        System.out.println("串列長度: " + getLength(head)); // 4
        System.out.println("搜尋 3: " + search(head, 3));   // true
        System.out.println("搜尋 5: " + search(head, 5));   // false
        
        // 額外測試不同的串列
        System.out.println("\n測試其他案例:");
        
        // 測試單一節點
        ListNode singleNode = new ListNode(99);
        System.out.print("單一節點正向: ");
        printList(singleNode); // 99
        System.out.println();
        System.out.print("單一節點反向: ");
        printReverse(singleNode); // 99
        System.out.println();
        
        // 測試空串列
        System.out.print("空串列正向: ");
        printList(null);
        System.out.println("(無輸出)");
        System.out.print("空串列反向: ");
        printReverse(null);
        System.out.println("(無輸出)");
    }
}