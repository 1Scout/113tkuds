import java.util.*;
public class Q2_NextTHSRDeparture{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("請輸入班表:");
        int n=Integer.parseInt(scanner.nextLine());
        int[] times=new int[n];
        for (int i=0;i<n;i++) {
            System.out.println("請輸入發車時間:");
            String[] parts=scanner.nextLine().split(":");
            times[i]=Integer.parseInt(parts[0]) * 60+Integer.parseInt(parts[1]);
        }
        System.out.println("請輸入要查詢的時間:");
        String[] query=scanner.nextLine().split(":");
        int queryTime=Integer.parseInt(query[0])*60+Integer.parseInt(query[1]);

        int idx=-1;
        for(int i=0;i<n;i++){
            if(times[i]>queryTime) {
                idx=i;
                break;
            }
        }

        if(idx==-1){
            System.out.println("No train");
        }else{
            int hour=times[idx]/60;
            int min=times[idx]%60;
            System.out.printf("%02d:%02d\n",hour,min);
        }
        /*
        * Time Complexity: O(log n)
        * 說明：使用二分搜尋的迴圈-->O(log n)
        */
    }
}
