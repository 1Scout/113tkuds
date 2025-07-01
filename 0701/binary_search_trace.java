import java.util.Scanner;

public class binary_search_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};

        Scanner scanner = new Scanner(System.in);
        System.out.print("輸入要搜尋的數字：");
        int target = scanner.nextInt();

        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("搜尋範圍：left = " + left + ", right = " + right + ", mid = " + mid + " → arr[mid] = " + arr[mid]);

            if (arr[mid] == target) {
                found = true;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //上述用while迴圈代替for迴圈
        //在每次搜尋時都把範圍縮減至一半
        //所以時間複雜度為O(log n)
        //如果改為for迴圈,以多層迴圈實作,效率會慢很多

        if (found) {
            System.out.println("結果：已找到");
        } else {
            System.out.println("結果：未找到");
        }

        scanner.close();
    }
}
