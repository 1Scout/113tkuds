import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        
        int n=scanner.nextInt();
        scanner.nextLine();

        System.out.println("請輸入所有停靠站代碼:");
        String[] stations=scanner.nextLine().split(" ");
        
        System.out.println("請輸入起點站代碼:");
        String start=scanner.nextLine();
        System.out.println("請輸入終點站代碼:");
        String end = scanner.nextLine();
        
        Map<String, Integer> stationIndex = new HashMap<>();
        for (int i=0;i<n;i++) {
            stationIndex.put(stations[i], i);
        }
        
        Integer startIndex=stationIndex.get(start);
        Integer endIndex=stationIndex.get(end);
        
        if(startIndex==null||endIndex==null){
            System.out.println("Invalid");
        }else{
            int stopCount=Math.abs(startIndex-endIndex)+1;
            System.out.println(stopCount);
        }        
        scanner.close();
    }
}
/*
 * Time Complexity: O(n)
 *  * 說明：HashMap映射是O(n)
            查詢起點站與終點站是O(1)
            計算總共有多少站數是O(1)
            -->O(n)
*/

