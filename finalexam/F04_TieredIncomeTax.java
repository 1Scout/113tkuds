import java.util.*;
public class F04_TieredIncomeTax {
    
    private static final int[] TAX_BRACKETS={
        560000,1260000,2520000,4720000,Integer.MAX_VALUE
    };
    
    private static final double[] TAX_RATES={
        0.05,0.12,0.20,0.30,0.40
    };
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("請輸入有幾筆資料:");
        int n=scanner.nextInt();
        
        long totalTax=0;
        
        System.out.println("請輸入資料:");
        for (int i=0;i<n;i++) {
            long income=scanner.nextLong();
            long tax=calculateTax(income);
            
            System.out.println("Tax: $" + tax);
            totalTax +=tax;
        }
        
        long averageTax=totalTax/ n;
        System.out.println("Average:$"+averageTax);
        
        scanner.close();
    }
    private static long calculateTax(long income) {
        if (income<=0) {
            return 0;
        }
        
        long tax = 0;
        long remainingIncome = income;
        long previousBracket = 0;
        
        for (int i=0;i<TAX_BRACKETS.length; i++) {

            long bracketIncome=Math.min(remainingIncome, TAX_BRACKETS[i] - previousBracket);
            
            if (bracketIncome<=0) {
                break;
            }
            
            tax += (long)(bracketIncome*TAX_RATES[i]);
            
            remainingIncome -=bracketIncome;
            previousBracket =TAX_BRACKETS[i];
            
            if (remainingIncome<=0) {
                break;
            }
        }
        
        return tax;
    }
}
/*
* Time Complexity:O(n)
** 說明：處理n筆輸入是O(n)
        每次迴圈中的操作都是O(1)
        calculateTax()是O(1)
        -->O(n)
*/
