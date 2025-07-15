import java.util.*;
public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("請輸入停靠站數:");
        int n=scanner.nextInt();
        System.out.println("請輸入停靠站:");
        String[] stations=new String[n];

        for(int i=0;i<n;i++){
            stations[i]=scanner.nextLine();

        }

        System.out.println("請輸入起始站:");
        String start=scanner.nextLine();
        System.out.println("請輸入終點站:");
        String end=scanner.nextLine();

        int startIdx=-1;
        int endIdx=-1;

        for(int i=0;i<n;i++){
            if(stations[i].equals(start)){
                startIdx=i;
            }else{
                System.out.println("Invalid");
            }
            if(stations[i].equals(end)){
                endIdx=i;
            }else{
                System.out.println("Invalid");
            }
        }

        int stopcount=Math.abs(endIdx-startIdx)+1;
        System.out.println(stopcount);

        scanner.close();
        /*
        * Time Complexity: O(n)
        * 說明：線性搜尋的迴圈是一次迴圈-->O(n)
        */
    }
}
