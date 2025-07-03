import java.util.Scanner;
public class circlearea{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        double area=x*x*3.14;
        System.out.printf("%.2f",area);
    }
}