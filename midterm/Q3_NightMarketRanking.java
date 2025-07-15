import java.util.*;
public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入Google評分:");
        int n =scanner.nextInt();

        double[] scores=new double[n];
        for(int i = 0; i < n; i++) {
            scores[i]=scanner.nextDouble();
        }

        for(int i=0;i<Math.min(5,n);i++) {
            int maxIdx=i;
            for(int j =i+1;j<n;j++) {
                if(scores[j]>scores[maxIdx]) {
                    maxIdx=j;
                }
            }
            double temp=scores[i];
            scores[i]=scores[maxIdx];
            scores[maxIdx]=temp;
        }

        for (int i = 0;i<Math.min(5,n);i++) {
            System.out.printf("%.1f\n",scores[i]);
        }
        /*
        * Time Complexity: O(n²)
        * 說明：使用雙重迴圈-->O(n²)
        */
    }
}