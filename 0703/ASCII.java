import java.util.Scanner;
public class ASCII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0); 
        int ascii = (int) c; 
        System.out.println(ascii);
    }
}
