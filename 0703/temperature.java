import java.util.Scanner;
public class temperature {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y= (x * 9/5) + 32;
        System.out.println(y);
    }
}
