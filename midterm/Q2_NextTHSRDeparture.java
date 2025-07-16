import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("請輸入班表:");
        int n=Integer.parseInt(scanner.nextLine());

        int[] times = new int[n];
        for(int i=0;i<n;i++) {
            System.out.println("請輸入發車時間:");
            String[] parts=scanner.nextLine().split(":");
            int hour=Integer.parseInt(parts[0]);
            int min=Integer.parseInt(parts[1]);
            times[i]=hour*60+min;
        }

        Arrays.sort(times);

        System.out.println("請輸入要查詢的時間:");
        String[] query=scanner.nextLine().split(":");
        int queryTime=Integer.parseInt(query[0])*60+Integer.parseInt(query[1]);

        int left=0,right=n-1;
        int answerIdx=-1;

        while(left<=right) {
            int mid=(left+right)/2;
            if(times[mid]>queryTime){
                answerIdx=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        if(answerIdx==-1){
            System.out.println("No train");
        }else{
            int hour=times[answerIdx]/60;
            int min=times[answerIdx]%60;
            System.out.printf("%02d:%02d\n",hour,min);
        }
        scanner.close();
    }
}
/*
* Time Complexity: O(n)
* 說明：第一個for迴圈是O(n)
        第19行是O(n log n)
        第22行是O(1)
        二分搜尋是O(log n)
        -->O(nlog n)
*/