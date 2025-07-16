import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("請輸入住戶數量:");
        int n=scanner.nextInt();

        int total=0;
        for (int i=0;i<n;i++) {
            System.out.println("請輸入電費:");
            int kWh=scanner.nextInt();
            int bill=calc(kWh);
            total+=bill;
            System.out.println("Bill:$"+bill);
        }
        int avg=Math.round((float)total/n);
        System.out.println("Total:$"+total);
        System.out.println("Average:$"+avg);
    }

    public static int calc(int kWh) {
        int[] limits={120,330,500,700,1000};
        double[] rates={1.68,2.45,3.70,5.04,6.24,8.46};
        int[] bounds=new int[6];
        bounds[0]=Math.min(kWh,limits[0]);
        for (int i=1;i<5;i++) {
            bounds[i]=Math.max(0,Math.min(kWh-limits[i-1],limits[i]-limits[i-1]));
        }
        bounds[5]=Math.max(0,kWh-limits[4]);

        double sum=0;
        for (int i=0;i<6;i++) {
            sum +=bounds[i]*rates[i];
        }

        return (int)Math.round(sum);
    }
}
/*
* Time Complexity: O(n)
* 說明：第一個for迴圈是O(n)
        calc中的迴圈是O(1)
        -->O(n)
*/