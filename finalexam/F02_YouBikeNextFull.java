import java.util.*;
public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        
        System.out.println("請輸入時間表數量:");
        int n=scanner.nextInt();
        scanner.nextLine();        
        
        int[] times=new int[n];
        String[] timeString=new String[n];
        
        System.out.println("請輸入下一批車抵達時間表:");
        for (int i = 0; i < n; i++) {
            timeString[i]=scanner.nextLine();
            times[i]=timeToMin(timeString[i]);
        }
        
        System.out.println("請輸入查詢時間:");
        String queryTime=scanner.nextLine();
        int queryMinutes=timeToMin(queryTime);
        
        int index=binarySearchNext(times, queryMinutes);
        
        if (index==n) {
            System.out.println("No bike");
        } else {
            System.out.println(timeString[index]);
        }        
        scanner.close();
    }
    
    private static int timeToMin(String time) {
        String[] parts=time.split(":");
        int hours=Integer.parseInt(parts[0]);
        int minutes=Integer.parseInt(parts[1]);
        return hours*60+minutes;
    }
    
    private static int binarySearchNext(int[] arr,int target) {
        int left=0;
        int right=arr.length;
        
        while (left<right) {
            int mid=left+(right-left)/2;
            
            if(arr[mid]<=target) {
                left=mid + 1;
            }else{
                right=mid;
            }
        }
        
        return left;
    }
}
/*
* Time Complexity: O(n)
** 說明：讀取時間表是O(n)
        timeToMinutes()是O(1)
        查詢起點站與終點站是O(1)
        二分搜尋是O(log n)
        計算總共有多少站數是O(1)
        -->O(n)
*/
