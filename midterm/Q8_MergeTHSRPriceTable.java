import java.util.*;
public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("請輸入總共幾行:");
        int n=scanner.nextInt();

        String[] station=new String[n];
        int[][] price=new int[n][2];

        for (int i=0;i<n;i++) {
            System.out.println("請輸入車站名稱:");
            station[i]=scanner.next();

            System.out.println("請輸入標準票有幾張:");
            price[i][0]=scanner.nextInt();

            System.out.println("請輸入商務票有幾張:");
            price[i][1]=scanner.nextInt();
            break;
        }

        System.out.println("Station|Standard|Business");
        for (int i=0;i<n;i++) {
            System.out.printf("%s|%d|%d\n",station[i],price[i][0],price[i][1]);
        }
    }
}
