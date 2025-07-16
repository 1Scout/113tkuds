import java.util.*;
public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("請輸入總共幾場:");
        int n =scanner.nextInt();

        int[] game=new int[n];
        System.out.println("請輸入勝敗(1/0):");
        for (int i=0;i<n;i++) {
            game[i]=scanner.nextInt();
        }

        System.out.println("請輸入要查詢的場數:");
        int k=scanner.nextInt();
        int[] prefix=new int[k];
        prefix[0]=game[0];
        for (int i=1;i<k;i++) {
            prefix[i]=prefix[i-1]+game[i];
        }

        System.out.print("PrefixSum:");
        for (int i=0;i<k;i++) {
            System.out.print(" "+prefix[i]);
        }
        System.out.println();
    }
}
/*
* Time Complexity: O(n)
* 說明：第一個for迴圈是O(n)
       第二個for迴圈是O(n)
       第三個for迴圈是O(n)
       -->O(n)
*/
