import java.util.Scanner;
public class array {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] array= new int[n][m];
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j]=scanner.nextInt();
            }
        }
        for (int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=array[i][j];
            }
            System.out.printf(sum+" ");
        }
    }
}
