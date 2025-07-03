import java.util.Scanner;
public class year {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        if(x%4==0){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
    }
}
