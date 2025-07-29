import java.util.*;
public class F06_ArraySecondLargest {
    
    static class MaxPair {
        int max;
        int second;       
        public MaxPair(int max,int second) {
            this.max=max;
            this.second=second;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        
        System.out.println("請輸入陣列大小:");
        int n=scanner.nextInt();
        
        System.out.println("請輸入要存放陣列中的元素:");
        int[] arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=scanner.nextInt();
        }
        
        MaxPair result = findSecondLargestRecursive(arr,0,n-1);
        
        System.out.println("SecondMax:" + result.second);
        
        scanner.close();
    }

    private static MaxPair findSecondLargestRecursive(int[] arr, int left, int right) {       

        int mid=left+(right-left)/2;
        
        MaxPair leftResult =findSecondLargestRecursive(arr,left,mid);
        MaxPair rightResult=findSecondLargestRecursive(arr,mid+1,right);
        
        return mergeMaxPairs(leftResult, rightResult);
    }
    

    private static MaxPair mergeMaxPairs(MaxPair left,MaxPair right) {
        List<Integer> candidates = new ArrayList<>();
        
        candidates.add(left.max);
        if (left.second != Integer.MIN_VALUE) {
            candidates.add(left.second);
        }
        
        candidates.add(right.max);
        if (right.second != Integer.MIN_VALUE) {
            candidates.add(right.second);
        }
        
        candidates.sort(Collections.reverseOrder());
        
        int max = candidates.get(0);
        int second = Integer.MIN_VALUE;
        
        for (int i = 1;i<candidates.size(); i++) {
            if (candidates.get(i) < max) {
                second = candidates.get(i);
                break;
            }
        }
        
        return new MaxPair(max, second);
    }
}
/*
* Time Complexity:O(n)
** 說明：findSecondLargestRecursive()是O(n)
        mergeMaxPairs()是O(1)
        -->O(n)
*/
